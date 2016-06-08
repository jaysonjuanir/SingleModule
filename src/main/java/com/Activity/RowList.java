package com.Activity;

import java.util.*;
//import java.io.File;
import static java.nio.file.StandardOpenOption.*;
import java.nio.file.*;
import java.io.*;
public class RowList extends FullList{
	//protected ArrayList<ArrayList<ArrayList<String>>> myRows;
	protected int myRowNumber;
	
	public RowList(ArrayList<Map<String, String>> table, int rowNumber){
		super(table);
		myRowNumber = rowNumber;
	}
	
	public void setRowNumber(int rowNumber){
		myRowNumber = rowNumber;
	}
	public int getRowNumber(){
		return myRowNumber;
	}
	public void addRows(int rowOrder){
		myTable.add(rowOrder, new LinkedHashMap<String, String>());
		//this.myTable = table;
	}
	protected void addRows(){
		myTable.add(myRowNumber, new LinkedHashMap<String, String>());
		//this.myTable = table;
	}
	public void setMap(Map<String, String> tables, int rowNumber){
		myTable.set(rowNumber, tables);
	}
	/*public void ascendingMapSort(Map<String, String> tables, int rowNumber){
		myTable.get(rowNumber).entrySet().stream()
        .sorted(Map.Entry.comparingByValue(Comparator.order()))
        .collect(Collectors.toMap(
                Map.Entry::getKey, 
                Map.Entry::getValue, 
                (x,y)-> {throw new AssertionError();},
                LinkedHashMap::new
        ));
		
		Comparator<Entry<String, String>> valueComparator = new Comparator<Entry<String,String>>() {
            
            @Override
            public int compare(Entry<String, String> e1, Entry<String, String> e2) {
                String v1 = e1.getValue();
                String v2 = e2.getValue();
                return v1.compareTo(v2);
            }
        };
        
	}*/
}
