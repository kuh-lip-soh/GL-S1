for $v in //hotels/hotel
where $v/Adresse/@code="13000"
return concat($v/Nom,", ",$v/Adresse)