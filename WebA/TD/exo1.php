<?php


function moyenne($notes)
{
$moy=0;
for($i=0;$i<count($notes);$i++)
{
    $moy+=$notes[$i];
}
return $moy/count($notes);
}

function sup10($notes)
{
    $j=0;
    $sup=array();
for($i=0;$i<count($notes);$i++)
{
    if($notes[$i]>=10)
    {
        $sup[$j]=$notes[$i];
        $j++;
    }
}
return $sup;
}

?>