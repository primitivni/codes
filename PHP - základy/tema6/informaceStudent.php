<?php require_once('funkce/session.php');?>
<?php require_once('funkce/funkce.php');?>
<?php include('header.php') ?>

<h2><a href="index.php" class="btn btn-success " style="float: left;">Zpět</a></h2><br>
<h2>Informace o studentovi</h2>

<table class="table table-striped table-bordered table-responsive text-center">
    <tr >
        <th class="text-center">Osobní číslo</th>
        <th class="text-center">Jméno a Příjmení</th>
        <th class="text-center">Studijní program</th>
        <th class="text-center">Ročník</th>
        <th class="text-center">Telefonní číslo</th>
        <th class="text-center">Rok narození</th>
    </tr>
<?php
    include('dbcon.php');

    $info = $_GET['Info'];

    $sql = "select * from studenti where id = '$info'";

    $result = mysqli_query($conn,$sql);

    while ($DataRows = mysqli_fetch_assoc($result)) {
        $Id = $DataRows['id'];
        $Osc = $DataRows['Os_c'];
        $Prijmeni = $DataRows['Prijmeni'];
        $Studprogram = $DataRows['Stud_program'];
        $Rocnik = $DataRows['Rocnik'];
        $Tel_cislo = $DataRows['Tel_cislo'];
        $Rok = $DataRows['Rok_narozeni'];
    }
?>
    <tr>
        <td><?php echo $Osc;?></td>
        <td><?php echo $Prijmeni;?></td>
        <td><?php echo $Studprogram; ?></td>
        <td><?php echo $Rocnik; ?></td>
        <td><?php echo $Tel_cislo; ?></td>
        <td><?php echo $Rok; ?></td>
    </tr>
</table>
