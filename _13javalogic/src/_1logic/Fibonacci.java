package _1logic;

import java.util.ArrayList;
import java.util.List;

public class Fibonacci {

    // 0 1 1 2 3 5 8 13
    public static void main(String[] args) {
        //dari index 0
        System.out.println("Fibonaci ke 4 " + fibonaciValueOn(4));
    }

    public static void printFibonacci()
    {
        List<Integer> fibonaci = new ArrayList<>();
        fibonaci.add(0);
        fibonaci.add(1);
        for (int i = 0 ; i<10;i++)
        {
            if(fibonaci.size() < 3){
                fibonaci.add(i);
            }
            fibonaci.add(fibonaci.get(i)+fibonaci.get(i+1));
        }
        fibonaci.forEach(System.out::println);
    }

    public static int fibonaciValueOn(int n)
    {
        int a = 0, b = 1 , c , i;
        if(n==0)
            return a;

        //1
        for(i = 2 ; i<=n ;i++)
        {
            c = a+b;
            a = b;
            b = c;
        }
        return b;
    }

    public static int fibonaciRecursive(int n)
    {
        // 0 dan 1
        if(n<=1){
            return n;
        }
        return fibonaciRecursive(n-1) + fibonaciRecursive(n-2);

    }
}
