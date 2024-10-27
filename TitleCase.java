public class TitleCase {
    public static void main(String... args) {
        String sentence = "stupid is as stupid does";

        System.out.print(convertToTitleCase(sentence));
    }

    public static String convertToTitleCase(String sentence) {
        if (sentence.isEmpty()) {
            return "";
        }
 
        char[] letters = sentence.toCharArray();
        boolean capitalizeNext = true;

        for (int index = 0; index < letters.length; index++) {
            if (Character.isWhitespace(letters[index])) {
                capitalizeNext = true;
            } else if (capitalizeNext) {
                letters[index] = Character.toUpperCase(letters[index]);
                capitalizeNext = false;
            } else {
                letters[index] = Character.toLowerCase(letters[index]);
            }
        }

        return new String(letters);
    }
}
