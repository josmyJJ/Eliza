package com.company;

import java.util.*;
import java.io.BufferedReader;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception{
        // write your code here
        String userInput;
        String output = "";
        boolean keepAsking = true;
        String[] hedges = {
                "Please tell me more", "Many of my patients tell me the same thing",
                "It is getting late, maybe we had better quit"
        };
        String qualifiers[] = {
                "Why do you say that", "You seem to think that",
                "So, you are concerned that"
        };

        do{
//            System.out.println("Enter a response: ");
//            userInput = input.next();
//            userInput += input.nextLine();
            Scanner input = new Scanner(System.in);
            BufferedReader keyboardInput = null;
            keyboardInput = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Please ask your question: ");
            userInput = keyboardInput.readLine();

            String[] splitStr = userInput.split(" ");
            for(Integer i=0; i<splitStr.length; i++){
                if(splitStr[i].equalsIgnoreCase("i")){
                    splitStr[i] = "you";
                }
                if(splitStr[i].equalsIgnoreCase("me")){
                    splitStr[i] = "you";
                }
                if(splitStr[i].equalsIgnoreCase("my")){
                    splitStr[i] = "your";
                }
                if(splitStr[i].equalsIgnoreCase("am")){
                    splitStr[i] = "are";
                }
            }
            // Concatenating the strings together
            for(int i=0; i<splitStr.length; i++){
                output += splitStr[i] + " ";
            }
            Random rand = new Random();
            int randResp = rand.nextInt(hedges.length);
            int randQual = rand.nextInt(qualifiers.length);

            System.out.println(qualifiers[randQual] + " " +  output);

            System.out.println("Do you want to quit? (Q to quit)");
            String userRsponse = input.next();
            if(userRsponse.equalsIgnoreCase("q")){
                keepAsking = false;
            }
        }while(keepAsking == true);
    }
}
