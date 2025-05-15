public class Caesar {

    public static String encrypt(String word, int shift){

        StringBuilder chipheredWord = new StringBuilder();

        for (char letter : word.toCharArray()){

            int charCode = (int) letter;

            if (charCode >= 65 && charCode <= 90)
                charCode = ((charCode - 65 + shift) % 26) + 65;

            else if (charCode >= 97 && charCode <=122)
                charCode = ((charCode - 97 + shift) % 26) + 97;

            char finalChar = (char) charCode;
            chipheredWord.append(finalChar);
        }

        return chipheredWord.toString();
    }

    public static String decrypt(String word, int shift){
        StringBuilder chipheredWord = new StringBuilder();

        for (char letter : word.toCharArray()){

            int charCode = (int) letter;

            // Uppercase
            if (charCode >= 65 && charCode <= 90)
                charCode = ((charCode - 65 - shift) % 26) + 65;

            // Lowercase
            else if (charCode >= 97 && charCode <= 122)
                charCode = ((charCode - 97 - shift) % 26) + 97;

            char finalChar = (char) charCode;
            chipheredWord.append(finalChar);
        }

        return chipheredWord.toString();
    }
}
