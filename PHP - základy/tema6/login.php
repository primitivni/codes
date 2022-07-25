<?php session_start();?>
<?php include('header.php');?>
<h2><a href="index.php" class="btn btn-success " style="float: left;">Zpět</a></h2><br>
<h2>Admin přihlášení</h2>
<form action="login.php" method="post">
    <table>
        <tr>
            <td>Username:</td>
            <td><input type="text" name="user" placeholder="Jméno" required></td>
        </tr>
        <tr>
            <td>Password:</td>
            <td><input type="password" name="password" placeholder="Heslo" required></td>
        </tr>
        <tr>
            <td><input type="submit" name="login" value="Přihlásit"> </td>
        </tr>
    </table>
</form>

<?php
    include ('dbcon.php');

    if (isset($_POST['login'])) {
        $username = $_POST['user'];
        $password = $_POST['password'];

        $sql = "SELECT * FROM admin WHERE username='$username' AND password='$password'";
        
        $run  = mysqli_query($conn, $sql);
        $row = mysqli_num_rows($run);

        if($row > 0) {
         $data = mysqli_fetch_assoc($run);
                    $id= $data['id'];
                    $_SESSION['uid'] = $id;
                    header('location:admin/adminMenu.php');
        } else {
      ?>             
    <script>
        alert('Špatně zadané přihlašovací údaje!');
        window.open('login.php','_self');
    </script>
    <?php
                }
}
?>

