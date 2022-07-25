<?php include('header.php');?>
<h2><a href="login.php" class="btn btn-info btn-lg">Prihlaseni</a></h2>
<h2>Databáze studentů</h2>

<form action="index.php" method="post">
    <input type="text" name="stud_program" placeholder="Zadejte zkratku studijního programu, např. IM, PE, MR" size="50"> a / nebo
    <select name="rocnik" class="btn btn-info" >
        <option>Zvolte ročník</option>
        <option>1</option>
        <option>2</option>
        <option>3</option>
        <option>4</option>
        <option>5</option>
    </select>
    <input type="submit" name="filtr" value="Filtrovat">
</form>

<table class="table table-striped table-bordered table-responsive text-center">
    <tr >
        <th class="text-center">Jméno a Příjmení</th>
        <th class="text-center">Studijní program</th>
        <th class="text-center">Ročník</th>
    </tr>
<?php 
    include('dbcon.php');
    if (isset($_POST['filtr'])) {

        $rocnik = $_POST['rocnik'];
        $stud_program = $_POST['stud_program'];

        $sql = "SELECT * FROM `studenti` WHERE `Rocnik` = '$rocnik' OR `Stud_program`='$stud_program'";

        $result = mysqli_query($conn,$sql);

        if (mysqli_num_rows($result)>0) {
            while ($DataRows = mysqli_fetch_assoc($result)) {
                $Id = $DataRows['id'];
                $Prijmeni = $DataRows['Prijmeni'];
                $Studprogram = $DataRows['Stud_program'];
                $Rocnik = $DataRows['Rocnik'];
                ?>
                <tr>
                    <td><?php echo "<a href='informaceStudent.php?Info=$Id'>" . $Prijmeni;?></td>
                    <td><?php echo $Studprogram; ?></td>
                    <td><?php echo $Rocnik; ?></td>
                </tr>
                <?php
            }
        } else {
            echo "<tr><td colspan ='7' class='text-center'>Žádný nález v databázi</td></tr>";
        }
    }
 ?>
</table>
