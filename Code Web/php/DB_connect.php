<?php
$dbhost 	= "localhost";
$dbuser 	= "tuser";
$dbpass 	= "1111";
$dbname 	= "testbase_0562";
$charset 	= "utf8";

$dbcon = mysqli_connect($dbhost, $dbuser, $dbpass);

if (!$dbcon) {
    die("Connection failed" . mysqli_connect_error());

}
mysqli_select_db($dbcon,$dbname);
mysqli_set_charset($dbcon,$charset);

?>