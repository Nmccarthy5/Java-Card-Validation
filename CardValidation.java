//**Author Nathan Mc 
// Date 08/26/2023
/** 
 
 * // Return true if the card number is valid //
 * public static boolean isValid(long number)

 * // Get the result from Step 2 //
 * public static int sumOfDoubleEvenPlace(long number)

 * // Return this number if it is a single digit, otherwise,
 * return the sum of the two digits //
 * public static int getDigit(int number)

 * // Return sum of odd-place digits in number //
 * public static int sumOfOddPlace(long number)

 * // Return true if the digit d is a prefix for number //
 * public static boolean prefixMatched(long number,int d)

 * // Return the number of digits in d //
 * public static int getSize(long d)

 * // Return the first k number of digits from number. If the
 * * number of digits in number is less than k, return number. //
 * public static long getPrefix(long number,int k)

*/ 
import java.util.*;

public class CardValidation
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a credit card number as a long integer: ");
        long number = scanner.nextLong();

        boolean valid = isValid(number);

        if (valid)
            System.out.println(number + " is valid. Thank you!");
        else
            System.out.println(number + " is invalid. Please Try Again.");
        
            scanner.close(); 
    }
/** Now for some fun mathmatical stuff */
    /** Return true if the card number is valid */
    public static boolean isValid(long number)
    {
        return (sumOfDoubleEvenPlace(number) + sumOfOddPlace(number)) % 10 == 0;
    }


    /** Get the result from Step 2 */
    public static int sumOfDoubleEvenPlace(long number)
    {
        int sum = 0;
        String temp = new StringBuilder(number + "").reverse().toString();

        for (int i = 0;i < getSize(number);i++)
        {
            if ((i+1) % 2 == 0)
            {
                int digit = Integer.parseInt(temp.charAt(i) + "");
                int doubleNum = digit * 2;
                sum += getDigit(doubleNum);
            }
        }
        return sum;
    }


    /** Return this number if it is a single digit, otherwise,
     * return the sum of the two digits */
    public static int getDigit(int number)
    {
        String temp = number + "";

        if (temp.length() == 1)
            return number;
        else {
            int sum = 0;
            for (int i = 0;i < getSize(number);i++)
            {
                int digit = Integer.parseInt(temp.charAt(i) + "");
                sum += digit;
            }
            return sum;
        }
    }

    /** Return sum of odd-place digits in number */
    public static int sumOfOddPlace(long number)
    {
        int sum = 0;
        String temp = new StringBuilder(number + "").reverse().toString();

        for (int i = 0;i < getSize(number);i++)
        {
            if ((i+1) % 2 == 1)
            {
                int digit = Integer.parseInt(temp.charAt(i) + "");
                sum += digit;
            }
        }
        return sum;
    }

    /** Return true if the number d is a prefix for number */
    public static boolean prefixMatched(long number, int d)
    {
        return d == getPrefix(number, 1);
    }

    /** Return the number of digits in d */
    public static int getSize(long d)
    {
        return (d+"").length();
    }

    /** Return the first k number of digits from number. If the
     * number of digits in number is less than k, return number. */
    public static long getPrefix(long number, int k)
    {
        String temp = number + "";

        if (temp.length() < k)
            return number;

        return Long.parseLong(temp.substring(0, k));
    }
    
}