<?php

include("./DB_connect.php");

$ProductId = $_POST['ProductId'];
$Category = $_POST['Category'];
$MainCategory = $_POST['MainCategory'];
$TaxTarifCode = $_POST['TaxTarifCode'];
$SupplierName = $_POST['SupplierName'];
$WeightMeasure = $_POST['WeightMeasure'];
$WeightUnit = $_POST['WeightUnit'];
$Description = $_POST['Description'];
$Name = $_POST['Name'];
$DateOfSale = $_POST['DateOfSale'];
$ProductPicUrl = $_POST['ProductPicUrl'];
$Status = $_POST['Status'];
$Quantity = $_POST['Quantity'];
$UoM = $_POST['UoM'];
$CurrencyCode = $_POST['CurrencyCode'];
$Price = $_POST['Price'];
$Width = $_POST['Width'];
$Depth = $_POST['Depth'];
$Height = $_POST['Height'];
$DimUnit = $_POST['DimUnit'];
$qrcode = $_POST['qrcode'];

if ($ProductId == "") {
    header('Location: .././index.html ');
}
$sql = 'INSERT INTO `ProductCollection`( `ProductId`, `Category`, `MainCategory`, `TaxTarifCode`,`SupplierName`, `WeightMeasure`, `WeightUnit`, `Description`, `Name`, `DateOfSale`, `ProductPicUrl`, `Status`, `Quantity`, `UoM`, `CurrencyCode`, `Price`, `Width`, `Depth`, `Height`, `DimUnit`, `qrcode`)'.
' VALUES ('.
'"'.$ProductId.'",'.
'"'.$Category.'",'.
'"'.$MainCategory.'",'.
'"'.$TaxTarifCode.'",'.
'"'.$SupplierName.'",'.
'"'.$WeightMeasure.'",'.
'"'.$WeightUnit.'",'.
'"'.$Description.'",'.
'"'.$Name.'",'.
'"'.$DateOfSale.'",'.
'"'.$ProductPicUrl.'",'.
'"'.$Status.'",'.
'"'.$Quantity.'",'.
'"'.$UoM.'",'.
'"'.$CurrencyCode.'",'.
'"'.$Price.'",'.
'"'.$Width.'",'.
'"'.$Depth.'",'.
'"'.$Height.'",'.
'"'.$DimUnit.'",'.
'"'.$qrcode.'")' ;

//   echo $sql;exit();

$result = mysqli_query($dbcon, $sql);
header('Location: .././index.html ');

?>