package controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Scanner;

public class ArquivosController implements InterfaceArquivos {

	public ArquivosController() {
		super();
	}

	@Override
	public void readDirectory(String path){
		File dir = new File(path);
		if(dir.exists() && dir.isDirectory()) {
			File[] files = dir.listFiles();
			for(File f: files) {
				System.out.println(f.getName());
			}
		}else{
			System.err.println("Diretório inválido ou não existente");
		}
	}

	@Override
	public String readFile(String path, String name) {
		File file = new File(path, name);
		FileInputStream inputstream = null;
		InputStreamReader isr = null;
		BufferedReader buffer = null;
		String line = "";
		StringBuilder text = new StringBuilder();
		if(file.exists() && file.isFile()) {
			try {
				inputstream = new FileInputStream(file);
				isr = new InputStreamReader(inputstream);
				buffer = new BufferedReader(isr);
				line = buffer.readLine();
				while(line != null) {
					text.append(line + "\n");
					line = buffer.readLine();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}finally{
				try {
					buffer.close();
					isr.close();
					inputstream.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}else{
			System.err.println("Arquivo inválido ou não existente!");
		}
		return text.toString();
	}
	
	private String generateText() {
		String fileText = readFile("C:\\Documentos", "relatorio.txt");
		return fileText;
	}

	@Override
	public void createFile(String path, String name) {
		File dir = new File(path);
		File file = new File(path, name);
		FileWriter fileWriter = null;
		PrintWriter print = null;
		if(dir.exists() || dir.isDirectory()) {
			boolean exists = false;
			if(file.exists()) {
				exists = true;
			}
			else {
				String fileText = generateText();
				try {
					fileWriter = new FileWriter(file, exists);
					print = new PrintWriter(fileWriter);
					print.write(fileText);
					print.flush();
				} catch (IOException e) {
					e.printStackTrace();
				}
				finally 
				{
					try {
						print.close();
						fileWriter.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
		}
	}
}
