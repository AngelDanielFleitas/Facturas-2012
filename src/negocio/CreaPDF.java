package negocio;

import com.lowagie.text.DocumentException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

import org.xhtmlrenderer.pdf.ITextRenderer;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class CreaPDF {

	public boolean crearPDF(String pathXML,String pathXSL,String pathHTML,String pathPDF){
		try{		    
			TransformerFactory tFactory = TransformerFactory.newInstance();
		    Transformer transformer = tFactory.newTransformer(new StreamSource(pathXSL));
		    transformer.transform(new StreamSource(pathXML),new StreamResult(new FileOutputStream(pathHTML)));
		    String File_To_Convert = pathHTML;
		    String url = new File(File_To_Convert).toURI().toURL().toString();
		    System.out.println(""+url);
		    String HTML_TO_PDF = pathPDF; // ruta y nombre del PDF
		    OutputStream os = new FileOutputStream(HTML_TO_PDF);       
		    ITextRenderer renderer = new ITextRenderer();
		    renderer.setDocument(url);      
		    renderer.layout();
		    renderer.createPDF(os);        
		    os.close();
		    return true;
		}
		catch(Exception e){
			e.printStackTrace();
			return false;
		}
	}
	
}
