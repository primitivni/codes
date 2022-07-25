<?php require_once('../funkce/session.php');?>
<?php require_once('../funkce/funkce.php');?>
<?php echo AdminAreaAccess(); ?>

<?php include('../header.php') ?>

<h2 >Admin menu</h2>
<h2><a href="odhlasit.php">Odhlásit</a></h2>

<a href="pridatStudenta.php">Vložit studenta</a><br><br>
<a href="editovatStudenta.php">Editovat studenta</a><br><br>
<a href="odstranitStudenta.php">Odebrat studenta</a>
