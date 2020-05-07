<?php
include("./DB_connect.php");

$author = $_POST['author'];
$sql = 'INSERT INTO `Author`(  `name`)'.
' VALUES ('.
'"'.$author.'")' ;
$result = mysqli_query($dbcon, $sql);
header('Location: .././index.html ');

?>