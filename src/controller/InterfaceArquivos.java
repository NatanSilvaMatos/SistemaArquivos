package controller;

public interface InterfaceArquivos {
	public void readDirectory(String path);
	public String readFile(String path, String name);
	public void createFile(String path, String name);
}
