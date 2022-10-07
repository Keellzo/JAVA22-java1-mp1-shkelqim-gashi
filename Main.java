package kellzo.se;

import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Random random = new Random();

        while (true) {
            System.out.println("Välkommen till hemliga talet!");
            System.out.println();
            System.out.println("Vänligen gissa in ditt tal mellan 0-100: ");
            int nrOfGuesses = 0;
            int randomNumber = random.nextInt(101);
            int talet = -1;
            Scanner scanner = new Scanner(System.in);

            //LOOP WHILE NOT TRUE
            while (!checkNumber(talet, randomNumber)) {

                try {
                    talet = scanner.nextInt();
                } catch (Exception e) {
                    System.out.println("Endast heltal, tack!");
                    System.out.println("Testa igen..");
                    scanner.next();
                    continue;
                }

                if (talet < randomNumber) {
                    System.out.println("Högre!");
                } else if (talet > randomNumber) {
                    System.out.println("Lägre!");
                }
                nrOfGuesses++;

            }

            System.out.println("--------------------");
            System.out.println("Grattis! Ditt tal " + talet + " matchade med slumptalet " + randomNumber);

            // ANTAL GISSNINGAR
            if (nrOfGuesses == 1) {
                System.out.println("Du hade rätt efter första gissningen, wow!");
            } else {
                System.out.println("Du hade rätt efter " + nrOfGuesses + " gissningar! Grymt!");
            }


            //OM DU VILL SPELA IGEN/AVSLUTA
            System.out.println("--------------------");
            System.out.println("Vill du spela igen? Skriv ja/nej");
            scanner.nextLine();
            String input = scanner.nextLine();
            if (!input.equals("ja")) {
                break;
            }
        }

        System.out.println("Välkommen åter!");
    }

    static boolean checkNumber(int talet, int randomNumber) {
        return talet == randomNumber;
    }

}
