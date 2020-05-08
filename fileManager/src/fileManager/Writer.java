package fileManager;

import java.io.*;


public class Writer {
	
	public static void writeText(String fpath, String text) throws IOException {
		File archive = new File(fpath);
		FileWriter fw = null;
		
		fw = new FileWriter(archive);
		fw.write(text);
		fw.close();		
	}
	
	public static void writeLinesOfText(String fpath, String[] text) throws IOException {
		File archive = new File(fpath);		
		FileWriter fw = null;
		BufferedWriter bw = null;
		
		fw = new FileWriter(archive);
		bw = new BufferedWriter(fw);
		for(int i = 0; i < text.length; i++) {
			bw.write(text[i]);
			bw.write("\r\n");
		}
		bw.close();
	}
	
	public static void writeBytes(String fpath, byte[] bytes) throws IOException {
		File archive = new File(fpath);
		FileOutputStream fos = null;
		
		fos = new FileOutputStream(archive);
		fos.write(bytes);
		fos.close();				
	}
	
	public static void writeBytesBuffered(String fpath, byte[] bytes) throws IOException {
		File archive = new File(fpath);
		FileOutputStream fos = null;
		BufferedOutputStream bos = null;
		byte[] buffer = new byte[16384];
		int partes = (bytes.length / buffer.length);
		
		fos = new FileOutputStream(archive);
		bos = new BufferedOutputStream(fos);
		int writtenBytes = 0;
		for(int i = 0; i <= partes; i++) {
			if(writtenBytes + buffer.length < bytes.length) {
				bos.write(bytes, writtenBytes, buffer.length);
			} else { 
				bos.write(bytes, writtenBytes, (buffer.length - writtenBytes));
			}
			writtenBytes = buffer.length * i + buffer.length;
		}
		bos.close();		
	}
}
