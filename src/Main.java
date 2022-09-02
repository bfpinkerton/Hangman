import java.util.Scanner;
import java.util.ArrayList;
import java.util.Random;

public class Main
{
    public static void main(String[] args){
        ArrayList<String> wordBank = new ArrayList<>();
        ArrayList<String> missedLetters = new ArrayList<>();
        Random rand = new Random();
        wordBank.add("cat");
        wordBank.add("dog");
        wordBank.add("eagle");
        wordBank.add("boar");
        wordBank.add("pig");

        ArrayList<String> correctLetters = new ArrayList<>();
        correctLetters.add("_");
        correctLetters.add("_");
        correctLetters.add("_");
        int randomNumber = rand.nextInt(wordBank.size());
        boolean h1 = true;
        boolean h2 = true;
        boolean h3 = true;
        String rope = "    |";
        String headRope = "   O|";
        String bodyRope = "   ||";
        System.out.println("H A N G M A N");
        System.out.println("+---+");
        System.out.println(rope);
        System.out.println(rope);
        System.out.println(rope);
        System.out.println("   ===");
        System.out.println("Missed Letters");
        System.out.println("---");
        System.out.println("Guess a letter.");

        String answer = wordBank.get(randomNumber);
        String indicator = "";
        int numberGuesses = 0;
        int correctGuesses = 0;
        for(int i=0; i<3; i++){
            boolean status = true;
            Scanner myObj = new Scanner(System.in);
            String guess = myObj.nextLine();
            for(int j=0; j< answer.length(); j++){
                if(guess.charAt(0) == answer.charAt(j)){
                    correctLetters.set(j, guess);
                    status = false;
                    correctGuesses++;
                }
            }
            if(status == true){
                numberGuesses++;
                missedLetters.add(guess);
            }
            if(numberGuesses == 1){
                h1 = false;
            }
            if(numberGuesses == 2){
                h2 = false;
            }
            if(numberGuesses == 3){
                h3 = false;
            }
            if(h1 == true){
                System.out.println(rope);
            }
            if(h1 == false){
                System.out.println(headRope);
            }
            if(h2 == true){
                System.out.println(rope);
            }
            if(h2 == false){
                System.out.println(bodyRope);
            }
            if(h3 == true){
                System.out.println(rope);
            }
            if(h3 == false){
                System.out.println(bodyRope);
            }
            System.out.println("   ===");
            System.out.println("Missed Letters" + missedLetters);
            System.out.println(correctLetters);
            if(correctGuesses == answer.length()){
                System.out.println("Yes! The secret word is " + answer + "! You have won!");
                System.out.println("Do you want to play again?");
            }
        }
    }
}
