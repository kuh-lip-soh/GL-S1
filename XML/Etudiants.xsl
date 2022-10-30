<?xml version="1.0" encoding="UTF-8"?>

<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
    <xsl:template match="/">
        <xsl:for-each select="etudiants/etudiant/carteEtd">
            <p>
                <xsl:value-of select="." />
            </p>
        </xsl:for-each>
        <xsl:for-each select="/">
            <p>
                <xsl:value-of select="count(//etudiant/carteEtd[count(Prenom)>1]" />
            </p>
        </xsl:for-each>

    </xsl:template>
</xsl:stylesheet>