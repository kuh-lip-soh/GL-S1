<?xml version="1.0" encoding="UTF-8"?>

<!-- New document created with EditiX at Sun Oct 02 10:22:24 GMT+01:00 2022 -->

<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
	<xsl:template match="/">
		<xsl:for-each select="Etudiants/Etudiant/Carte">
			<p>
				<xsl:value-of select="Nom" />
				<xsl:value-of select="Prenom" />
				-
				<xsl:value-of select="NumeroCarte" />
			</p>
		</xsl:for-each>
	</xsl:template>

</xsl:stylesheet>