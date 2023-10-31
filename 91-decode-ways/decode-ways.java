class Solution {
    public int numDecodings(String s) {
        int[] dp = new int[s.length() + 1];
        Arrays.fill(dp,0);

        //return f(0,s);
        //return fMemoization(0,s,dp);
        return fTabulation(0,s,dp);
    }

    public int f(int idx, String s){
        if(idx == s.length())
            return 1;
        if(s.charAt(idx) == '0')
            return 0;
        int plusOne = f(idx + 1, s);
        int plusTwo = 0;
        if(idx < s.length() - 1 && (s.charAt(idx) == '1' || s.charAt(idx) == '2' && s.charAt(idx + 1) < '7')){
            plusTwo = f(idx + 2, s);
        }
        return plusOne + plusTwo;
    }

    public int fMemoization(int idx, String s, int[] dp){
        if(idx == s.length())
            return 1;
        if(s.charAt(idx) == '0')
            return 0;
        
        if(dp[idx] != -1)
            return dp[idx];

        int plusOne = f(idx + 1, s);
        int plusTwo = 0;
        if(idx < s.length() - 1 && (s.charAt(idx) == '1' || s.charAt(idx) == '2' && s.charAt(idx + 1) < '7')){
            plusTwo = f(idx + 2, s);
        }
        return dp[idx] = plusOne + plusTwo;
    }

    public int fTabulation(int idx, String s, int[] dp){
        dp[s.length()] = 1;
        for(int i = s.length() - 1; i >= 0; i--){
            if(s.charAt(i) == '0')
                dp[i] = 0;
            else{
                int plusOne = dp[i + 1];
                int plusTwo = 0;
                if(i < s.length() - 1 && 
                    (s.charAt(i) == '1' || s.charAt(i) == '2' && s.charAt(i + 1) < '7'))
                {
                    plusTwo = dp[i + 2];
                }
                dp[i] = plusOne + plusTwo;
            }
        }

        return dp[0];
    }
}