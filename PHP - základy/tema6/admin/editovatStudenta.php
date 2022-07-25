<?php require_once('../funkce/session.php');?>
<?php require_once('../funkce/funkce.php');?>
<?php echo AdminAreaAccess(); ?>
<?php include('../header.php') ?>
<?php include('admin.header.php') ?>
<?php
    echo  ErrorMessage();
    echo  SuccessMessage();
 ?>

<table>
	<h2 class="text-center">Úprava studentova informací</h2>
	<tr>
        <th class="text-center">Osobní číslo</th>
        <th class="text-center">Jméno a Příjmení</th>
        <th class="text-center">Studijní program</th>
        <th class="text-center">Ročník</th>
	</tr>

<?php 
	include('../dbcon.php');

    $sql = "SELECT * FROM `studenti`";

    $result = mysqli_query($conn,$sql);

    if (mysqli_num_rows($result)>0) {
        while ($DataRows = mysqli_fetch_assoc($result)) {
            $Id = $DataRows['id'];
            $Osc = $DataRows['Os_c'];
            $Prijmeni = $DataRows['Prijmeni'];
            $Studprogram = $DataRows['Stud_program'];
            $Rocnik = $DataRows['Rocnik'];
            ?>
            <tr>
                <td><?php echo $Osc;?></td>
                <td><?php echo "<a href='../informaceStudent.php?Info=$Id'>" . $Prijmeni;?></td>
                <td><?php echo $Studprogram; ?></td>
                <td><?php echo $Rocnik; ?></td>
                <td><a href="editovatZaznam.php?Update=<?php echo $Id; ?>" class="btn btn-warning">Editovat</a></td>
            </tr>
            <?php
        }
    }
 ?>
</table>
<h2><?php echo @$_GET['updated']; ?></h2>

