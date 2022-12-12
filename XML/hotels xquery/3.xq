count (for $v in //hotels/hotel
where $v/chambres/chambre/@type="simple"
and $v/chambres/chambre/@type="double"
return $v)