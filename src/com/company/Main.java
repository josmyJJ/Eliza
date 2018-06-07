package com.company;

import java.util.*;
import java.io.BufferedReader;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
		
		Random rand = new Random();
		BufferedReader keyboardInput = null;
		
		// Variable
		String userInput;
		String[] splitStr; // splitStr array declared
		
		 // array list to store hedges and qualifiers
        String[] hedges = {
                "Please tell me more", "Many of my patients tell me the same thing",
                "It is getting late, maybe we had better quit"
        };
        String qualifiers[] = {
                "Why do you say that", "You seem to think that",
                "So, you are concerned that"
        };
        
     // BufferedReader reads the user input
        keyboardInput = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Please ask your concern: (Q/q to quit)");
        userInput  = keyboardInput.readLine();
        
     // While user input is not equal to the letter q keep looping
        while(!userInput.equalsIgnoreCase("q")) {
        	String output = ""; //output variable 
        	splitStr = userInput.split(" "); // split the string by each words
        	
        	if (userInput.contains("I") || userInput.contains("me") || 
        		userInput.contains("my") || userInput.contains("am")) {
        	// Local instance of hash map is created
        	HashMap<String, String> map = new HashMap<String, String>();
        		map.put("I", "you");
        		map.put("me", "you");
        		map.put("my", "your");
        		map.put("am", "are");
        	for(int i=0; i<splitStr.length; i++) {
        		if(splitStr[i].equalsIgnoreCase("my")) {
        			splitStr[i] = map.get("my");
        		}
        		if(splitStr[i].equalsIgnoreCase("me")) {
        			splitStr[i] = map.get("me");
        		}
        		if(splitStr[i].equalsIgnoreCase("I")) {
        			splitStr[i] = map.get("I");
        		}
        		if(splitStr[i].equalsIgnoreCase("am")) {
        			splitStr[i].equalsIgnoreCase("am");
        		}
        	}// End for
        	
        	// Concatenate the strings
        		for(int i=0; i<splitStr.length; i++){
	                output += splitStr[i] + " ";
	            }
        		
        		// Random generator for choosing random response from the qualifiers array
        		int randQual = rand.nextInt(qualifiers.length);
	            System.out.println(qualifiers[randQual] + " " +  output + "?");
	            userInput = keyboardInput.readLine();
	            
        	}else {
        		// Random generator for choosing random response from the hedges array
        		int randHedg = rand.nextInt(hedges.length);
	            System.out.println(hedges[randHedg]);
	            userInput = keyboardInput.readLine();
        	}
        }// End while loop 
        System.out.println("Thank you for using the program! Bye!");
	}
}
