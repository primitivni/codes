<?php 

function presmerovani($new_location) {
	header("Location:".$new_location);
	exit;
}

function overeni($os, $jm, $st, $roc, $tel, $rok) {
    $chyby = 0;

    if(strlen($os) == 9) {
        //echo "V poradku";
    } else {
        echo "Špatně zadané osobní číslo! Je nutné dodržet přesný formát, tzn. 9 znaků.";
        echo "<br>";
        $chyby++;
    }
    if(strlen($st) == 2 || strlen($st) == 3) {
        //echo "V poradku";
    } else {
        echo "Špatně zadaný studijní program! Je nutné dodržet přesný formát, tzn. 3 znaky.";
        echo "<br>";
        $chyby++;
    }
    if(is_numeric($roc) && (($roc > 0) && ($roc < 6))) {
        //echo "V poradku";
    } else {
        echo "Špatně zadaný ročník! Student může studovat max. 5 let, tzn. 1 až 5.";
        echo "<br>";
        $chyby++;
    }
    if(is_numeric($tel) && (strlen((string)$tel) == 9) && ($tel > 0)) {
        //echo "V poradku";
    } else {
        echo "Špatně zadané telefonní číslo! Je nutné dodržet přesný formát, tzn. 9 znaků.";
        echo "<br>";
        $chyby++;
    }
    if(is_numeric($rok) && (strlen((string)$rok) == 4) && ($rok > 0)) {
        //echo "V poradku";
    } else {
        echo "Špatně zadaný rok narození! Je nutné dodržet přesný formát, tzn. 4 znaků.";
        echo "<br>";
        $chyby++;
    }

    if(!$chyby == 0) {
        exit(0);
    }
}
?>