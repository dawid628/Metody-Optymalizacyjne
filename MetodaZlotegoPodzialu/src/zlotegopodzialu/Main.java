package zlotegopodzialu;

public class Main {

    public static double function(double x){
        return  Math.pow(x,3) / 3.0 + 2.05 * Math.pow(x,2) - 9 * x + 15;
    }

    public static void metoda(double a, double b, double e, boolean isMinimum){

        double k = (Math.sqrt(5) - 1) / 2;
        double x1 = b - k * (b - a);
        double x2 = a + k * (b - a);
        if(!isMinimum) {
            while (!(Math.abs(x2 - x1) < e)) {
                if (function(x1) > function(x2)) {
                    b = x2;
                    x2 = x1;
                    x1 = b - k * (b - a);
                } else {
                    a = x1;
                    x1 = x2;
                    x2 = a + k * (b - a);
                }
            }
        }
        if(isMinimum){
            while (!(Math.abs(x2 - x1) < e)) {
                if (function(x1) < function(x2)) {
                    b = x2;
                    x2 = x1;
                    x1 = b - k * (b - a);
                } else {
                    a = x1;
                    x1 = x2;
                    x2 = a + k * (b - a);
                }
            }
        }
        System.out.println("Metoda zlotego podzialu: " + (a+b)/2 );
    }

    public static void main(String[] args) {
        double a = -10;
        double b = -3;
        double e = 0.000001;
        boolean isMinimum = false;
        metoda(a,b,e,isMinimum);
    }
}
