package com.Activity;
import java.util.*;
//import java.io.File;
import static java.nio.file.StandardOpenOption.*;
import java.nio.file.*;
import java.io.*;
public class ColumnList extends RowList{
	protected int myColumnNumber;
	protected String myKey;
	protected String myValue;
	
	public ColumnList(ArrayList<Map<String, String>> table, int rowNumber, int columnNumber){
		super(table, rowNumber);
		myColumnNumber = columnNumber;
	}
	public ColumnList(ArrayList<Map<String, String>> table, int rowNumber){
		super(table, rowNumber);
		//myColumnNumber = columnNumber;
	}
	public void setColumnNumber(int columnNumber){
		myColumnNumber = columnNumber;
	}
	public int getColumnNumber(){
		return myColumnNumber;
	}
	public void addColumns(String key, String value){
		//myTable.get(rowOrder).add(columnOrder, new ArrayList<String>());
		//this.myTable = table;
		Map<String, String> tempMap = new LinkedHashMap<String, String>();
		myTable.get(myRowNumber).put(key, value);
	}
	public void addColumns1( int index, String key, String value) {
		Map<String, String> input = myTable.get(myRowNumber);
		if (index >= 0 && index <= input.size()) {
			LinkedHashMap<String, String> output=new LinkedHashMap<String, String>();
			int i = 0;
			if (index == 0) {
				output.put(key, value);
				output.putAll(input);
			} else {
				for (Map.Entry<String, String> entry : input.entrySet()) { //get the entire row and collect to output map
					if (i == index) {
						output.put(key, value);
					}
					output.put(entry.getKey(), entry.getValue());
					i++;
				}
			}
			if (index == input.size()) {
				output.put(key, value);
			}
			input.clear();
			input.putAll(output); //output map will add into
			output.clear();
			output = null;
			System.out.println(input);
			myTable.get(myRowNumber).putAll(input);
		} else {
			throw new IndexOutOfBoundsException("index " + index
					+ " must be greater than zero and less than size of the map");
		}
	}
	public void editColumnValue(String value){
		Object keyLine = myTable.get(myRowNumber).get(myKey);
		if (keyLine != null) {
			//Map<String, String> tempMap = new HashMap<String, String>();
			myTable.get(myRowNumber).put(myKey, value);
		} else {
			// No such key
			System.out.println("Key doesn't exist");
		}
	}
	public void setColumnValue(String key)throws Exception{
		if (key != null) {
			myKey = key;
		} 
		else {
			// No such key
			
			System.out.println("Key doesn't exist");
			throw new Exception("Error");
		}
	}
	public String getColumnValue(){
		//System.out.println("THIS"+myKey);
		return myTable.get(myRowNumber).get(myKey);
	}
}
