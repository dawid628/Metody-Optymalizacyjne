package hookajeveesa;

public class Main {

    public static int j;
    public static int i = 1;

    public static double function(double x, double y) {

        return x*x*x + 2*y*y - 4*x*y - y + 5;
    }

    public static void krok_1(double[][] x0, double x1, double x2, int n, double beta, double e, double epsilon, double[][] si, double[][] xb, boolean isMinimum) {
        double f0, fb;
        j = 1;


        f0 = function(x0[0][0], x0[0][1]);
        fb = function(x1, x2);
        i++;
        krok_2(x0, x1, x2, n, beta, e, epsilon, f0, fb, si, xb, isMinimum);

    }

    public static void krok_2(double[][] x0, double x1, double x2, int n, double beta, double e, double epsilon, double f0, double fb, double[][] si, double[][] xb, boolean isMinimum) {

        x0[j][0] = x0[j - 1][0] + e * si[j - 1][0];
        x0[j][1] = x0[j - 1][1] + e * si[j - 1][1];

        if(isMinimum) {
            minimum_3(x0, x1, x2, n, beta, e, epsilon, f0, fb, si, xb, isMinimum);
        }
        if(!isMinimum){
            maksimum_3(x0, x1, x2, n, beta, e, epsilon, f0, fb, si, xb, isMinimum);
        }
    }

    public static void minimum_3(double[][] x0, double x1, double x2, int n, double beta, double e, double epsilon, double f0, double fb, double[][] si, double[][] xb, boolean isMinimum) {

        if( function(x0[j][0], x0[j][1]) < f0 ) {
            f0 = function(x0[j][0], x0[j][1]);

            minimum_5(x0, x1, x2, n, beta, e, epsilon, f0, fb, si, xb, isMinimum);
        }
        else {
            x0[j][0] -= 2*e * si[j - 1][0];
            x0[j][1] -= 2*e * si[j - 1][1];

            minimum_4(x0, x1, x2, n, beta, e, epsilon, f0, fb, si, xb, isMinimum);
        }
    }

    public static void minimum_4(double[][] x0, double x1, double x2, int n, double beta, double e, double epsilon, double f0, double fb, double[][] si, double[][] xb, boolean isMinimum) {

        if( function(x0[j][0], x0[j][1]) < f0 ) {
            f0 = function(x0[j][0], x0[j][1]);

            minimum_5(x0, x1, x2, n, beta, e, epsilon, f0, fb, si, xb, isMinimum);
        }
        else {
            x0[j][0] += e * si[j - 1][0];
            x0[j][1] += e * si[j - 1][1];

            minimum_5(x0, x1, x2, n, beta, e, epsilon, f0, fb, si, xb, isMinimum);
        }
    }

    public static void minimum_5(double[][] x0, double x1, double x2, int n, double beta, double e, double epsilon, double f0, double fb, double[][] si, double[][] xb, boolean isMinimum) {

        if (j != n) {
            j += 1;

            krok_2(x0, x1, x2, n, beta, e, epsilon, f0, fb, si, xb, isMinimum);
        }
        else {
            if (fb > f0) {
                krok_6(x0, x1, x2, n, beta, e, epsilon, si, xb, isMinimum);
            }
            else {
                krok_7(x0, x1, x2, n, beta, e, epsilon, si, xb, isMinimum);
            }
        }
    }

    public static void maksimum_3(double[][] x0, double x1, double x2, int n, double beta, double e, double epsilon, double f0, double fb, double[][] si, double[][] xb, boolean isMinimum) {

        if( function(x0[j][0], x0[j][1]) > f0 ) {
            f0 = function(x0[j][0], x0[j][1]);

            maksimum_5(x0, x1, x2, n, beta, e, epsilon, f0, fb, si, xb, isMinimum);
        }
        else {
            x0[j][0] -= 2*e * si[j - 1][0];
            x0[j][1] -= 2*e * si[j - 1][1];

            maksimum_4(x0, x1, x2, n, beta, e, epsilon, f0, fb, si, xb, isMinimum);
        }
    }

    public static void maksimum_4(double[][] x0, double x1, double x2, int n, double beta, double e, double epsilon, double f0, double fb, double[][] si, double[][] xb, boolean isMinimum) {

        if( function(x0[j][0], x0[j][1]) > f0 ) {
            f0 = function(x0[j][0], x0[j][1]);

            maksimum_5(x0, x1, x2, n, beta, e, epsilon, f0, fb, si, xb, isMinimum);
        }
        else {
            x0[j][0] += e * si[j - 1][0];
            x0[j][1] += e * si[j - 1][1];

            maksimum_5(x0, x1, x2, n, beta, e, epsilon, f0, fb, si, xb, isMinimum);
        }
    }

    public static void maksimum_5(double[][] x0, double x1, double x2, int n, double beta, double e, double epsilon, double f0, double fb, double[][] si, double[][] xb, boolean isMinimum) {

        if (j != n) {
            j += 1;

            krok_2(x0, x1, x2, n, beta, e, epsilon, f0, fb, si, xb, isMinimum);
        }
        else {
            if (fb < f0) {
                krok_6(x0, x1, x2, n, beta, e, epsilon, si, xb, isMinimum);
            }
            else {
                krok_7(x0, x1, x2, n, beta, e, epsilon, si, xb, isMinimum);
            }
        }
    }

    public static void krok_6(double[][] x0, double x1, double x2, int n, double beta, double e, double epsilon, double[][] si, double[][] xb, boolean isMinimum) {
        // etap roboczy
        xb[0][0] = x1;
        xb[0][1] = x2;

        x1 = x0[j][0];
        x2 = x0[j][1];

        x0[0][0] = x1 + (x1 - xb[0][0]);
        x0[0][1] = x2 + (x2 - xb[0][1]);

        krok_1(x0, x1, x2, n, beta, e, epsilon, si, xb, isMinimum);
    }

    public static void krok_7(double[][] x0, double x1, double x2, int n, double beta, double e, double epsilon, double[][] si, double[][] xb, boolean isMinimum) {

        if (e > epsilon) {
            e *= beta;
            x0[0][0] = x1;
            x0[0][1] = x2;

            krok_1(x0, x1, x2, n, beta, e, epsilon, si, xb, isMinimum);
        }
        else {
            System.out.println("Wynik: " + x0[0][0] + ", " + x0[0][1] + " iteracje:" + i);
        }
    }

    public static void main(String[] args) {
        double x1 = 1, x2 = 1, beta = 0.5, e = 0.5, epsilon = 0.000001;
        double [][] x0 = new double [10][2];
        double [][] xb;
        double [][] si = {
                {1,0},
                {0,1}
        };
        int n = 2;
        x0[0][0] = x1;
        x0[0][1] = x2;
        xb = x0;
        krok_1(x0, x1, x2, n, beta, e, epsilon, si, xb, true);
    }
}