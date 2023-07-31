import java.security.SecureRandom;

public class xkcdpwgen {
    static final String[] Words = {
            "apple", "back", "carry", "numb", "here", "one",
            "delete", "two", "random", "cookie", "scrabble", "coffee",
            "mascara", "into", "mono"

    };

    private static final String[] Symbols = {
            "!", "@", "#", "$", "%", "^", "&", "*", "(", ")", "_", "+", "-", "=", "[",
            "]", "{", "}", "|", ":", ";", ",", ".", "<", ">", "/", "?", "~", "`"
    };

    private static final String[] Numbers = {
            "1", "2", "3", "4", "5", "6", "7", "8" , "9"
    };

    public static void main(String[] args) {
        int numWords = 4;
        int numCaps = 4;
        int numNums = 4;
        int numSymbols = 4;

        for (int i = 0; i < args.length; i++) {
            if (args[i].equals("-h") || args[i].equals("--help")) {
                printHelp();
                return;
            } else if (args[i].equals("-w") || args[i].equals("--words")) {
                i++;
                numWords = Integer.parseInt(args[i]);
            } else if (args[i].equals("-c") || args[i].equals("--caps")) {
                i++;
                numCaps = Integer.parseInt(args[i]);
            } else if (args[i].equals("-n") || args[i].equals("--numbers")) {
                i++;
                numNums = Integer.parseInt(args[i]);
            } else if (args[i].equals("-s") || args[i].equals("--symbols")) {
                i++;
                numSymbols = Integer.parseInt(args[i]);
            }
        }
        generatePassword(numWords, numCaps, numNums, numSymbols);
    }

    private static void printHelp() {
        System.out.println("Usage: xkcdpwgen [-h] [-w WORDS] [-c CAPS] [-n NUMBERS] [-s SYMBOLS]");
        System.out.println();
        System.out.println("Generate a secure, memorable password using the XKCD method");
        System.out.println();
        System.out.println("optional arguments:");
        System.out.println("  -h, --help            show this help message and exit");
        System.out.println("  -w WORDS, --words WORDS");
        System.out.println("                        include WORDS words in the password (default=4)");
        System.out.println("  -c CAPS, --caps CAPS  capitalize the first letter of CAPS random words (default=0)");
        System.out.println("  -n NUMBERS, --numbers NUMBERS");
        System.out.println("                        insert NUMBERS random numbers in the password (default=0)");
        System.out.println("  -s SYMBOLS, --symbols SYMBOLS");
        System.out.println("                        insert SYMBOLS random symbols in the password (default=0)");
    }

    private static void generatePassword(int numWords, int numCaps, int numNums, int numSymbols) {
        SecureRandom random = new SecureRandom();
        StringBuilder password = new StringBuilder();

        for (int i = 0; i < numWords; i++) {
            int index = random.nextInt(Words.length);
            String word = Words[index];

            // Randomly decide whether to capitalize the word
            if (random.nextBoolean() && i < numCaps) {
                word = word.substring(0, 1).toUpperCase() + word.substring(1);
            }

            password.append(word);
        }

        for (int i = 0; i < numNums; i++) {
            int index = random.nextInt(Numbers.length);
            String num = Numbers[index];
            if (i < numNums) {
                num = num.substring(0, 1).toUpperCase() + num.substring(1);
            }
            password.append(num);
        }
        for (int i = 0; i < numSymbols; i++) {
            int index = random.nextInt(Symbols.length);
            password.append(Symbols[index]);
        }
        System.out.println("Generated password:" + password.toString());
    }
}
