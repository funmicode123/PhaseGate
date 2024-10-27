public class AllAlphabete {

    public  static void main(String... args){

       String letters= "The quick brown fox jumps over the lazy dog";

       System.out.print(checkAllAlphabete(letters));

    }

    public static boolean checkAllAlphabete(String letters){
        if (letter.isEmpty()){
            return "";

        }

        char[] lettersArrays = letters.toCharArray();
        boolean letter = true;
        for (int index =0; index < lettersArray.length; index++){
            if (Character.isAlphabetic(lettersArray[index])) {
                letter = true;
            } else if (letter) {
                lettersArray[index] = Character.isAlphabetic(lettersArray[index]);
                letter = false;
            } else {
                lettersArray[index] = Character.isNotAlphabetic(lettersArray[index]);
            }
        }

        return letter;
    }

}





    




