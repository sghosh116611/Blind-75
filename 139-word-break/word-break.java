class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] dp = new boolean[s.length() + 1];
     
        // return f(0,s,new HashSet(wordDict));
        // return fMemoization(0,s,new HashSet(wordDict),dp);
        return fTabulation(s, new HashSet(wordDict), dp);
    }

    public boolean f(int idx, String s, HashSet<String> dict){
        if(idx == s.length())
            return true;
        
        for(int i = idx + 1; i <= s.length(); i++){
            if(dict.contains(s.substring(idx,i)) && f(i, s, dict))
                return true;
        }
        return false;
    }

    public boolean fMemoization(int idx, String s, HashSet<String> dict, Boolean[] dp){
        if(idx == s.length())
            return true;

        if(dp[idx] != null)
            return dp[idx];

        for(int i = idx + 1; i <= s.length(); i++){
            if(dict.contains(s.substring(idx,i)) && f(i, s, dict))
                return dp[idx] = true;
        }
        return dp[idx] = false;
    }

     public boolean fTabulation(String s, HashSet<String> dict, boolean[] dp){
        dp[s.length()] = true;

        for(int i = s.length() - 1; i >= 0; i--){
            for(int idx = i + 1;!dp[i] && idx <= s.length(); idx++){
                 dp[i] = dict.contains(s.substring(i,idx)) && dp[idx];
            }
        }
        return dp[0];
    }
}