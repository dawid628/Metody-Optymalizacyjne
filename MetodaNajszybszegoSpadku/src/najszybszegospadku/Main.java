package najszybszegospadku;

public class Main {

    public static double h = 0.00001;

    public static double function(double x, double y) {
        return x*x*x + 2*y*y - 4*x*y - y + 5;
    }

    public static double pochodna_po_x(double x, double y, double h) {
        return (function(x + h, y) - function(x, y)) / h;
    }

    public static double pochodna_po_y(double x, double y, double h) {
        return (function(x, y + h) - function(x, y)) / h;
    }

    public static double pochodna_po_x_2(double x, double y, double h) {
        return (function(x + 2*h, y) - 2* function(x + h, y) + function(x, y)) / (h*h);
    }

    public static double pochodna_po_y_2(double x, double y, double h) {
        return (function(x, y + 2*h) - 2* function(x, y + h) + function(x, y)) / (h*h);
    }

    public static double pochodna_po_xy(double x, double y, double h) {
        return (function(x + h, y + h) - function(x + h, y) - function(x, y + h) + function(x, y)) / (h*h);
    }

    public static double pochodna_po_yx(double x, double y, double h) {
        return (function(x + h, y + h) - function(x, y + h) - function(x + h, y) + function(x, y)) / (h*h);
    }

    public static void metoda(double x0, double y0, double e) {
        double x1 = 0, y1 = 0, a;

        double [] gradient = new double [2];
        double [][] macierz = new double [2][2];
        int i = 1;

        while( !((Math.abs(pochodna_po_x(x1, y1, h)) <= e && Math.abs(pochodna_po_y(x1, y1, h)) <= e) &&
                (Math.abs(x1 - x0) <= e && Math.abs(y1 - y0) <= e))){

            gradient[0] = pochodna_po_x(x0, y0, h);
            gradient[1] = pochodna_po_y(x0, y0, h);

            macierz[0][0] = pochodna_po_x_2(x0, y0, h);
            macierz[0][1] = pochodna_po_xy(x0, y0, h);
            macierz[1][0] = pochodna_po_yx(x0, y0, h);
            macierz[1][1] = pochodna_po_y_2(x0, y0, h);

            a = ( Math.pow(gradient[0],2) + Math.pow(gradient[1],2) ) /
                    ( gradient[0] * ( gradient[0] * macierz[0][0] - gradient[1] * macierz[1][0] ) +
                            ( gradient[1] * ( gradient[0] * macierz[0][1] - gradient[1] * macierz[1][1] )));

            x1 = x0 - a * gradient[0];
            y1 = y0 - a * gradient[1];

            x0 = x1;
            y0 = y1;
            i++;
        }
        System.out.println("Wynik w punkcie: ("+ x1 + ", " + y1 + ") iteracje:" + i);
    }

    public static void main(String[] args) {

        metoda(1, 1, 0.000001);
    }
}
