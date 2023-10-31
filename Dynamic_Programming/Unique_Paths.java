package Dynamic_Programming;

public class Unique_Paths{
    public int uniquePaths(int m, int n) {
        int i = 0, j = 0;
        return traverse(m,n);
    }
    public int traverse(int i, int j, int m, int n, int count){
        if(i == m - 1 && j == n - 1){
            return 1;
        }else if(i == m  || j == n ){
            return 0;
        }
        return traverse(i + 1, j, m, n, count) + traverse(i, j + 1, m, n, count);
    }
    public int traverse(int m, int n){
        int N = m + n - 2;
        int r = m - 1;
        double res = 1;
        for(int i = 1; i <= r; i++){
            res = res*(N - r + i) / i;
        }
        return (int)res;
    }
}