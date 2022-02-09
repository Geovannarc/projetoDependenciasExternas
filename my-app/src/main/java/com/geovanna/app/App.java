package com.geovanna.app;

import java.io.*;
import java.util.*;

import lombok.ToString;
@ToString

public class App 
{
    public static void main( String[] args ){
    	
    	ArrayList<String> turmaJava = new ArrayList<String>();
    	ArrayList<String> turmaBD = new ArrayList<String>();
    	
    	String turmaBDname = "turmaBD";
    	String turmaJavaname = "turmaJava"; 
    	HashSet<String> turmaOrdenada = new HashSet<String>();
    	
    	populaArrayList(turmaJava, turmaJavaname);
    	populaArrayList(turmaBD, turmaBDname);
    	criaHashSet(turmaJava, turmaOrdenada);
    	criaHashSet(turmaBD, turmaOrdenada);
    	
    	imprimirOrdenado(turmaOrdenada);
    	
    	
    }

	private static void populaArrayList(ArrayList<String> array, String name) {
		
		try {
    	      File turmaBDFile = new File("C:\\Users\\geovanna.freitas\\Downloads\\my-app\\docs\\"+name+".txt");
    	      Scanner reader = new Scanner(turmaBDFile);
    	      while (reader.hasNextLine()) {
    	        String data = reader.nextLine();
    	        array.add(data);
    	      }
    	      reader.close();
    	    } catch (FileNotFoundException e) {
    	      System.out.println("An error occurred.");
    	      e.printStackTrace();
    	    }
		imprimirTurmas(array, name);
		
		
	}

	private static void imprimirTurmas(ArrayList<String> array, String name) {
		
		try {
		      File outputFile = new File("C:\\Users\\geovanna.freitas\\Downloads\\my-app\\docs\\"+name+"Output.txt");
		      if (outputFile.createNewFile()) {
		        System.out.println("File created: " + outputFile.getName());
		      } else {
		        System.out.println("File already exists.");
		      }
		    } catch (IOException e) {
		      System.out.println("An error occurred.");
		      e.printStackTrace();
		    }
			
		try {
		      FileWriter myWriter = new FileWriter("C:\\Users\\geovanna.freitas\\Downloads\\my-app\\docs\\"+name+"Output.txt");
		      myWriter.write(name+"\n");
		      for (String i : array) {
		    	  myWriter.write(i+"\n");
		       }
		      myWriter.write("total de alunos: "+ array.size());
		      myWriter.close();
		      System.out.println("Successfully wrote to the file.");
		    } catch (IOException e) {
		      System.out.println("An error occurred.");
		      e.printStackTrace();
		    }	
		
		
	}
	
	private static void criaHashSet(ArrayList<String> array, HashSet<String>hashset) {
		
		for (String i : array) {
			hashset.add(i); 
	    }
		
	}
	
	private static void imprimirOrdenado(HashSet<String>hashset) {
		
		SortedSet<String> treeSet = new TreeSet<String>(hashset);
		String name = "ordenado";
		
		try {
		      File outputFile = new File("C:\\Users\\geovanna.freitas\\Downloads\\my-app\\docs\\"+name+"Output.txt");
		      if (outputFile.createNewFile()) {
		        System.out.println("File created: " + outputFile.getName());
		      } else {
		        System.out.println("File already exists.");
		      }
		    } catch (IOException e) {
		      System.out.println("An error occurred.");
		      e.printStackTrace();
		 }
		
		try {
		      FileWriter myWriter = new FileWriter("C:\\Users\\geovanna.freitas\\Downloads\\my-app\\docs\\"+name+"Output.txt");
		       
		      myWriter.write("Lista Ordenada dos Alunos: \n");
		      
		      for(String item : treeSet) {
		    	  try {
	                 myWriter.write(item+"\n");
	              } catch (IOException e) {
	                  e.printStackTrace();
	              }
	          	}

		      myWriter.close();
		      System.out.println("Successfully wrote to the file.");
		    } catch (IOException e) {
		      System.out.println("An error occurred.");
		      e.printStackTrace();
		    }	
	}

}
