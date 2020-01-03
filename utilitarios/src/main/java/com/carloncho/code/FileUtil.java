package com.carloncho.code;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;

public class FileUtil {

	private static final String MENSAJE_ARCHIVO_NO_ENCONTRADO = "Archivo no encontrado";
	
	/**
	 * Devuelve el archivo en caso encontrarlo en la carpeta resource de la app.
	 * */
	public static File getFileFromResources(String fileName) throws IllegalArgumentException{

        ClassLoader classLoader = FileUtil.class.getClassLoader();
        URL resource = classLoader.getResource(fileName);
        
        if (resource == null) {
            throw new IllegalArgumentException(MENSAJE_ARCHIVO_NO_ENCONTRADO);
        } else {
            return new File(resource.getFile());
        }

    }
	
	/**
	 * Devuelve contenido archivo xml en cadenas
	 * */
	public static String xmlToStringFromFile(File xmlFile) throws IOException {

        StringBuilder xmlEnCadena  = null;
        
        try (BufferedReader bufReader = new BufferedReader(new FileReader(xmlFile))){
            
            xmlEnCadena = new StringBuilder();
            
            String linea = bufReader.readLine();
            while( linea != null){
                xmlEnCadena.append(linea).append("\n");
                linea = bufReader.readLine();
            }
        	
        }catch (IOException ioe){
            throw new IOException(ioe);
        }
        
		return xmlEnCadena.toString();
	}
	
}
