<!DOCTYPE html>
<meta charset="UTF-8">
<html>
    <head>
        <h1>Téma 8 - úkol - Práce s objekty</h1>
        <h2>Zadání č. 15:</h2>
        <a>Vytvořte třídu realizující kalkulátor stavebního spoření. Ověřte funkčnost vytvořením objektu a ukázkou jeho možností.<br><br>   </a>
    </head>
    <body>
        <form method="post" action="chromyda_tema8.php">
        <table>
            <tr>
                <td>Měsíční úložka: </td>
                <td><input type="text" name="vklad" placeholder="Měsíční úložka v Kč" required></td>
                <td>!Doporučení! Pro maximalizaci státního příspěvku je dopoučena měsíční úložka ve výši 1 667,- Kč a více, resp. roční úložka více jak 20 000,- Kč</td>
            </tr>
            <tr>
                <td>Úroková sazba v %: </td>
                <td><input type="text" name="urok" placeholder="Úroková sazba p.a. v %" required></td>
            </tr>
            <tr>
                <td>Doba spoření: </td>
                <td><input type="text" name="doba" placeholder="Doba spoření v letech" required></td>
            </tr>
            <tr>
                <td>Poplatek z cílové částky v %: </td>
                <td><input type="text" name="poplatek" placeholder="Poplatek z částky v %" required></td>
            </tr>
            <tr>
                <td>Měsíční poplatek za vedení účtu: </td>
                <td><input type="text" name="vedeni" placeholder="Měsíční poplatek v Kč" required></td>
            </tr>
            <tr>
                <td colspan="2"><input type="submit" name="uroceni" value="Hodnota investičního účtu stavebního spoření"/> </td>
            </tr>
        </table>
        </form>
    <?php
        include("stavebniSporeni.php");

        $pole = array();

        if (isset($_POST['uroceni'])) {
            $pomVklad = trim(htmlspecialchars($_POST['vklad']));
            $pomUrok = trim(htmlspecialchars($_POST['urok']));
            $pomDoba = trim(htmlspecialchars($_POST['doba']));
            $pomPoplatek = trim(htmlspecialchars($_POST['poplatek']));
            $pomVedeni = trim(htmlspecialchars($_POST['vedeni']));

            overeni($pomVklad, $pomUrok, $pomDoba, $pomPoplatek, $pomVedeni);

            $pole[0] = $pomVklad;
            $pole[1] = $pomUrok;
            $pole[2] = $pomDoba;
            $pole[3] = $pomPoplatek;
            $pole[4] = $pomVedeni;

            $stavebko = new Stavebko($pole);
        }

        function overeni($pomVklad, $pomUrok, $pomDoba, $pomPoplatek, $pomVedeni) {
            $chyby = 0;
            if (is_numeric($pomVklad) && ($pomVklad > 0)) {
               //
            } else {
                echo "Chybně zadán formát vkladu. Musí být celočíselný a větší než 0.";
                echo "<br>";
                $chyby++;
            }
            if (is_numeric($pomUrok) && ($pomUrok > 0) && ($pomUrok <= 5)) {
                //
            } else {
                echo "Chybně zadán formát úroku. Musí být větší než 0% a měnší než 5%. Vyšší úrok není nabízený u stavebního spoření.";
                echo "<br>";
                $chyby++;
            }
            if (is_numeric($pomDoba) && ($pomDoba >= 1) && ($pomDoba <= 12)) {
                //
            } else {
                echo "Chybně zadán formát doby. Musí být delší než 1 rok a kratší než 12 let. Delší nebo katší dobu spoření stavební spoření neposkytuje.";
                echo "<br>";
                $chyby++;
            }
            if (is_numeric($pomPoplatek) && ($pomPoplatek >= 1) && ($pomPoplatek <= 5)) {
                //
            } else {
                echo "Chybně zadán formát poplatku. Jednorázový poplatek je standartně ve výši 1% až 5% z cílové částky.";
                echo "<br>";
                $chyby++;
            }
            if (is_numeric($pomVedeni) && ($pomVedeni >= 0) && ($pomVedeni <= 250)) {
                //
            } else {
                echo "Chybně zadán formát poplatku za vedení účtu. Poplatek za vedení účtu je standartně od 0,- Kč až 250,- Kč měsíčně.";
                echo "<br>";
                $chyby++;
            }

            if(!$chyby == 0) {
                exit(0);
            }
        }
    ?>
    </body>
</html>
