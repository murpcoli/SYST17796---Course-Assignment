/**
 * SYST17796 Deliverable 3
 * Blackjack
 * August 12, 2022
 * @author Colin Murphy
 * @author Gagandeep Kooner
*/

package ca.sheridancollege.project;

import java.util.Scanner;

public class InputOutput {

    //get string input, used for "Press Enter to Continue" commands
    //what the user types doesn't matter, as long as they acknowledge the outputted information
    public static String getStringInput(){
        Scanner sc = new Scanner(System.in);
        String input;
        input = sc.nextLine();
        return input;
    }
    
    //request an int input that is equal to or higher than the passed-in min value
    //request will loop if user attempts to input a non-int or an int lower than the min value
    public static int getIntInput(int minValue){
        Scanner sc = new Scanner(System.in);
        int input = 0;
        while (input == 0){
            try{
                input = sc.nextInt();
                if (input >= minValue){
                    return input;
                }
                else{
                    showOutput("Please input a value that is " + minValue + " or more:");
                    input = 0;
                } 
            }
            catch (Exception e){
                sc.next();
                showOutput("Please input a whole number:");  
            }
        }
        return input;
    }

    //request an int input that is equal to or higher than the passed-in min value, and equal to or lower than the max value
    //request will loop if user attempts to input a non-int or an int lower than the min value or an int higher than the max value
    public static int getIntInput(int minValue, int maxValue){
        Scanner sc = new Scanner(System.in);
        int input = 0;
        while (input == 0){
            try{
                input = sc.nextInt();
                if (input >= minValue && input <= maxValue){
                    return input;
                }
                else{
                    showOutput("Please input a value between " + minValue + " and " + maxValue + ":");
                    input = 0;
                } 
            }
            catch (Exception e){
                sc.next();
                showOutput("Please input a whole number:");  
            }
        }
        return input;
    }

    //directs output to system.out
    //can be edited to easily redirect all output elsewhere, such as a text node in a UX program
    public static void showOutput(String output){
        System.out.println(output);
    }
}
