package dwudzielna;

public class Metoda {

    public static double function(double x){
        // moj przyklad:
        return  Math.pow(x,3) / 3.0 + 2.05 * Math.pow(x,2) - 9 * x + 15;
        // przyklad z zajec:
        //return Math.pow((100-x),2);
    }

    public static void metoda(double a, double b, double n, boolean minimum){
        double xsr, L, x1, x2;
        int iteration = 1;
        // krok 1
        xsr = (a + b) / 2;
        // krok 2
        L = b - a;
        x1 = a + (L / 4);
        x2 = b - (L / 4);
        // minimum/maksimum
        if(minimum) {
            while( L>n){
                if( function(x1) < function(xsr) ){
                    b = xsr; xsr = x1;
                }
                else{
                    if( function(x2) < function(xsr) ){
                        a = xsr; xsr = x2;
                    }
                    else{
                        a = x1; b = x2;
                    }
                }
                // krok 2
                L = b - a;
                System.out.println("Iteracja " + iteration);
                System.out.println("x1=" + x1 + " x2=" + x2 + "  f(x1)=" + function(x1) + " f(x2)=" + function(x2) + " (" + a + ";" + b + ")" + " L=" + L);
                x1 = a + (L / 4);
                x2 = b - (L / 4);
                iteration++;

            }
            System.out.println("\nMinimum=" + xsr + " L=" + L);
        }

        if(!minimum) {
            int it=0;
            while( L>n ){
                if( function(x1) > function(xsr) ){
                    b = xsr; xsr = x1;
                }
                else{
                    if( function(x2) > function(xsr) ){
                        a = xsr; xsr = x2;
                    }
                    else{
                        a = x1; b = x2;
                    }
                }
                // krok 2
                L = b - a;
                System.out.println("Iteracja " + iteration);
                System.out.println("x1=" + x1 + " x2=" + x2 + "  f(x1)=" + function(x1) + " f(x2)=" + function(x2) + "(" + a + ";" + b + ")" + "L=" + L);
                x1 = a + (L / 4);
                x2 = b - (L / 4);
                iteration++;
                it++;
            }
            System.out.println("\nMaximum=" + xsr + " L=" + L);
        }
    }

    public static void main(String[] args) {
        // Moj przyklad:
        double a = -10;
        double b = -3;
        double n = 0.01;
        boolean isMinimum = false;
        // Przyklad z lekcji:
        //double a = 60;
        //double b = 150;
        //double n = 12;
        //boolean isMinimum = true;

        metoda(a, b, n, isMinimum);
    }
}
