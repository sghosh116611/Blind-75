package DataStructures;

public class Palindromic_Substring {
    public int countSubstrings(String s) {
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        int count = 0;

        for (int i = n - 1; i >= 0; i--) {
            for (int j = i; j < n; j++) {
                System.out.println(i + " " + j);
                dp[i][j] = s.charAt(i) == s.charAt(j) && (j - i + 1 < 3 || dp[i + 1][j - 1]);
                if (dp[i][j])
                    count++;
            }
        }

        return count;
    }
}
