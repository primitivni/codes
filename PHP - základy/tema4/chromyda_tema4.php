<!DOCTYPE html>
<meta charset="UTF-8">
<html>
    <body>
        <!-- uvod stranky, zadani, popis -->
        <h1>Téma 4 - úkol - Práce s formuláři </h1>
        <h2>Zadání č. 14:</h2>
        <a>Napište a odlaďte php skript, který určí determinant matice, zadané ve formuláři. Rozměry matice zadejte jako první a dle toho vygenerujte příslušný formulář.<br></a>
        <br>
        <!-- formular pro zadani parametru matice -->
        <form action = "chromyda_tema4.php" method = "post">
            <table>
                <tr>
                    <td>Zadejte počet řádků matice:</td>
                    <td><input type = "text" name = "a" required></td>
                </tr>
                <tr>
                    <td>Zadejte počet sloupců matice:</td>
                    <td><input type = "text" name = "b" required></td>
                </tr>
                <tr>
                    <td><input type = "submit" name = "generovani" value = "Generovani matice"/> </td>
                </tr>
            </table>
        </form>
        <?php
            $a = 0;
            $b = 0;

            //funkce pro overeni spravnosti zadani parametru matice
            function overeni($a, $b){
                if((is_numeric($a) && ($a>0)) && ($a == $b)){
                } else{
                    echo "<br>";
                    echo "Chybné zadání rozměrů matice. Rozměry musí být celočíselné, kladné a větší než 0 a shodné, resp. determinant můžeme určit pouze u čtvercových matic.";
                    exit(0);
                }
            }

            //nacteni, overeni a zformatovani vstupu z formulare
            if (isset($_POST['generovani'])) {
                $a = trim(htmlspecialchars($_POST["a"]));
                $b = trim(htmlspecialchars($_POST["b"]));

                overeni($a, $b);
            }
        ?>

        <!-- formular pro zadani hodnoty bunek matice -->
        <form action = "chromyda_tema4.php" method = "post">
        <?php
            //lehke formatovani formulare pro zadani hodnot bunek matice a tlacitka pro vypocet determinantu
            echo "-------------------------------";
            echo "<br><input type = 'submit' name = 'determinant' value = 'Determinant' style='background: green'>";
            echo "<br>";

            $bunka = array();

            if(isset($bunka)) {
                $bunka = $_POST['bunka'];
            }

            for ($i = 0; $i < $a; $i++) {
                echo "<br>";
                for ($j = 0; $j < $b; $j++) {
                   echo "<input type='text' name='bunka[".$i."][".$j."]' size = '5'>  ";
                }
            }
        ?>
        </form>

        <?php
            //vypocet determinantu matice a nasledne vypsani matice ve formatovanem vystupu jako tabulka
            require_once "Matrix.php";
            require_once "Determinant.php";

            $matrix = new \Matrix\Matrix([]);
            $matrixArray = array();

            echo "<table>";
            for ($i = 0; $i < count($bunka); $i++) {
                echo "<tr>";
                for ($j = 0; $j < count($bunka); $j++) {
                    echo "<td style = 'text-align: center'>". $bunka[$i][$j] ."</td>";
                    $matrixArray[$i][$j] = (float)$bunka[$i][$j];
                }
                echo "</tr>";
            }
            echo "</table>";

            $matrix->buildFromArray($matrixArray);

            echo "Determinant zadané matice je roven: ".$matrix->determinant();
        ?>
    </body>
</html>
