<?php 

include('../dbcon.php');

$odstranit = $_GET['Delete'];

$sql = "delete  from `studenti` where id = $odstranit";

$result = mysqli_query($conn,$sql);

if ($result) {
	echo '<script>window.open("odstranitStudenta.php?deleted=Student smazán z databáze","_self")</script>';
}

 ?>