<?php

$host='localhost';
$user='root';
$pwd='';
$db='studybuddy';

$conn=mysqli_connect($host, $user, $pwd, $db);

if(!$conn)
{
  die("Error in connecting to database: ".mysqli_connect_error());
}
$res=array();

$sql_query="SELECT * FROM units";
$result=mysqli_query($conn, $sql_query);

if(mysqli_num_rows($result)>0)
{
    while($row=mysqli_fetch_assoc($result))
    {
        array_push($res, $row);
    }
}

else
{
    $response['success']=0;
    $response['message']='No data found';
}

echo json_encode($res);
mysqli_close($conn);

?>
