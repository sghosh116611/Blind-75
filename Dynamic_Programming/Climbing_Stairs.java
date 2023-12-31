package Dynamic_Programming;

public class Climbing_Stairs {
    public int climbStairs(int n) {
        int a = 1;
        int b = 2;

        if(n == 1)
            return 1;
        
        if(n == 2)
            return 2;

        int sum = 0;
        for(int i = 3; i <= n; i++){
            sum = a + b;
            a = b;
            b = sum;
        }
        return sum;
    }
}

//Note
// 1. Fibonacci series