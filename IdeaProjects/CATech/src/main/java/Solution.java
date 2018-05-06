public class Solution {
    public static String RotThirteen(String input) {

        int index;
        String output = "";
        String theCase = "";
        String originalCharacter;
        String replacingCharacter;

        for (int i=0; i<input.length(); i++) {
            originalCharacter = String.valueOf(input.charAt(i));

//            Defining if original character is a letter
            if (originalCharacter.matches("[a-zA-Z]")) {

//              Assigning upper or lower case set in case of upper or lower case letter
                if (originalCharacter.matches("[A-Z]")) {
                    theCase="ABCDEFGHIJKLMNOPQRSTUVWXYZ";
                } else if (originalCharacter.matches("[a-z]")) {
                    theCase="abcdefghijklmnopqrstuvwxyz";
                }

//              Defining index number of original letter
                index=theCase.indexOf(originalCharacter);

//              Moving index number 13 places forward, considering the length of alphabet
                if (index>13) { index-=13;
                } else { index+=13; }

//              Assigning a letter to return
                replacingCharacter = String.valueOf(theCase.charAt(index));

            } else {
//              Returning non-letter as is
                replacingCharacter = originalCharacter;
            }

//          Adding character to output string
            output += replacingCharacter;
        }
        return output;
    }
}