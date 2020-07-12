<?php

define ('DB_HOST','localhost');
define ('DB_USER','root');
define ('DB_PASS','');
define ('DB_NAME', 'studybuddy');


$conn=new mysqli(DB_HOST,DB_USER,DB_PASS,DB_NAME);

if(mysqli_connect_errno())
{
  die('Unable to connect to the database'.mysqli_connect_error());

}

$stmt=$conn->prepare("SELECT unit_name,lecturer,lecturer_email,unit_progress FROM units; ");
$stmt->execute();
$stmt->bind_result($unit_name,$lecturer,$lecturer_email,$unit_progress);
$unit=array();
while($stmt->fetch())
{
  $temp=array();
  $temp['user_name']=$unit_name;
  $temp['lecturer']=$lecturer;
  $temp['lecturer_email']=$lecturer_email;
  $temp['unit_progress']=$unit_progress;
  array_push($unit,$temp);
}

echo json_encode($unit);


 ?>
