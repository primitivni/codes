<?php require_once('../funkce/session.php');?>
<?php require_once('../funkce/funkce.php');?>
<?php echo AdminAreaAccess(); ?>
<?php include('../header.php') ?>
<?php include('admin.header.php') ?>

<h2 class="text-center">Zadejte informace o studentovi</h2>
<form action="<?php echo htmlspecialchars($_SERVER["PHP_SELF"]);?>" method="post" enctype="multipart/form-data">
<table>
    <tr>
        <td>Osobní Číslo:</td>
        <td><input type="text" name="os" placeholder="Osobní číslo" required></td>
    </tr>
    <tr>
        <td>Jméno a příjmení:</td>
        <td><input type="text" name="name" placeholder="Celé jméno a příjmení" required></td>
    </tr>
    <tr>
        <td>Studiní program:</td>
        <td><input type="text" name="program" placeholder="Studijní program" required></td>
    </tr>
    <tr>
        <td>Ročník:</td>
        <td><input type="number" name="rocnik" placeholder="Ročník" required></td>
    </tr>
    <tr>
        <td>Telefonní číslo:</td>
        <td><input type="number" name="Tel_cislo" placeholder="Telefonní číslo" required></td>
    </tr>
    <tr>
        <td>Rok narození:</td>
        <td><input type="number" name="Rok_narozeni" placeholder="Rok narození" required></td>
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

			$os = $_POST['os'];
			$name = $_POST['name'];
            $program = $_POST['program'];
            $rocnik = $_POST['rocnik'];
            $tel_cislo = $_POST['Tel_cislo'];
            $rok = $_POST['Rok_narozeni'];

            overeni($os, $name, $program, $rocnik, $tel_cislo, $rok);

			$sql = "INSERT INTO `studenti`(`Os_c`, `Prijmeni`, `Stud_program`, `Rocnik`, `Tel_cislo`, `Rok_narozeni` ) VALUES ('$os', '$name', '$program', '$rocnik', '$tel_cislo', '$rok')";

            $run = mysqli_query($conn,$sql);

			if ($run == true) {
                ?>
				<script>
					alert("Student byl úspěšně vložen.");
				</script>
				<?php
			} else {
				echo "Error : ".$sql."<br>". mysqli_error($conn); 
			}
		} else {
				?>
				<script>
					alert("Nezadali jste správně údaje. Zadejte je znovu.");
				</script>
				<?php
		}
	}

 ?>








