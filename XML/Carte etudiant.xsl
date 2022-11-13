<?xml version="1.0" encoding="UTF-8"?>

<!-- New document created with EditiX at Sun Oct 02 10:22:24 GMT+01:00 2022 -->

<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
	<xsl:template name="SommeNote">
		<xsl:param name="a" select="0"/>
		<xsl:param name="b" select="0"/>
		<xsl:param name="c" select="0"/>
		<xsl:value-of select="$a+$b+$c"/>
	</xsl:template>

	<xsl:template match="/">
		<xsl:for-each select="//Etudiant">
			<p>
				<xsl:value-of select="Carte/Nom" />
				<xsl:value-of select="Carte/Prenom" />
				- Moyenne :
				<xsl:value-of select="Carte/Filliere/Moyenne"/>
				- Sommes des notes :
				<xsl:call-template name="SommeNote">
					<xsl:with-param name="a" select="Carte/Filliere/Note[1]"/>
					<xsl:with-param name="b" select="Carte/Filliere/Note[2]"/>
					<xsl:with-param name="c" select="Carte/Filliere/Note[3]"/>
				</xsl:call-template>
				- Carte :
				<xsl:value-of select="Carte/NumeroCarte" />
			</p>
		</xsl:for-each>
		<p><br/><br/>
			Les etudiants admis :
		</p>
		<xsl:for-each select="//Etudiant">
		<xsl:if test="Carte/Filliere[Moyenne &gt;= 10]">
			<xsl:value-of select="Carte/Nom"/>
			<xsl:value-of select="Carte/Prenom"/>
			-
			<xsl:value-of select="Carte/Filliere/Moyenne"/>
			<br/>
		</xsl:if>		
		</xsl:for-each>

		<br/><br/>

		<xsl:for-each select="//Etudiant">
		<xsl:choose>
			<xsl:when test="Carte/Filliere[Moyenne &gt;= 16]">
			Très bien - 
				<xsl:value-of select="Carte/Nom"/>
				<xsl:value-of select="Carte/Prenom"/>
				<br/>
			</xsl:when>
			<xsl:when test="Carte/Filliere[Moyenne &gt;= 14]">
			Bien - 
				<xsl:value-of select="Carte/Nom"/>
				<xsl:value-of select="Carte/Prenom"/>
				<br/>
			</xsl:when>
			<xsl:when test="Carte/Filliere[Moyenne &gt;= 12]">
			Assez bien - 
				<xsl:value-of select="Carte/Nom"/>
				<xsl:value-of select="Carte/Prenom"/>
				<br/>
			</xsl:when>
			<xsl:when test="Carte/Filliere[Moyenne &gt;= 10]">
			Admis - 
				<xsl:value-of select="Carte/Nom"/>
				<xsl:value-of select="Carte/Prenom"/>
				<br/>
			</xsl:when>
			<xsl:otherwise>
			Non admis - 
				<xsl:value-of select="Carte/Nom"/>
				<xsl:value-of select="Carte/Prenom"/>
				<br/>
			</xsl:otherwise>
		</xsl:choose>
		</xsl:for-each>
	</xsl:template>

	
</xsl:stylesheet>