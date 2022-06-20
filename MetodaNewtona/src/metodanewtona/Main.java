package metodanewtona;

import java.lang.Math;

public class Main {

    public static double h = 0.00001;

    public static double function(double x, double y) {
        return x*x*x + 2*y*y - 4*x*y - y + 5;
    }

    public static double pochodna_po_x(double x, double y) {
        return (function(x + h, y) - function(x, y)) / h;
    }

    public static double pochodna_po_y(double x, double y) {
        return (function(x, y + h) - function(x, y)) / h;
    }

    public static double pochodna_po_x_2(double x, double y) {
        return (function(x + 2*h, y) - 2* function(x + h, y) + function(x, y)) / Math.pow(h,2);
    }

    public static double pochodna_po_y_2(double x, double y) {
        return (function(x, y + 2*h) - 2* function(x, y + h) + function(x, y)) / Math.pow(h,2);
    }

    public static double pochodna_po_xy(double x, double y) {
        return (function(x + h, y + h) - function(x + h, y) - function(x, y + h) + function(x, y)) / Math.pow(h,2);
    }

    public static double pochodna_po_yx(double x, double y) {
        return (function(x + h, y + h) - function(x, y + h) - function(x + h, y) + function(x, y)) / Math.pow(h,2);
    }


    public static void metoda(double x0, double y0, double e) {
        double x1 = 0;
        double y1 = 0;
        double det;
        int i = 1;
        double [][] gradient = new double [2][2];
        double [][] hesseMatrix = new double [2][2];
        double [][] reversedMatrix = new double [2][2];
//!(pochodna_po_x(x1, y1) <= e && pochodna_po_y(x1, y1) <= e) || !(Math.abs(x1 - x0) <= e && Math.abs(y1 - y0) <= e)
        while(!(pochodna_po_x(x1, y1) <= e && pochodna_po_y(x1, y1) <= e) || !(Math.abs(x1 - x0) <= e && Math.abs(y1 - y0) <= e)) {
            // gradient
            gradient[0][0] = pochodna_po_x(x0, y0);
            gradient[0][1] = pochodna_po_y(x0, y0);
            // macierz Hessego
            hesseMatrix[0][0] = pochodna_po_x_2(x0, y0);
            hesseMatrix[0][1] = pochodna_po_xy(x0, y0);
            hesseMatrix[1][0] = pochodna_po_yx(x0, y0);
            hesseMatrix[1][1] = pochodna_po_y_2(x0, y0);
            // macierz odwrocona
            det = 1 / (hesseMatrix[0][0] * hesseMatrix[1][1] - hesseMatrix[0][1] * hesseMatrix[1][0]);
            reversedMatrix[0][0] = hesseMatrix[1][1] * det;
            reversedMatrix[0][1] = -1 *(hesseMatrix[0][1]) * det;
            reversedMatrix[1][0] = -1 * (hesseMatrix[1][0]) * det;
            reversedMatrix[1][1] = hesseMatrix[0][0] * det;

            x1 = x0 - (reversedMatrix[0][0] * gradient[0][0] + reversedMatrix[0][1] * gradient[0][1]);
            y1 = y0 - (reversedMatrix[1][0] * gradient[0][0] + reversedMatrix[1][1] * gradient[0][1]);

            x0 = x1;
            y0 = y1;
            i++;
        }
        System.out.println("Wynik w punkcie: ("+ x1 + ", " + y1 + "), iteracji:" + i);
    }

    public static void main(String[] args) {
        double x0 = 1, y0 = 1, e = 0.01;

        metoda(x0, y0, e);

       // System.out.println(function(1, 1));
    }
}
