package simplexmetoda;


public class Main {

    public static double function(double x1, double x2){
        return x1 + 2 * x2;
    }

    private static void minimum(double[] cj, double[][] ograniczenia) {
        double[] ci = {0, 0};
        double max = 0, min = 10000, wartosc_na_skrzyzowaniu, iteracja = 0;
        int kryterium_wyjscia = 0, kryterium_wejscia = 0, ilosc_niedodatnich = 0;


        for (int i = 2; i < 3; i++) {
            for (int j = 0; j < 4; j++) {
                ograniczenia[i][j] = ci[0] * ograniczenia[0][j] + ci[1] * ograniczenia[1][j];
            }
        }

        for (int i = 3; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                ograniczenia[i][j] = cj[j] - ograniczenia[2][j];

                if (ograniczenia[i][j] < min  && ograniczenia[i][5] >= 0) {
                    min = ograniczenia[i][j];
                    kryterium_wyjscia = j;
                }
            }
        }

        for (int i = 0; i < 2; i++) {
            ograniczenia[i][5] = ograniczenia[i][4] / ograniczenia[i][kryterium_wyjscia];
            if(ograniczenia[i][5] > max) {
                max = ograniczenia[i][5];
                kryterium_wejscia = i;
            }
        }
        wartosc_na_skrzyzowaniu = ograniczenia[kryterium_wejscia][kryterium_wyjscia];
        while(!(ilosc_niedodatnich == 4)) {
            for (int j = 0; j < 5; j++) {
                if (kryterium_wejscia == 1) {
                    ograniczenia[0][j] = ograniczenia[0][j] - (wartosc_na_skrzyzowaniu * ograniczenia[kryterium_wejscia][j]);
                    System.out.println(ograniczenia[0][j]);
                }
                else if (kryterium_wejscia == 0) {
                    ograniczenia[1][j] = ograniczenia[1][j] - (wartosc_na_skrzyzowaniu * ograniczenia[kryterium_wejscia][j]);
                    System.out.println(ograniczenia[0][j]);
                }
            }
            if (iteracja >= 1) {
                min = 10000;
                max = 0;
                for (int j = 0; j < 5; j++) {
                    ograniczenia[kryterium_wejscia][j] = ograniczenia[kryterium_wejscia][j] / wartosc_na_skrzyzowaniu;
                    System.out.println(" x[" + kryterium_wejscia + "][" + j + "] = " + ograniczenia[kryterium_wejscia][j]);
                }
                double przk = 0;
                if (kryterium_wejscia == 1) {
                    przk = ograniczenia[0][kryterium_wyjscia];
                }
                else if  (kryterium_wejscia == 0) {
                    przk = ograniczenia[1][kryterium_wyjscia];
                }
                for (int j = 0; j < 5; j++) {
                    if (kryterium_wejscia == 1) {
                        ograniczenia[0][j] = ograniczenia[0][j] - ograniczenia[kryterium_wejscia][j] * przk;
                        System.out.println("x[" + 0 + "][" + j + "] = " + ograniczenia[0][j]);
                    }
                    else if (kryterium_wejscia == 0) {
                        ograniczenia[1][j] = ograniczenia[1][j] - ograniczenia[kryterium_wejscia][j] * przk;
                        System.out.println("x[" + 1 + "][" + j + "] = " + ograniczenia[1][j]);
                    }
                }
            }
            ci[kryterium_wejscia] = cj[kryterium_wyjscia];

            for (int i = 2; i < 3; i++) {
                for (int j = 0; j < 4; j++) {
                    ograniczenia[i][j] = ci[0] * ograniczenia[0][j] + ci[1]*ograniczenia[1][j];
                }
            }

            for (int i = 3; i < 4; i++) {
                for (int j = 0; j < 4; j++) {
                    ograniczenia[i][j] = cj[j] - ograniczenia[2][j];
                    if (ograniczenia[i][j] < min  && ograniczenia[i][5] >= 0) {
                        min = ograniczenia[i][j];
                        kryterium_wyjscia = j;
                    }
                }
            }

            for (int j = 0; j < 4; j++) {
                if (ograniczenia[3][j] >= 0) {
                    ilosc_niedodatnich += 1;
                }
            }
                if(!(ilosc_niedodatnich == 4)) {
                    ilosc_niedodatnich = 0;
                }

            for (int i = 0; i < 2; i++) {
                ograniczenia[i][5] = ograniczenia[i][4] / ograniczenia[i][kryterium_wyjscia];

                if(ograniczenia[i][5] > max) {
                    max = ograniczenia[i][5];
                    kryterium_wejscia = i;
                }
            }
            wartosc_na_skrzyzowaniu = ograniczenia[kryterium_wejscia][kryterium_wyjscia];
            iteracja++;

        }
        System.out.println("Wynik: x1 = " + ograniczenia[0][4] + ", x2 = " + ograniczenia[1][4] + ", f(x) = " + function(ograniczenia[0][4], ograniczenia[1][4]));

    }

    private static void maksimum(double[] cj, double[][] ograniczenia) {
        double max = 0, min = 10000, wartosc_na_skrzyzowaniu;
        double[] ci = {0,  0};
        int iteracja = 0;
        int kryterium_wejscia = 0, kryterium_wyjscia = 0, ilosc_niedodatnich = 0;

        for (int j = 0; j < 4; j++) {
            ograniczenia[2][j] = ci[0] * ograniczenia[0][j] + ci[1] * ograniczenia[1][j];
        }

        for (int j = 0; j < 4; j++) {
            ograniczenia[3][j] = cj[j] - ograniczenia[2][j];
            if (ograniczenia[3][j] > max) {
                max = ograniczenia[3][j];
                kryterium_wejscia = j;
            }
        }

        for (int i = 0; i < 2; i++) {
            ograniczenia[i][5] = ograniczenia[i][4] / ograniczenia[i][kryterium_wejscia];
            if(ograniczenia[i][5] < min && ograniczenia[i][5] >= 0) {
                min = ograniczenia[i][5];
                kryterium_wyjscia = i;
            }
        }
        wartosc_na_skrzyzowaniu = ograniczenia[kryterium_wyjscia][kryterium_wejscia];

        while(!(ilosc_niedodatnich == 4)) {
            for (int j = 0; j < 5; j++) {
                if (kryterium_wyjscia == 1) {
                    ograniczenia[0][j] = ograniczenia[0][j] - (wartosc_na_skrzyzowaniu * ograniczenia[kryterium_wyjscia][j]);
                }
                else if (kryterium_wyjscia == 0) {
                    ograniczenia[1][j] = ograniczenia[1][j] - (wartosc_na_skrzyzowaniu * ograniczenia[kryterium_wyjscia][j]);
                }
            }

            if (iteracja >= 1) {
                min = 10000;
                max = 0;
                for (int j = 0; j < 5; j++) {
                    ograniczenia[kryterium_wyjscia][j] = ograniczenia[kryterium_wyjscia][j] / wartosc_na_skrzyzowaniu;
                }
                double przk = 0;
                if (kryterium_wyjscia == 1) {
                    przk = ograniczenia[0][kryterium_wejscia];
                }
                else if  (kryterium_wyjscia == 0) {
                    przk = ograniczenia[1][kryterium_wejscia];
                }
                for (int j = 0; j < 5; j++) {
                    if (kryterium_wyjscia == 1) {
                        ograniczenia[0][j] = ograniczenia[0][j] - ograniczenia[kryterium_wyjscia][j] * przk;
                    }
                    else if (kryterium_wyjscia == 0) {
                        ograniczenia[1][j] = ograniczenia[1][j] - ograniczenia[kryterium_wyjscia][j] * przk;
                    }
                }
            }
            ci[kryterium_wyjscia] = cj[kryterium_wejscia];

            for (int i = 2; i < 3; i++) {
                for (int j = 0; j < 4; j++) {
                    ograniczenia[i][j] = ci[0]*ograniczenia[0][j] + ci[1] * ograniczenia[1][j];
                }
            }

            for (int i = 3; i < 4; i++) {
                for (int j = 0; j < 4; j++) {
                    ograniczenia[i][j] = cj[j] - ograniczenia[2][j];
                    if (ograniczenia[i][j] > max) {
                        max = ograniczenia[i][j];
                        kryterium_wejscia = j;
                    }
                }
            }

            for (int j = 0; j < 4; j++) {
                if (ograniczenia[3][j] <= 0) {
                    ilosc_niedodatnich += 1;
                }
            }

            if (!(ilosc_niedodatnich == 4)) {
                ilosc_niedodatnich = 0;
            }

            for (int i = 0; i < 2; i++) {
                ograniczenia[i][5] = ograniczenia[i][4] / ograniczenia[i][kryterium_wejscia];

                if(ograniczenia[i][5] < min && ograniczenia[i][5] >= 0) {
                    min = ograniczenia[i][5];
                    kryterium_wyjscia = i;
                }
            }
            wartosc_na_skrzyzowaniu = ograniczenia[kryterium_wyjscia][kryterium_wejscia];
            iteracja++;
        }
        System.out.println("Wynik: x1 = " + ograniczenia[0][4] + ", x2 = " + ograniczenia[1][4] + ", f(x) = " + function(ograniczenia[0][4], ograniczenia[1][4]));
    }

    public static void main(String[] args) {
        double[] cj = {1,2,0,0};
        double[][] ograniczenia =  {{1, 1, 1, 0, 10, 0},
                {-2, 1, 0, 1, 4, 0},
                {0,0,0,0,0,0},
                {0,0,0,0,0,0}};
        maksimum(cj, ograniczenia);
    }
}