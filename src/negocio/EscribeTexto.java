package negocio;

import java.io.*;

public class EscribeTexto {
	
	public EscribeTexto(){
		
	}
	
	public void escribir(String xml,String ruta){
		PrintWriter printWriter = null;
        try {
            // Will overwrite the file if exists or creates new
            printWriter = new PrintWriter(ruta,"UTF-8");
            printWriter.println(xml);
            System.out.println("WHY");
        } catch (FileNotFoundException fileNotFoundException) {
            fileNotFoundException.printStackTrace();
        } catch (UnsupportedEncodingException unsupportedEncodingException) {
            unsupportedEncodingException.printStackTrace();
        } finally {
            printWriter.close();
        }
	}

}
