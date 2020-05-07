<?php

function generateRandomString($length = 10) {
    $characters = 'abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ';
    $charactersLength = strlen($characters);
    $randomString = '';
    for ($i = 0; $i < $length; $i++) {
        $randomString .= $characters[rand(0, $charactersLength - 1)];
    }
    return $randomString;
}

function generateRandomId($length = 10) {
    $characters = '0123456789abcdef';
    $charactersLength = strlen($characters);
    $randomId = '';
    for ($i = 0; $i < $length; $i++) {
        $randomId .= $characters[rand(0, $charactersLength - 1)];
    }
    return $randomId;
}


function generateRandomVal($length = 10) {
    $characters = '123456789';
    $charactersLength = strlen($characters);
    $randomVal = '';
    for ($i = 0; $i < $length; $i++) {
        $randomVal .= $characters[rand(0, $charactersLength - 1)];
    }
    return $randomVal;
}

?>