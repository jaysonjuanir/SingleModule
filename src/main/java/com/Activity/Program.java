package com.Activity;

import java.util.*;

import java.net.URL;
public class Program{
	public static void main(String [] args)throws Exception{
		//Scanner input = new Scanner(System.in);
		ArrayList<Map<String, String>> tables = new ArrayList<Map<String, String>>();
		String path = new Process().getPathFile();
		//ew Program().g();
		
		System.out.println("awdas");
		System.out.println("Printing the contents of the file:");
		FullList lists = new FullList(tables, path);
		
		
		tables = lists.getArrayTable();
		//process.printResults(tables);
		
		boolean choosing = true;
		while(choosing){
			Process process = new Process();
			try{
				System.out.println("Output Results:");
				Process.printResults(tables);
				
				Scanner input = new Scanner(System.in);
				System.out.println("Choose Number:");
				System.out.println("1. Add\n2. Edit\n3. Ascending Sort\n4. Descending Sort\n5. Print\n6. Reload\n7. Save\n8. Exit");

				int inputNumber = input.nextInt();
				switch(inputNumber){
					case 1:
						Process.chooseAdd(tables);
						break;
					case 2:
						Process.chooseEdit(tables);
						break;
					case 3:
						Process.chooseAscendingSort(tables);
						break;
					case 4:
						Process.chooseDescendingSort(tables);
						break;
					case 5:
						Process.printResults(tables);
						break;
					case 6:
						new FullList(tables, path);
						break;
					case 7:
						Process.saveToFile(tables, path);
						new FullList(tables, path);
						break;
					case 8:
						choosing = false;
						break;
					default:
						System.out.println("Out of choices!");
						break;
				}
				tables = lists.getArrayTable();
			}
			catch(Exception err){
				System.out.println("Error: "+err.getMessage());
			}
		}
		System.out.println("\nProgram will exit\n");
	}
}
