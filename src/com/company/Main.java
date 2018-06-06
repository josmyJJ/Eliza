package com.company;

import java.util.*;
import java.io.BufferedReader;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception{
         Boolean userQuit = true;
        String userRespo;

        String[] hedges = {
                "Please tell me more", "Many of my patients tell me the same thing",
                "It is getting late, maybe we had better quit"
        };
        String[] qualifiers = {
                "Why do you say that", "You seem to think that",
                "So, you are concerned that"
        };

        BufferedReader keyboardInput = null;
        keyboardInput = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Good day. What is your problem? ");
        System.out.println("Enter your response here or Q to quit:");

        do{
            String outputStr = "";

            // Read in the user input
            userRespo = keyboardInput.readLine();
            //System.out.println("Enter your response here or Q to quit:");
            String[] splitStr = userRespo.split(" ");

            for(int i=0; i<splitStr.length; i++){
                if(splitStr[i].equalsIgnoreCase("my")){
                    splitStr[i] = "your";
                }
                if(splitStr[i].equalsIgnoreCase("me")){
                    splitStr[i] = "you";
                }
                if(splitStr[i].equalsIgnoreCase("i")){
                    splitStr[i] = "you";
                }
                if(splitStr[i].equalsIgnoreCase("am")){
                    splitStr[i] = "are";
                }
            }

            for(int i=0; i<splitStr.length; i++){
                outputStr += splitStr[i] + " ";
            }

            Random rand = new Random();
            int randQuali = rand.nextInt(qualifiers.length);
            int randHed = rand.nextInt(hedges.length);

            int response =rand.nextInt(2);
            switch (response){
                case 0:
                    System.out.println(qualifiers[randQuali] + " " + outputStr + "?");
                    break;
                case 1:
                    System.out.println(hedges[randHed]);
                    break;
            }

            if(userRespo.equalsIgnoreCase("q")){
                System.out.println("Goodby! Thanks for using the program!");
                userQuit = false;
                break;
            }
        }while (userQuit == true);
    }
}
