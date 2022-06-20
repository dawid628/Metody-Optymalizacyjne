package metodabisekcji;

public class Main {

    public static double function(double x){
        // Moj przyklad:
        return  Math.pow(x,3) / 3.0 + 2.05 * Math.pow(x,2) - 9 * x + 15;
        // Przyklad z zajec:
        //return Math.pow((100-x),2);
    }
    public static double fp(double x){
        return Math.pow(x,2) + 4.1 * x - 9;
        //return Math.pow(x,2) + x - 5;
    }

    public static double fpp(double x){
        return 2 * x + 4.1;
        //return 2*x+1;
    }
    public static double fppp(double x){
        return 2;
    }

    public static void metodaBisekcji(double a, double b, double e){
        // 1. dzielimy przedzial
        double xsr = (a+b)/2;
        while( !(fp(xsr) == 0) && !(Math.abs(fp(xsr)) < e) ){
            xsr = (a+b)/2;
            if( fp(xsr) * fp(a) < 0 ){
                // nowy przedzial [a,xsr]
                b=xsr;
            }
            else{
                // nowy przedzial [xsr,b]
                a=xsr;
            }
        }
        System.out.println("Metoda Bisekcji: " + xsr);
    }
    public static void metodaNewtona(double a, double b, double e){
        double x0,x1;

        if( !(fpp(a) * fpp(b) >= 0) && !(fppp(a) * fppp(b) >= 0) && !(fp(a)*fp(b)<0)){
            System.out.println("Warunki nie zostaly spelnione");
        }
        else{
            if( fppp(a)*fp(a) >= 0 ){
                x0=a;
            }
            else{
                x0=b;
            }
            x1 = x0 - (fp(x0) / fpp(x0));

            while( !(Math.abs(fp(x1)) < e) && !(x1 - x0 <e) ){
                x0 = x1;
                x1 = x0 - (fp(x0) / fpp(x0));
            }
            System.out.println("Metoda Newtona: " + x1);
        }
    }
    public static void metodaSiecznych(double a, double b, double e) {
        double x1 = 0;
        double x0;
        // nieruchome a
        if ((fppp(a) >= 0 && fp(a) >= 0) || (fppp(a) < 0 && fp(a) < 0)) {
            x0 = b;
            x1 = x0 - ((fp(x0) / (fp(x0) - fp(a))) * (x0 - a));
            while(!(Math.abs(fp(x1)) < e) ||  !(Math.abs(x1 - x0) < e)) {
                x1 = x0 - ((fp(x0) / (fp(x0) - fp(a))) * (x0 - a));
                x0 = x1;
            }
        }
        // nieruchome b
        if ((fpp(b) >= 0 && fp(b) >= 0) || (fppp(b) < 0 && fp(b) < 0)) {
            x0 = a;
            x1 = x0 - ((fp(x0) / (fp(b) - fp(x0))) * (b - x0));
            while( !(Math.abs(fp(x1)) < e) || !(Math.abs(x1 - x0) < e) ) {
                x1 = x0 - ((fp(x0) / (fp(b) - fp(x0))) * (b - x0));
                x0 = x1;
            }
        }
        System.out.println("Metoda Siecznych: " + x1);
    }

    public static void main(String[] args) {
        // Przyklad z zajec:
        //double a = 1;
        //double b = 2;
        //double e = 0.01;
        // Moj przyklad
        double a = -10;
        double b = -3;
        double e = 0.1;
        metodaBisekcji(a, b, e);
        metodaNewtona(a, b, e);
        metodaSiecznych(a,b,e);
        System.out.println("Funkcja: " + function(-5.625));
    }
}
