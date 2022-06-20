package gaussaseidla;

public class Main {
    public static double h = 0.00001;
    public static double a = 0;
    public static double b = 100;

    public static double function(double x, double y){
        return x*x*x + 2*y*y - 4*x*y - y + 5;
    }

    public static double pochodna_po_x(double x, double y){
        return (function(x + h, y) - function(x, y)) / h;
    }

    public static double pochodna_po_y(double x, double y) {
        return (function(x, y + h) - function(x, y)) / h;
    }

    public static double pochodna_po_x_2(double x, double y){
        return (function(x + 2 * h, y) - 2* function(x + h, y) + function(x, y)) / (h*h);
    }

    public static double pochodna_po_y_2(double x, double y){
        return (function(x, y + 2 * h) - 2* function(x, y + h) + function(x, y)) / (h*h);
    }

    public static double pochodna_po_x_3(double x, double y) {
        return 6;
    }

    public static double pochodna_po_y_3(double x, double y) {
        return 0;
    }

    public static double stycznych_x(double x0, double e){
        double result = 0, x1 = 0;
        // warunek konieczny
        if( (pochodna_po_x(a, x0) * pochodna_po_x(b, x0) < 0) ){
            // warunek konieczny
            if( (pochodna_po_x_2(a, x0) * pochodna_po_x_2(b, x0) >= 0) && (pochodna_po_x_3(a, x0) * pochodna_po_x_3(b, x0) >= 0) ){
                if( (pochodna_po_x_3(a, x0) * pochodna_po_x(a, x0) > 0) ){
                    x1 = a;
                }
                else{
                    x1 = b;
                }
                while( !((Math.abs(pochodna_po_x(result, x0))) < e && (Math.abs(result - x1) < e )) ){
                    result = x1 - (pochodna_po_x(x1, x0) / pochodna_po_x_2(x1, x0));
                    x1 = result;
                }
                return result;
            }
        }
        return 0;
    }

    public static double stycznych_y(double x0, double e){
        double result = 0, x1 = 0;
        // warunek konieczny
        if( (pochodna_po_y(x0, a) * pochodna_po_y(x0, b) < 0) ){
            // warunek konieczny
            if( (pochodna_po_y_2(x0, a) * pochodna_po_y_2(x0, b) >= 0) && (pochodna_po_y_3(x0, a) * pochodna_po_y_3(x0, b) >= 0) ){
                if( (pochodna_po_y_3(x0, a) * pochodna_po_y(x0, a) > 0) ){
                    x1 = a;
                }
                else{
                    x1 = b;
                }
                while( !(((Math.abs(pochodna_po_y(x0, result))) < e) && ((Math.abs(result - x1) < e) )) ){
                    result = x1 - (pochodna_po_y(x0, x1) / pochodna_po_y_2(x0, x1));
                    x1 = result;
                }
                return result;
            }
        }
        return 0;
    }

    public static void metoda(double x0, double y0, double e){
        double x1 = x0, y1 = y0;
        int i = 1;
// !((Math.abs(pochodna_po_x(x1, y1)) <= e && Math.abs(pochodna_po_y(x1, y1)) <= e))
        while( !((Math.abs(pochodna_po_x(x1, y1)) <= e && Math.abs(pochodna_po_y(x1, y1)) <= e)) ){
            x1 = stycznych_x(y1, e);
            y1 = stycznych_y(x1, e);
            i++;
        }
        System.out.println("("+ x1 + ", " + y1 + ") iteracje: " + i);
    }

    public static void main(String[] args){
        double x0 = 1, y0 = 1, e = 0.000001;
        metoda(x0, y0, e);
    }
}