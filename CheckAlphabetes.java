public class CheckAlphabetes {

    public static void main(String... args) {
        String letters = "Zyu abc p[]exmnolkjhgfdsawetyuiop89zxc 'vbnm #@j99)-5 pieuyed000";
        String[] arrange = letters.split(" ");
       

        System.out.print(checkAllAlphabet(arrange));
    }

    public static boolean checkAllAlphabet(String[] arrange) {
        if (arrange.length == 0) {
            return false;
        }
        
        boolean[] alphabetFlags = new boolean[26];
        int letter = 0;

        for (int index = 0; index < arrange.length; index++) {
            for (char character : arrange[index].toCharArray()) {
                if (character >= 'A' && character <= 'Z') {
                    letter = character - 'A'; 
                } else if (character >= 'a' && character <= 'z') {
                    letter = character - 'a';
                } else {
                    continue;
                }
                alphabetFlags[letter] = true;
            }
        }

        for (boolean flag : alphabetFlags) {
            if (!flag) {
                return false;
            }
        }

        return true;
    }
}
