public class SecondOderIsogram{

    public static void main(String... args) {
        String phrase = "mallam";

        System.out.print(isSecondOderIsogram(phrase));


    }

    public static boolean isSecondOderIsogram(String phrase){
        boolean isPhraseWithOddOfCharacters = phrase.length() % 2 != 0;
        if(isPhraseWithOddOfCharacters) return false;

        String uniqueCharactersOfPhrase = "";
        for(int index = 0; index<phrase.length(); index++){
            char currentCharacter = phrase.charAt(index);
            boolean isUniqueCharacterOfPhrase = !uniqueCharactersOfPhrase.contains("" + currentCharacter);
            if (isUniqueCharacterOfPhrase){
                uniqueCharactersOfPhrase += currentCharacter;
            }


	}
        int numberOfUniqueCharacter = uniqueCharactersOfPhrase.length();
        int[] tally = new int[numberOfUniqueCharacter];
        for(int index = 0; index < numberOfUniqueCharacter; index++){
            char currentCharacter = uniqueCharactersOfPhrase.charAt(index);
            for(int counter = 0; counter < phrase.length(); counter++){
                if(currentCharacter == phrase.charAt(counter))
                    tally[index] += 1;

        }
    }

        for(int index = 0; index < tally.length; index++){
            if(tally[index] != 2) return false;

        }
        return true;

}


}