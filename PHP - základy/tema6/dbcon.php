<?php
$conn = mysqli_connect('localhost','root','','epo');
if (!$conn) {
    echo "Připojení selhalo " . mysqli_connect_error()."<br>";
    echo "Error: " . mysqli_connect_errno();
    } else {
        //echo "Připojeno k databazi";
    }
 ?>