<?php require_once('../funkce/session.php');?>
<?php require_once('../funkce/funkce.php');?>
<?php echo AdminAreaAccess(); ?>
<?php
error_reporting(0);
?>

<?php
	include('../dbcon.php');

	$update_record = $_GET['Update'];

	$sql = "select * from studenti where id = '$update_record'";

	$result = mysqli_query($conn,$sql);

	while ($DataRows = mysqli_fetch_assoc($result)) {
        $update_id = $DataRows['id'];
        $Osc = $DataRows['Os_c'];
        $Prijmeni = $DataRows['Prijmeni'];
        $Studprogram = $DataRows['Stud_program'];
        $Rocnik = $DataRows['Rocnik'];
        $Tel_cislo = $DataRows['Tel_cislo'];
        $Rok = $DataRows['Rok_narozeni'];
	}
 ?>

<?php include('../header.php') ?>

<?php include('admin.header.php') ?>
<form action="editovatZaznam.php?update_id=<?php echo $update_id;?>" method="post" enctype="multipart/form-data">
    <table>
        <tr>
            <td>Osobní Číslo:</td>
            <td><input type="text" name="os" placeholder="Osobní číslo" value="<?php echo
                $Osc;?>" required></td>
        </tr>
        <tr>
            <td>Jméno a příjmení:</td>
            <td><input type="text" name="name" placeholder="Celé jméno a příjmení" value="<?php echo
                $Prijmeni?>" required></td>
        </tr>
        <tr>
            <td>Studiní program:</td>
            <td><input type="text" name="program" placeholder="Studijní program" value="<?php echo $Studprogram;?>" required></td>
        </tr>
        <tr>
            <td>Ročník:</td>
            <td><input type="number" name="rocnik" placeholder="Ročník" value="<?php echo $Rocnik;?>" required></td>
        </tr>
        <tr>
            <td>Telefonní číslo:</td>
            <td><input type="number" name="Tel_cislo" placeholder="Telefonní číslo" value="<?php echo $Tel_cislo;?>" required></td>
        </tr>
        <tr>
            <td>Rok narození:</td>
            <td><input type="number" name="Rok_narozeni" placeholder="Rok narození" value="<?php echo $Rok;?>" required></td>
        </tr>
        <tr>
            <td><button type="submit" name="submit">Vložit</button></td>
        </tr>
    </table>
</form>

<?php
	if (isset($_POST['submit'])) {
		if (!empty($_POST['os']) && !empty($_POST['name'])) {
		
			include ('../dbcon.php');
            $id = $_GET['update_id'];
            $os = $_POST['os'];
            $name = $_POST['name'];
            $program = $_POST['program'];
            $rocnik = $_POST['rocnik'];
            $tel_cislo = $_POST['Tel_cislo'];
            $rok = $_POST['Rok_narozeni'];

            overeni($os, $name, $program, $rocnik, $tel_cislo, $rok);

			$sql = "UPDATE studenti SET Os_c = '$os', Prijmeni = '$name', Stud_program ='$program', Rocnik = '$rocnik', Tel_cislo = '$tel_cislo', Rok_narozeni = '$rok' WHERE id = '$id'";

			$Execute = mysqli_query($conn,$sql);

			if ($Execute) {
				 $_SESSION['SuccessMessage'] = "Editace dat proběhla v pořádku.";
                presmerovani("editovatStudenta.php");
			}
		}
	}
 ?>
