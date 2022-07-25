<?php
class Stavebko {

    public $vklad = 0;
    public $urok = 0;
    public $doba = 0;
    public $cc = 0;
    public $poplatek = 0;
    public $poplatekCelkem = 0;
    public $vedeni = 0;
    public $vedeniCelkem = 0;
    public $celkem = 0;
    public $statniPrispevek = 0;
    public $dane = 0;

    public function __construct(array $pole) {
        $this->vklad = $pole[0]*12;
        $this->urok = $pole[1];
        $this->doba = $pole[2];
        $this->poplatek = $pole[3];
        $this->vedeni = $pole[4];
        $this->funkce();
    }

    function funkce() {
        $this->vypis();
        $this->celkem = $this->sporeni($this->vklad, $this->urok, $this->doba, 1);
        $this->poplatkyDane();
        $this->dopCC();
        $this->poplatkyJednoraz();
        echo "---------------------------------";
        echo "<br>";
        echo "Vklady celkem: ".number_format($this->vklad*$this->doba, 2, ".", " ").",- Kč";
        echo "<br>";
        echo "Státní příspěvek celkem: ".number_format($this->statniPrispevek, 2, ".", " ").",- Kč";
        echo "<br>";
        echo "Daň z výnosů (15%): ".number_format($this->dane, 2, ".", " ").",- Kč.";
        echo "<br>";
        echo "Dopučená cílová částka: ".number_format($this->cc, 2, ".", " ").",- Kč.";
        echo "<br>";
        echo "Poplatky za vedení účtu celkem: ".number_format($this->vedeniCelkem, 2, ".", " ").",- Kč.";
        echo "<br>";
        echo "Jednorázový poplatek celkem: ".number_format($this->poplatekCelkem, 2, ".", " ").",- Kč.";
        echo "<br>";
        echo "---------------------------------";
        echo "<br>";
        echo "Stav investičního účtu stavebního spoření na konci spoření: ".number_format($this->celkem, 2, ".", " ")." ,- Kč.";
    }

    function sporeni($vklad, $urok, $doba, $n) {
        $vysledek = 0;
        if ($doba > 1){
            $vysledek = $this->sporeni($vklad, $urok, $doba-1, $n);
        }
        $vysledek += $vklad;
        $vysledek += $this->prispevek();
        $vysledek -= $this->poplatkyVedeni();
        $vysledek = $vysledek * pow(1 + $urok/(100 * $n), $n);
        return $vysledek;
    }

    function prispevek() {
        $pom = $this->vklad / 20000;
        $prispevek = 0;
        if($pom <= 1) {
            $prispevek = $pom * 2000;
        } else if($pom > 1) {
            $prispevek = 1 * 2000;
        }
        $this->statniPrispevek += $prispevek;
        return $prispevek;
    }

    function poplatkyDane() {
        $this->dane = 0;
        $this->dane = $this->celkem - ($this->vklad*$this->doba + $this->statniPrispevek);
        $this->dane = $this->dane* 0.15;
    }

    //dopucena cislova castka, pro minimalizaci poplatků, z důvodu hrazení jednorázového poplatku v % z cílové částky, tak aby to bylo proklientsky výhodné
    function dopCC() {
        $this->cc = ceil(($this->celkem/1000));
        $this->cc = $this->cc * 1000;
    }

    function poplatkyVedeni() {
        $pomVedeni = 0;
        $pomVedeni = $this->vedeni*12;
        $this->vedeniCelkem += $pomVedeni;
        return $pomVedeni;
    }

    function poplatkyJednoraz() {
        $this->poplatekCelkem = $this->cc * ($this->poplatek/100);
    }

    public function vypis() {
        echo "Měsíční vklad: ".$this->vklad/12;
        echo "<br>";
        echo "Roční vklad: ".$this->vklad;
        echo "<br>";
        echo "Roční úroková sazba: ".$this->urok;
        echo "<br>";
        echo "Doba spoření: ".$this->doba;
        echo "<br>";
    }
}
?>