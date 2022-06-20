package metodafibonacciego;

public class Metoda {

    public static double function(double x){
        // Moj przyklad:
        return  Math.pow(x,3) / 3.0 + 2.05 * Math.pow(x,2) - 9 * x + 15;
        // Przyklad z zajec:
        //return Math.pow((100-x),2);
    }

    public static double fibonacci(int n){
        if(n==0 || n==1){
            return 1;
        }
        else{
            return fibonacci(n-1) + fibonacci(n-2);
        }
    }

    public static int getN(double a, double b, double e){
        int n = 0;
        while( (b - a) / fibonacci(n) >= 2*e ){
            n++;
        }
        return n-2;
    }

    public static void metoda(double a, double b, double e, boolean isMinimum){
        // szukanie n
        int n = getN(a, b, e);

        // obliczanie x1 i x2
        double x1 = b - ((fibonacci(n-1)/ fibonacci(n))*(b-a));
        double x2 = a + ((fibonacci(n-1)/ fibonacci(n))*(b-a));

        // pozostale kroki
        if(isMinimum){
            System.out.println("Minimum dla a=" + a + " b=" + b + " x1=" + x1 + " x2=" + x2 + " e=" + e);
            while(!(Math.abs(x2-x1) < e) && !(n == 1)){
                if (function(x1) < function(x2)) {
                    b = x2;
                    x2 = x1;
                    n = n - 1;
                    x1 = b - ((fibonacci(n - 1) / fibonacci(n)) * (b - a));
                } else {
                    a = x1;
                    x1 = x2;
                    n = n - 1;
                    x2 = a + ((fibonacci(n-1)/ fibonacci(n))*(b-a));
                }
            }
        }
        if(!isMinimum){
            System.out.println("Maximum dla a=" + a + " b=" + b + " x1=" + x1 + " x2=" + x2 + " e=" + e);
            int it=0;
            while( it<13 ){

                if (function(x1) > function(x2)) {
                    b = x2;
                    x2 = x1;
                    n = n - 1;
                    x1 = b - ((fibonacci(n - 1) / fibonacci(n)) * (b - a));
                } else {
                    a = x1;
                    x1 = x2;
                    n = n - 1;
                    x2 = a + ((fibonacci(n-1)/ fibonacci(n))*(b-a));
                }
                it++;
            }
        }
        System.out.println("Wynik: x = " + (a+b)/2);
    }

    public static void main(String[] args) {
        // Moj przyklad
        double a = -10;
        double b = -3;
        double e = 0.001;
        // Przyklad z zajec
        //double a = 60;
        //double b = 150;
        //double E = 3;
        boolean isMinimum = false;
        metoda(a, b, e, isMinimum);
    }
}