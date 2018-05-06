import java.util.Arrays;

public class SolutionLargestNumber {

    public static int GetLargestNumber(int input) {

//      Take absolute value of input number to ensure it is positive
        input = Math.abs(input);

        int output;
        int inputLength = String.valueOf(input).length();

//      For the array with 1 element only or empty input
        if (inputLength <= 1) {
            output = input;

//      For any array with more than one element
        } else
         {
            int[] digits = new int[inputLength];

//          Creating an array with digits
            for (int i = 0; i < inputLength; i++) {
                digits[inputLength - 1 - i] = input % 10;
                input /= 10;
            }

//       Sorting an array using Bubble Sort
            int temp;
            for (int j = 0; j < inputLength; j++) {
                for (int k = 1; k < inputLength; k++) {
                    if (digits[k - 1] < digits[k]) {
//                  Swap the element
                        temp = digits[k - 1];
                        digits[k - 1] = digits[k];
                        digits[k] = temp;
                    }
                }
            }

//       Converting integer array which contains digits into long number
            String number = (Arrays.toString(digits)).replace("[", "").
                    replace(",", "").replace(" ", "").
                    replace("]", "");
            long result = Long.parseLong(number);

//       Ensuring that number does not exceed the maximum size for the int output type
            if (result > 2147483647) {
                result = 2147483647;
            }

            output = (int)(long) result;
         }
        return output;
    }
}
