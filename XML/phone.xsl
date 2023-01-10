<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">

<xsl:template match="/">

<p>Téléphones les mieux notés :</p>
<xsl:for-each select="//Phone">
    <xsl:if test="@note = 5">
        <p>
            <tr>
            <td><xsl:value-of select="Marque"/></td>
            <td><xsl:value-of select="Modele"/></td>
            </tr>
        </p>
    </xsl:if>
</xsl:for-each>

<p>Téléphones les plus récents :</p>
<xsl:for-each select="//Phone">
    <xsl:sort select="Date" order="descending"/>
        <p>
            <tr>
            <td><xsl:value-of select="Marque"/></td>
            <td><xsl:value-of select="Modele"/></td>
            <td>- Sortie le : <xsl:value-of select="Date"/></td>
            </tr>
        </p>
</xsl:for-each>

<p>Téléphones les plus vendus :</p>
<xsl:for-each select="//Phone">
    <xsl:sort select="Vente" order="descending" data-type="number"/>
        <p>
            <tr>
            <td><xsl:value-of select="Marque"/></td>
            <td><xsl:value-of select="Modele"/></td>
            <td>- Vendu : <xsl:value-of select="Vente"/></td>
            </tr>
        </p>
</xsl:for-each>

<p>Total des téléphones :
    <xsl:value-of select="count(//Phone)"/>
</p>

<p>Téléphones a double sim :</p>
<xsl:for-each select="//Phone">
   <xsl:if test="/Specs/Sim[@double='true']">
   <p>
        <tr>
        <td><xsl:value-of select="Marque"/></td>
        <td><xsl:value-of select="Modele"/></td>
        </tr>
    </p>
    </xsl:if>
</xsl:for-each>

<!--
<p>Toutes les marques :
    <xsl:for-each select="distinct-values(//Phone/Marque/text())">
        <p>
            <xsl:value-of select="."/>
        </p>
    </xsl:for-each>
</p>
-->


</xsl:template>
</xsl:stylesheet>