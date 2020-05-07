<?php
$jsonurl = "http://yujbs.com/prj/F6547/app/apk_product.php?q=1";
  $json = file_get_contents($jsonurl);
 

          $file = fopen('../store_card.json','w');
          fwrite($file, $json);
          fclose($file);
        
        header('Location: .././index.html ');

        ?>