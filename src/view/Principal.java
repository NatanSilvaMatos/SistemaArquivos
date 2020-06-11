package view;

import controller.ArquivosController;

public class Principal {
	public static void main(String args[]) {
		ArquivosController file = new ArquivosController();
		
		String path = "C:\\Documentos";
		String name = "relatorio.txt";
		
		file.createFile(path, "relatorio.csv");
	}
	
}
