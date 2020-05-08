package fileManager;

import java.io.*;

public class Operations {

	public static void copyText(String sourcePath, String destinyPath) throws IOException {
		try {
			String text = Reader.readCharacters(sourcePath);
			Writer.writeText(destinyPath, text);
		} catch (Exception e) {
			System.out.println("Ocurrió un error durante la ejecución del proceso");
			e.printStackTrace();
		}	
	}
	
	public static void copyBytes(String sourcePath, String destinyPath) throws IOException {
		try {
			byte[] text = Reader.readBytes(sourcePath);
			Writer.writeBytes(destinyPath, text);
		} catch (Exception e) {
			System.out.println("Ocurrió un error durante la ejecución del proceso");
			e.printStackTrace();
		}	
	}
	
	public static void deleteFile(String fpath) throws IOException {
		File archive = new File(fpath);
		try {
			archive.delete();
		} catch (Exception e) {
			System.out.println("Ocurrió un error durante la ejecución del proceso");
			e.printStackTrace();
		} 
	}
	
	public static Object getArchive(String fpath) throws IOException{
		Object auxObj = null;
		try {
			auxObj = Reader.readCharacters(fpath);
			return (String)auxObj;
		} catch (Exception eC) {
			try {
				auxObj = Reader.readBytes(fpath);
				return (Byte[])auxObj;
			} catch (Exception eB) {
				System.out.println("Ocurrió un error durante la ejecución del proceso");
				eB.printStackTrace();				
			}
		}				
		return auxObj;		
	}
	
	public static void appendText(String fpath, String textToAppend) throws IOException {
		try{
			String originalText = Reader.readCharacters(fpath);		
			String finalText = originalText +"\n"+ textToAppend;
			Writer.writeText(fpath, finalText);
		} catch (Exception e) {
			System.out.println("Ocurrió un error durante la ejecución del proceso");
			e.printStackTrace();
		}
	}
	
	

	
}
