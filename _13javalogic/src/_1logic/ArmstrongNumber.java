package _1logic;

public class ArmstrongNumber {
    public static boolean isAmrstrong(int number)
    {
        int originalNumber = number;
        int sum = 0 ;
        int numDigits = String.valueOf(originalNumber).length();

        while(number>0){
            int digit = number % 10; // modulus mengambil digit terakhir
            sum += Math.pow(digit,numDigits); // digit terakhir pagnakt num digit
            number /= 10; // operasi matematik untuk membuang digit terakhir
        }

        return sum == originalNumber;
    }
}
