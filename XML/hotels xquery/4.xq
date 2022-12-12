for $v in //hotels/hotel
return (
  if ($v/@nbrEtoile>=4)
then concat($v/Nom," est un hotel deluxe")
else concat($v/Nom," est un hotel normal")
)