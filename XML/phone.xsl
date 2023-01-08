<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">

<xsl:template match="/">
<p>Téléphones les mieux notés :</p>
<xsl:for-each select="//Phone">
    <xsl:if test="[note='5']">
        <tr>
            <td><xsl:value-of select="Marque"/></td>
            <td><xsl:value-of select="Modele"/></td>
        </tr>
    </xsl:if>
</xsl:for-each>

<p>Téléphones les plus récents :</p>
<xsl:for-each select="//Phone">
    <xsl:sort select="Date">
        <tr>
            <td><xsl:value-of select="Marque"/></td>
            <td><xsl:value-of select="Modele"/></td>
        </tr>
    </xsl:sort>
</xsl:for-each>

<p>Téléphones les plus vendus :</p>
<xsl:for-each select="//Phone">
<xsl:text>Test</xsl:text>
    <xsl:sort select="Date" order=descending>
            <xsl:text>Test</xsl:text>
            <xsl:value-of select="Marque"/>
            <xsl:value-of select="Modele"/>
    </xsl:sort>
</xsl:for-each>

<p>Total des téléphones :
    <xsl:value-of select="count(//Phone)"/>
</p>

<p>Toutes les marques :
    <xsl:for-each select="distinct-values(//Phone/Marque/text())">
        <p>
            <xsl:value-of select="."/>
        </p>
    </xsl:for-each>
</p>


</xsl:template>
</xsl:stylesheet>