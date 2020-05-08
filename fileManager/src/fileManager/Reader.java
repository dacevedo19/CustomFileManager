package fileManager;

import java.io.*;

public class Reader {

	public static String readCharacters (String fpath) throws IOException {
		File archive = new File(fpath);
		FileReader fr = null;
		byte[] generatedFile = new byte[(int) archive.length()];

		fr = new FileReader(archive);
		int c;
		for (int i = 0; (c = fr.read()) != -1; i++) {
			generatedFile[i] = (byte) c;
		}

		if(fr != null) {fr.close();}
			
		return new String(generatedFile);
	}
	
	public static StringBuilder readLineOfCharacters(String fpath) throws IOException {
		File archive = new File(fpath);
		FileReader fr = null;
		BufferedReader br = null;
		StringBuilder generatedFile = new StringBuilder();

		fr = new FileReader(archive);
		br = new BufferedReader(fr);
		String s = null;
		while((s = br.readLine()) != null){
			generatedFile.append(s);
			generatedFile.append("\r\n");			
		}
		if (br != null) {br.close();}		
		
		return generatedFile;
	}
	
	public static byte[] readBytes(String fpath) throws IOException {
		File archive = new File(fpath);
		byte[] generatedFile = new byte[(int)archive.length()];
		FileInputStream fis = null;
		
		fis = new FileInputStream(archive);
		int c;
		int index = 0;
		while((c = fis.read()) != -1) {
			generatedFile[index] = (byte) c;
			index++;
		}
		fis.close();
		
		return generatedFile;		
	}
	
	public static byte[] readBytesBuffered(String fpath) throws IOException{
		File archive = new File(fpath);
		int fileLength = (int) archive.length();
		byte[] generatedFile = new byte[fileLength];
		byte[] buffer = new byte[16384];
		FileInputStream fis= null;
		BufferedInputStream buffStream = null;
				
		fis = new FileInputStream(archive);
		buffStream = new BufferedInputStream(fis, buffer.length);
		int totalBytes = 0;
		int bytesRead;
		
		while((bytesRead = buffStream.read(buffer)) != -1) {
			for (int i = 0; i < buffer.length; i++) {
				if (totalBytes + i < archive.length()) {
					generatedFile[totalBytes + i] = buffer[i];
				}
			}
			totalBytes += bytesRead;
		}
		buffStream.close();
		
		return generatedFile;
	}
	
	
	
}
