


    <?php
  
$query = $_GET["q"];
include("../php/DB_connect.php");

$titletext ='
{
  "status": "ok",
 "ProductCollection": [';

$sql = "SELECT * FROM `ProductCollection` ";

 $result = mysqli_query($dbcon, $sql);
			
	while ($row = mysqli_fetch_assoc($result)) {
$id   = htmlentities($row['id']);			
$ProductId   = htmlentities($row['ProductId']);
$Category  = htmlentities($row['Category']);
$MainCategory = htmlentities($row['MainCategory']);
$TaxTarifCode = htmlentities($row['TaxTarifCode']);
$SupplierName = htmlentities($row['SupplierName']);		
$WeightMeasure = htmlentities($row['WeightMeasure']);		
$WeightUnit = htmlentities($row['WeightUnit']);	
$Description = htmlentities($row['Description']);	
$Name = htmlentities($row['Name']);		
$DateOfSale = htmlentities($row['DateOfSale']);		
$ProductPicUrle = htmlentities($row['ProductPicUrl']);		
$Status = htmlentities($row['Status']);		
$Quantity = htmlentities($row['Quantity']);		
$UoM = htmlentities($row['UoM']);		
$CurrencyCode = htmlentities($row['CurrencyCode']);		
$Price = htmlentities($row['Price']);	
$Width = htmlentities($row['Width']);	
$Depth = htmlentities($row['Depth']);		
$Height = htmlentities($row['Height']);		
$DimUnit = htmlentities($row['DimUnit']);	
$QrCode = htmlentities($row['qrcode']);


$titletext = $titletext.' {
    "id": "'.$id.'",
    "ProductId": "'.$ProductId.'",
    "Category" : "'.$Category.'",
    "MainCategory": "'.$MainCategory.'",
    "TaxTarifCode" : "'.$TaxTarifCode.'",
    "SupplierName" : "'.$SupplierName.'",
    "WeightMeasure" : "'.$WeightMeasure.'",
    "WeightUnit" : "'.$WeightUnit.'",
    "Description" : "'.$Description.'",
    "Name" : "'.$Name.'",
    "DateOfSale" : "'.$DateOfSale.'",
    "ProductPicUrl" : "'.$ProductPicUrle.'",
    "Status" : "'.$Status.'",
    "Quantity" : "'.$Quantity.'",
    "UoM" : "'.$UoM.'",
    "CurrencyCode" : "'.$CurrencyCode.'",
    "Price" : "'.$Price.'",
    "Width" : "'.$Width.'",
    "Depth" : "'.$Depth.'",
    "Height" : "'.$Height.'",
    "DimUnit" : "'.$DimUnit.'",
    "qrcode": "'.$QrCode.'"
},';
			
			};
$titletext = 	substr_replace($titletext ,"",-1);
$titletext = $titletext.']}';	
$myArray = json_decode($titletext);
header('Content-Type: application/json');
echo json_encode($myArray);
			
			
					
					?>
