package myleetcode.templates;

import java.util.Arrays;

/**
 * Template class: help to calculate the sum of sub-rectangle region
 */
public class SubRegionSum {
    private int N, M;
    private int [][] sum;
    private int [][] A;

    public static void main(String [] args) {
        int [][] A = {{1,1,0},{0,1,1},{0,0,1}};
        new SubRegionSum(A).test();
    }

    public SubRegionSum(int [][] A) {
        this.A = A;
        N = A.length;
        M = A[0].length;
        sum = new int[N+1][M+1];

        for(int i=0; i<N; i++) {
            for(int j=0; j<M; j++) {
                sum[i+1][j+1] = sum[i+1][j] + sum[i][j+1] - sum[i][j] + A[i][j];
            }
        }
        System.out.println("A[][] = " + Arrays.deepToString(A));
        System.out.println("sum[][] = " + Arrays.deepToString(sum));
    }

    // Query the sum of all elements in rectangle region A[x1][y1] to A[x2][y2]
    public int querySum(int x1, int y1, int x2, int y2) {
        int regionSum = sum[x2+1][y2+1] - sum[x2][y1] - sum[x1][y2] + sum[x1][y1];
        return regionSum;
    }


    private void test() {

        int res1 = querySum(0,0,2,2);
        System.out.println("regionSum=" + res1 + ", expected = 5");
        int res2 = querySum(0,1,1,2);
        System.out.println("regionSum=" + res2 + ", expected = 3");

    }
}
