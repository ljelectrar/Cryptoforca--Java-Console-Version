import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String word = "word";
        int shift = 3;

        AtomicBoolean isGameOver = new AtomicBoolean(false);
        AtomicInteger lives = new AtomicInteger(7);

        List<Character> correctLetters = new ArrayList<>();
        List<Character> chosenWordCharecters = new ArrayList<>();

        String chosenWord = Caesar.encrypt(word, shift);

        chosenWord.chars().forEach(letter -> {
            chosenWordCharecters.add((char) letter);
        });

        System.out.println(ASCIIArt.stages[lives.get()]);
        chosenWordCharecters.forEach(letter -> System.out.print("_"));

        do {
            StringBuilder display = new StringBuilder();

            System.out.print("\nlives: " + lives.get() + "\nGuess a word: ");
            char guess = sc.nextLine().charAt(0);

            chosenWordCharecters.forEach(letter -> {

                if (guess == letter) {
                    display.append(guess);
                    correctLetters.add(guess);
                } else if (correctLetters.contains(letter)) {
                    display.append(letter);
                } else {
                    display.append("_");
                }
            });

            System.out.println(ASCIIArt.stages[lives.get() - 1]);
            System.out.println();
            System.out.println(display);

            if (!chosenWordCharecters.contains(guess)){
                lives.getAndAdd(-1);

                if (lives.get() <= 0){
                    isGameOver.set(true);
                    System.out.println("You lose.");
                    System.out.println("The word was: " + Caesar.decrypt(chosenWord, shift));
                }
            }


            List<Character> displayCharacters = new ArrayList<>();
            for (char letter : display.toString().toCharArray())
                displayCharacters.add(letter);

            if (!displayCharacters.contains('_')){
                isGameOver.set(true);
                System.out.println("You win");
                System.out.println("The word was: " + Caesar.decrypt(chosenWord, shift));
            }

        } while (!isGameOver.get());

    }
}
