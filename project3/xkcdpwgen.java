public class xkcdpwgen {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of words in the password: ");
        int numWords = scanner.nextInt();

        System.out.print("Enter the number of capitalizations: ");
        int numCapitalizations = scanner.nextInt();

        System.out.print("Enter the number of numbers: ");
        int numNumbers = scanner.nextInt();

        System.out.print("Enter the number of symbols: ");
        int numSymbols = scanner.nextInt();

        scanner.close();

        List<String> words = readWordsFromFile("words.txt");
        String password = generatePassword(words, numWords, numCapitalizations, numNumbers, numSymbols);

        System.out.println("Generated Password: " + password);
    }

    private static List<String> readWordsFromFile(String filename) {
        List<String> words = new ArrayList<>();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(filename));
            String line;
            while ((line = reader.readLine()) != null) {
                words.add(line);
            }
            reader.close();
        } catch (IOException e) {
            System.err.println("Error reading words from file: " + e.getMessage());
        }
        return words;
    }

    private static String generatePassword(List<String> words, int numWords, int numCapitalizations, int numNumbers, int numSymbols) {
        Random rand = new Random();
        StringBuilder password = new StringBuilder();

        for (int i = 0; i < numWords; i++) {
            String randomWord = words.get(rand.nextInt(words.size()));
            password.append(randomWord);
        }

        for (int i = 0; i < numCapitalizations; i++) {
            int index = rand.nextInt(password.length());
            char c = password.charAt(index);
            password.setCharAt(index, Character.toUpperCase(c));
        }

        for (int i = 0; i < numNumbers; i++) {
            int index = rand.nextInt(password.length());
            password.insert(index, rand.nextInt(10));
        }

        String symbols = "!@#$%^&*()_+-=[]{}|;:,.<>?";
        for (int i = 0; i < numSymbols; i++) {
            int index = rand.nextInt(password.length());
            char symbol = symbols.charAt(rand.nextInt(symbols.length()));
            password.insert(index, symbol);
        }

        return password.toString();
    }
}

