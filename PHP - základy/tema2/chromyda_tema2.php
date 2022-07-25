<!DOCTYPE html>
<meta charset="UTF-8">
<html>
    <body>
        <h1>Téma 2 - úkol - Základy PHP</h1>
        <h2>Zadání č. 11:</h2>
        <a>Napište a odlaďte php skript, který vypíše všechny možné kombinace k čísel z n čísel bez opakování. Čísla k i n jsou zadány jako konstanty v programu.<br></a>
        <br>
            <?php
                echo "Počet prvků: 4 (n = 4)" . "<br>";
                echo "Kombinace z k čísel: 2 (k = 2)" . "<br>";
                echo "<br>";

                //funkce pro vypis kombinaci
                function vypisKombinace($prvkyN, $n, $k) {
                    $pom = array();
                    kombinace($prvkyN, $pom, 0, $n - 1, 0, $k);
                }

                //funkce pro vytvoreni kombinaci k ze zadanych n prvku
                function kombinace($prvkyN, $pom, $prvni, $posledni, $index, $k) {
                    if ($index == $k) {
                      for ($i = 0; $i < $k; $i++) {
                          echo $pom[$i]." ";
                      }
                        echo "<br>";
                        return;
                    }

                    for ($i = $prvni; $i <= $posledni && $posledni - $index + 1 >= $k - $index; $i++) {
                        $pom[$index] = $prvkyN[$i];
                        //rekurzivni volani funkce kombinace
                        kombinace($prvkyN, $pom, $i + 1, $posledni, $index + 1, $k);
                    }
                }

                //n prvky pro kombinace
                const A = 1;
                const B = 2;
                const C = 3;
                const D = 4;
                $prvkyN = array(A, B, C, D);

                //pocet prvku pro kombinace
                $n = sizeof($prvkyN);

                //pocet k pro kombinace
                const K = 2;
                $k = K;

                //vypis
                echo "Kombinace:" . "<br>";
                vypisKombinace($prvkyN, $n, $k);
            ?>
    </body>
</html>
