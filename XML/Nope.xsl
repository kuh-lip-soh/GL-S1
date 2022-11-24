<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">

<xsl:template name="addition">
		<xsl:param name="a" select="0"/>
		<xsl:param name="b" select="0"/>
		<xsl:value-of select="$a+$b"/>
</xsl:template>
<xsl:template name="soustraction">
		<xsl:param name="a" select="0"/>
		<xsl:param name="b" select="0"/>
		<xsl:value-of select="$a-$b"/>
</xsl:template>
<xsl:template name="multiplication">
		<xsl:param name="a" select="0"/>
		<xsl:param name="b" select="0"/>
		<xsl:value-of select="$a*$b"/>
</xsl:template>
<xsl:template name="division">
		<xsl:param name="a" select="0"/>
		<xsl:param name="b" select="1"/>
		<xsl:value-of select="$a div $b"/>
</xsl:template>

<xsl:output method="html" encoding="UTF-8"/>
<xsl:template match="/">
<html>
    <body>
    <xsl:for-each select="//Calcul">
    <p>
    <xsl:value-of select="Valeur[1]"/>
    <xsl:value-of select="@operation"/>
    <xsl:value-of select="Valeur[2]"/>
    <xsl:text> = </xsl:text>
    <xsl:choose>
    <xsl:when test="@operation='+'">
        <xsl:call-template name="addition">
					<xsl:with-param name="a" select="Valeur[1]"/>
					<xsl:with-param name="b" select="Valeur[2]"/>
		</xsl:call-template>
    </xsl:when>
    <xsl:when test="@operation='-'">
        <xsl:call-template name="soustraction">
					<xsl:with-param name="a" select="Valeur[1]"/>
					<xsl:with-param name="b" select="Valeur[2]"/>
		</xsl:call-template>
    </xsl:when>
    <xsl:when test="@operation='*'">
        <xsl:call-template name="multiplication">
					<xsl:with-param name="a" select="Valeur[1]"/>
					<xsl:with-param name="b" select="Valeur[2]"/>
		</xsl:call-template>
    </xsl:when>
    <xsl:when test="@operation='/'">
        <xsl:call-template name="division">
					<xsl:with-param name="a" select="Valeur[1]"/>
					<xsl:with-param name="b" select="Valeur[2]"/>
		</xsl:call-template>
    </xsl:when>
    <xsl:otherwise>
        Operation invalide
    </xsl:otherwise>
</xsl:choose>
    </p><br/>
    </xsl:for-each>
</body>
</html>
</xsl:template>
</xsl:stylesheet>