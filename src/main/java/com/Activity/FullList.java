package com.Activity;

//import java.util.ArrayList;
import java.util.*;
//import java.io.File;
import static java.nio.file.StandardOpenOption.*;
import java.nio.file.*;
import java.io.*;
import java.net.URL;
public class FullList{
	protected static ArrayList<Map<String, String>> myTable;
	protected String pathway = "";
	private String token1 = "";
	private String token2 = "";
	private String []token3 = new String[2];
	public FullList(){
		
	}
	public FullList(ArrayList<Map<String, String>> table){
		myTable = table;
	}
	public FullList(ArrayList<Map<String, String>> table, String path)throws Exception{
		pathway = path;
		initializeArrayTable(table, path);
	}
	public void initializeArrayTable(ArrayList<Map<String, String>> table, String path)throws Exception{
		//URL url = getClass().getResource(path);
		File file = new File(path);
		//System.out.println(url.getPath());
		char first_separator = 0x1C;
		char second_separator = 0x1D;
		char third_separator = 0x1E;
		String firstDelimit = "" + first_separator;
		String secondDelimit = "" + second_separator;
		String thirdDelimit = "" + third_separator;
		table.clear();
		Scanner inFile1 = new Scanner(file).useDelimiter(thirdDelimit);
		for(int generateRow = 0;inFile1.hasNext();generateRow++){
			token1=inFile1.next();
			//table.add(hash);
			Map<String, String> hash = new LinkedHashMap<String, String>();
			Scanner inFile2 = new Scanner(token1).useDelimiter(secondDelimit);
			for(int generateColumn=0;inFile2.hasNext();generateColumn++){
				token2 = inFile2.next();
				//table.get(generateRow).add(new ArrayList<String>());
				Scanner inFile3 = new Scanner(token2).useDelimiter(firstDelimit);
				for(int generateIndex = 0;inFile3.hasNext();generateIndex++){
					token3[generateIndex] = inFile3.next();
					//System.out.println("test1");
					//table.get(generateRow).get(generateColumn).add(token3);
				}
				hash.put(token3[0], token3[1]);
			}
			
			table.add(hash);
		}
		//Process.printResults(table);
		myTable = table;
	}
	public void setArrayTable(ArrayList<Map<String, String>> table){
		myTable = table;
	}
	public ArrayList<Map<String, String>> getArrayTable(){
		return myTable;
	}
	
}
