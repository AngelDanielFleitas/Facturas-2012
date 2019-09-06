<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform" xmlns="http://www.w3.org/1999/xhtml">
<xsl:output method = "xml" /> 
<xsl:template match="//Comprobante">
   <html>
   <head>
   <title>Factura Electronica</title>
   </head>
   <body>
 <center>
	
	<pre><h3><xsl:value-of select="Emisor/@nombre"/> </h3>
              <b>RFC: </b><xsl:value-of select="Emisor/@rfc"/>
                <xsl:apply-templates select="//DomicilioFiscal"/></pre>
 </center>
          <table border="1">  
	<tr>		
	<th>Serie</th><th>Folio</th><th>Fecha</th><th>No Aprobacion </th><th>Fecha Aprobacion </th><th>Certificado</th><th>Fecha Emision</th>
	</tr>
	<tr >
		<td><xsl:value-of select="@serie"/>    </td>
		 <td><xsl:value-of select="@folio"/>  </td>
              	 	<td><xsl:value-of select="@fecha"/> </td>
               		<td><xsl:value-of select="@noAprobacion"/></td>
		<td><xsl:value-of select="@anoAprobacion"/></td>
		<td><xsl:value-of select="@noCertificacion"/> </td>
		<td><xsl:value-of select="@fecha"/> </td>
	</tr>
          </table><br/>
          <table  border="1" >
	<tr>
		<th >Datos del cliente</th><th >RFC</th>
	</tr>
	<tr>
		<td><xsl:value-of select="Receptor/@nombre"/>  -     
           		  <xsl:apply-templates select="//Domicilio"/>
		</td>
	 <td><xsl:value-of select="Receptor/@rfc"/></td>
	</tr>
           </table><br/>
        <table  border="1">
             <tr><th>Unidad</th>
	<th>Cantidad</th>
                 <th>Descripcion</th>
                 <th>Precio</th>
                 <th>Importe</th>
             </tr>
             <xsl:apply-templates select="//Concepto"/>
             <xsl:for-each select="Concepto">
             </xsl:for-each>
            </table><br/>
       <table  border="1" >
          <tr>  
	<td>
	  <xsl:value-of select="Addenda/@letraTotal"/>
          </td> 
            <th>
	 Subtotal 
	</th> 
	<td>
         	<xsl:value-of select="@subTotal"/>
           </td>
	</tr>
	<tr><td></td>
           <th>
	 I.V.A 
	</th>
         	  <td>
		<xsl:value-of select="Impuestos/@totalImpuestosTrasladados"/>
           </td>
	</tr>
	<tr>
	<td>
	<b>Forma de pago: </b> <xsl:value-of select="@formaDePago"/>
	 <b> Metodo de Pago: </b> <xsl:value-of select="@metodoDePago"/>   
	</td>
	<th>
	Total</th>
         	<td><xsl:value-of select="@total"/></td>
	</tr>
        </table><br/>
        <table  border="0" width="100%">
         <tr>  <td>
	   Cadena Original: 
	<xsl:value-of select="Addenda/@cadenaOriginal"/>
          </td>
	</tr>
	<tr>
            <td>
	  Sello Digital: 
         	<xsl:value-of select="@sello"/>
           </td></tr>
        </table><br/>
      </body>
    </html>
</xsl:template>
<xsl:template match="//DomicilioFiscal">
    <pre><xsl:value-of select="@calle"/> # <xsl:value-of select="@noExterior"/> - <xsl:value-of select="@noInterior"/>
      <xsl:value-of select="@colonia"/>
      <xsl:value-of select="@localidad"/>
     <br><xsl:value-of select="@municipio"/>
      <xsl:if test="@codigoPostal"> C.P <xsl:value-of select="@codigoPostal"/></xsl:if>
      <xsl:value-of select="@estado"/>
    <xsl:value-of select="@pais"/></br></pre> 
</xsl:template>
 
<xsl:template match="//Domicilio">
     <xsl:value-of select="@calle"/> # <xsl:value-of select="@noExterior"/> - <xsl:value-of select="@noInterior"/>, <xsl:value-of select="@colonia"/>, <xsl:value-of select="@localidad"/>, <xsl:value-of select="@referencia"/>, <xsl:value-of select="@municipio"/>, <xsl:if test="@codigoPostal"> C.P <xsl:value-of select="@codigoPostal"/>, </xsl:if> <xsl:value-of select="@estado"/>, <xsl:value-of select="@pais"/>
</xsl:template>
 
<xsl:template match="//Concepto">
    <tr><td align="center"><xsl:value-of select="@unidad"/></td>
        <td align="center"><xsl:value-of select="@cantidad"/></td>
        <td><xsl:value-of select="@descripcion"/></td>
        <td align="right"><xsl:value-of select="@valorUnitario"/></td>
        <td align="right"><xsl:value-of select="@importe"/></td>
    </tr>
</xsl:template>

</xsl:stylesheet>