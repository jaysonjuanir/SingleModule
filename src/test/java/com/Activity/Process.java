package com.Activity;

//import java.util.ArrayList;
import java.util.*;
//import java.io.File;
import static java.nio.file.StandardOpenOption.*;
import java.nio.file.*;
import java.io.*;
public class Process{
	//Process pr = new Process();
	public static void printResults(ArrayList<Map<String, String>> myTable){
		for(Map<String, String> dataTable: myTable){
			System.out.println();
			System.out.print("[");
			for(Map.Entry<String, String> dataMap: dataTable.entrySet()){
				System.out.print("["+dataMap.getKey() + ", " + dataMap.getValue() + "]");
			}
			System.out.print("]");
		}
		System.out.println();
	}
	//System.out.println("\\A");
	public static void saveToFile(ArrayList<Map<String, String>> myTable,String pathway){
		String outputForFile = "";
		char first_separator = 0x1C;
		char second_separator = 0x1D;
		char third_separator = 0x1E;
		for(Map<String, String> dataRow:myTable){
			for(Map.Entry<String, String> dataColumn:dataRow.entrySet()){
				
					//System.out.print(value);
				outputForFile += dataColumn.getKey() + first_separator + dataColumn.getValue();
				
				outputForFile += second_separator;
			}
			outputForFile += third_separator;
		}
		//System.out.println("This is the output:\n" +outputForFile);
		byte data[] = outputForFile.getBytes();
    	Path p = Paths.get("./"+pathway);

    	try (OutputStream out = new BufferedOutputStream(Files.newOutputStream(p, CREATE, TRUNCATE_EXISTING))) {
      		out.write(data, 0, data.length);
			
			System.out.println("\nFile Saved!\n");
    	}
		catch (Exception x) {
      		System.err.println(x);
    	}
	}
	public static void chooseAdd(ArrayList<Map<String, String>> tables)throws IOException{
		//Scanner input = new Scanner(System.in);
		BufferedReader input = new BufferedReader (new InputStreamReader(System.in));
		System.out.println("1. Row\t2. Key and Value");
		int inputNumber = Integer.parseInt(input.readLine());
		//String aa = inp.readLine();
		//int i = Integer.parseInt(aa);
		//Process pr = new Process();
		ArrayList<Map<String, String>> tempTable;
		
		int specifiedRow;
		int specifiedColumn;
		int specifiedArrangement;
		switch(inputNumber){
			
			case 1:
				RowList rows;
				System.out.println("Enter number of row");
				specifiedRow = Integer.parseInt(input.readLine())-1;
				rows = new RowList(tables, specifiedRow);
				rows.addRows();
				tempTable = rows.getArrayTable();
				//printResults(rows.getArrayTable());
				break;
			case 2:
				ColumnList columns;
				System.out.println("Enter number of row");
				specifiedRow = Integer.parseInt(input.readLine())-1;
				System.out.println("Arrangement for Key");
				specifiedColumn = Integer.parseInt(input.readLine())-1;
				columns = new ColumnList(tables,specifiedRow, specifiedColumn);
				
				System.out.println("Enter Key:");
				String inputKey = input.readLine();
				System.out.println("Enter Value:");
				String inputValue = input.readLine();
				columns.addColumns1(specifiedColumn, inputKey, inputValue);
				//printResults(columns.getArrayTable());
				break;
			/*case 3:
				ArrangementList values;
				System.out.println("Enter number of row");
				specifiedRow = Integer.parseInt(input.readLine())-1;
				System.out.println("Enter number of Column");
				specifiedColumn = Integer.parseInt(input.readLine())-1;
				System.out.println("Enter number of arrangement");
				specifiedArrangement = Integer.parseInt(input.readLine())-1;
		
				System.out.println("Enter Value: ");
				String inputValue = input.readLine();
				values = new ArrangementList(tables,specifiedRow, specifiedColumn,specifiedArrangement);
				values.addValues(inputValue);
				printResults(values.getArrayTable());
				break;*/
			default:
				System.out.println("Out of choices");
				break;
		}
	}
	public static void chooseEdit(ArrayList<Map<String, String>> tables)throws Exception{
		//Scanner input = new Scanner(System.in);
		BufferedReader input = new BufferedReader (new InputStreamReader(System.in));
		//Process pr = new Process();
		ArrayList<Map<String, String>> tempTable;
		
		int specifiedRow;
		int specifiedColumn;
		String inputKey;
		
		System.out.println("Enter number of row");
		specifiedRow = Integer.parseInt(input.readLine())-1;
		//System.out.println("Enter number of Column");
		//specifiedColumn = Integer.parseInt(input.readLine())-1;
		System.out.println("Enter Key");
		inputKey = input.readLine();
		
		/*
		ArrangementList values = new ArrangementList(tables,specifiedRow, specifiedColumn,specifiedArrangement);
		*/
		ColumnList col = new ColumnList(tables, specifiedRow);
		col.setColumnValue(inputKey);
		String columnValue = col.getColumnValue();
		//System.out.println("THE TRUTH HAS BEEN SPOKEN! "+"null".equals(null));
		if(!(columnValue.equals(null))){
			System.out.println("Edit the Value of \""+ columnValue+"\" to: ");
			String inputValue = input.readLine();
			

			col.editColumnValue(inputValue);
			System.out.println("\nSuccess!\n");
			//printResults(col.getArrayTable());
		}
		else
			System.out.println("No \""+inputKey+"\" Key Found");
	}
	public static void chooseAscendingSort(ArrayList<Map<String, String>> tables)throws Exception{
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter Row to be sorted: ");
		int row = Integer.parseInt(input.readLine())-1;
		Map<String, String> treeMap = new TreeMap<String, String>(tables.get(row));
		for (String str : treeMap.keySet()) {
			System.out.println(str);
		}
		RowList rows = new RowList(tables, row);
		rows.setMap(treeMap, row);
	}
	public static void chooseDescendingSort(ArrayList<Map<String, String>> tables)throws Exception{
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter Row to be sorted: ");
		int row = Integer.parseInt(input.readLine())-1;
		Map<String, String> treeMap = new TreeMap<String, String>(Collections.reverseOrder());
		treeMap.putAll(tables.get(row));
		for (String str : treeMap.keySet()) {
			System.out.println(str);
		}
		RowList rows = new RowList(tables, row);
		rows.setMap(treeMap, row);
	}
}
