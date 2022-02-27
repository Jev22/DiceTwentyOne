package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
//Slet hele main igen ved gennemgang og skriv kommentarer slavisk

        int pcPoints = 0;
        int userPoints = 0;

        while(playAgain()){

            pcPoints += getRollValue();
            userPoints += getRollValue();

            if(!isGameUnderLimit(userPoints) || !isGameUnderLimit(pcPoints)){
               break;
            }

            System.out.println("User Points: " + userPoints);
            System.out.println("Pc Points: " + pcPoints);
        }

    if (userPoints == 0 && pcPoints == 0){
        System.out.println("Gotta Play to win!!!");
    } else {
        displayResults(pcPoints, userPoints);
    }

    }

    public static int getRollValue(){
        //Alt vi laver i metoden, eksisterer kun her. Kun retur værdien komme ud af scope
        //Med metoden laver vi et kald der laver en terning, får to værdi, som der lægges sammen og sender værdien videre.

        //Vi opretter et terninge object.
        Die die = new Die();

        //Så "ruller" vi terningen. Vi har getValue() metoden i vores die class
        int roll1Value = die.getValue();

        //Vi ruller to gange
        die.roll(); //vi bruger roll() metoden for et frisk nummer
        int roll2Value = die.getValue();

        //Så nu returner vi værdierne lagt sammen
        return roll1Value + roll2Value;
    }

    //Metoder der tjekker om value er 21 eller under
    public static boolean isGameUnderLimit(int value) {
        //if funktion
        if (value > 21){
            return false;
        } else {
            return true;
        }
    }

    //Metode der tjekker om bruger vil spille igen.
    public static boolean playAgain(){
        //vi opretter en scanner, der tager imod keyboard input
        Scanner scannerIn = new Scanner(System.in);

        //Vi tjekker brugeren vil spille igen
        System.out.println("Roll the Dice? y/n : ");
        //Vi laver en string værdi til at holde input resultatet
        String userResponse = scannerIn.nextLine();
        //Vi laver en char værdi, der tager det første bogstav i vores string værdi
        char letter = userResponse.charAt(0);

        ///nu laver vi en hvis funktion, der tjekker om bogstavet i letter er y/Y
        if(letter == 'y' || letter == 'Y'){
            return true;
        }else{
            return false;
        }
    }

    //Metoder der håndterer visning af resultater for ai og user
    public static void displayResults(int pcScore, int userScore){
        System.out.println("\n Game Over\n");
        System.out.println("User's points: " + userScore);
        System.out.println("Computer's points: " + pcScore);

        System.out.println((getWinnerMsg(pcScore, userScore)));
    }
    //Metoder der bestemmer vinderen og returnerer resultatbesked
    private static String getWinnerMsg(int pcScore, int userScore) {
        //Hvis spillers score er større en pc og under game limit - spiller vinder
        if (userScore > pcScore && isGameUnderLimit(userScore) && pcScore != 21) {
            return "Congrats, you win!!!";
        //Hvis spiller er under limit og modstander er over limits - spiller vinder
        } else if(isGameUnderLimit(userScore) && !isGameUnderLimit(pcScore)){
            return "Congrats, You win - pc is out of bounds";

        //Hvis spillers score er 21 og modstanders er ikke - spiller vinder
        } else if (userScore == 21 && pcScore != 21 && isGameUnderLimit(pcScore)){
            return "Perfect 21! You win!";

        //Hvis spiller og pc er over 21 - begge taber
        } else if (isGameUnderLimit(userScore) && isGameUnderLimit(pcScore)){
            return "Both are above 21. You both loses";

        //Hvis spiller og pc er over 21 - begge taber
        } else {
            return "The computer wins!";
        }
    }
}
