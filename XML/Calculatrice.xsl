<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">

<xsl:template name="Somme">
	<xsl:param name="a" select="0"/>
	<xsl:param name="b" select="0"/>
	<xsl:value-of select="$a"/>
	<xsl:text>  +  </xsl:text>
	<xsl:value-of select="$b"/>
	<xsl:text>   =  </xsl:text>
	<xsl:value-of select="$a + $b"/>
	<xsl:text>.</xsl:text>
</xsl:template>

<xsl:template name="Multiplication">
	<xsl:param name="a" select="0"/>
	<xsl:param name="b" select="0"/>
	<xsl:value-of select="$a"/>
	<xsl:text>  x  </xsl:text>
	<xsl:value-of select="$b"/>
	<xsl:text>   =  </xsl:text>
	<xsl:value-of select="$a * $b"/>
	<xsl:text>.</xsl:text>
</xsl:template>

<xsl:template name="Division">
	<xsl:param name="a" select="0"/>
	<xsl:param name="b" select="1"/>
	<xsl:value-of select="$a"/>
	<xsl:text>  /  </xsl:text>
	<xsl:value-of select="$b"/>
	<xsl:text>   =  </xsl:text>
	<xsl:value-of select="$a div $b"/>
	<xsl:text>.</xsl:text>
	</xsl:template>
	
<xsl:template name="Soustraction">
	<xsl:param name="a" select="0"/>
	<xsl:param name="b" select="0"/>
	<xsl:value-of select="$a"/>
	<xsl:text>  -  </xsl:text>
	<xsl:value-of select="$b"/>
	<xsl:text>   =  </xsl:text>
	<xsl:value-of select="$a - $b"/>
	<xsl:text>.</xsl:text>
</xsl:template>

<xsl:output method="html"/>
<xsl:template match="/">
	<html>
		<body>
			<xsl:for-each select="//Calcul">
				<xsl:choose>
					<xsl:when test="Operation = '+'">
						<h3>Somme  :</h3>
						<xsl:call-template name="Somme">
							<xsl:with-param name="a" select="Valeurs/Valeur[1]/@Val"/>
							<xsl:with-param name="b" select="Valeurs/Valeur[2]/@Val"/>
						</xsl:call-template>
					</xsl:when>
					<xsl:when test="Operation ='-'">
						<h3>Soustraction  :</h3>
						<xsl:call-template name="Soustraction">
							<xsl:with-param name="a" select="Valeurs/Valeur[1]/@Val"/>
							<xsl:with-param name="b" select="Valeurs/Valeur[2]/@Val"/>
						</xsl:call-template>
					</xsl:when>
					<xsl:when test="Operation ='*'">
						<h3>Multiplication  :</h3>
						<xsl:call-template name="Multiplication">
							<xsl:with-param name="a" select="Valeurs/Valeur[1]/@Val"/>
							<xsl:with-param name="b" select="Valeurs/Valeur[2]/@Val"/>
						</xsl:call-template>
					</xsl:when>
					<xsl:when test="Operation ='/'">
						<h3>Division  :</h3>
						<xsl:call-template name="Division">
							<xsl:with-param name="a" select="Valeurs/Valeur[1]/@Val"/>
							<xsl:with-param name="b" select="Valeurs/Valeur[2]/@Val"/>
						</xsl:call-template>
					</xsl:when>
					<xsl:otherwise>
						<p>Aucune operation</p>
					</xsl:otherwise>
				</xsl:choose>
			</xsl:for-each>
		</body>
	</html>
</xsl:template>
</xsl:stylesheet>
