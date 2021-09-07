//public class HelloWorld {
//    public static void main(String[] args) {
//        System.out.println("Hello, World!");
//    }
//}

//"Hello, World!1"

//class HelloWorld {
//    public static void main(String[] args) {
//        System.out.println("Привет, мир!");
//        int i = 125215+49546;
//        System.out.println(i);
//    }
//}


import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class lbl2 {

    public static void main(String[] args) throws FileNotFoundException, CloneNotSupportedException
    {   long start_time = System.currentTimeMillis();
       String route = "C:\\Users\\privalovie\\YandexDisk\\Универ\\Конструирование\\labs\\lbl2.txt", str, str1;
//         Graph Gor Graph12
//        String route = "F:\\YandexDisk\\Универ\\Конструирование\\labs\\lbl2.txt", str, str1;
        int zz=0,i1 = 0;
        double b = 31.21;
        double summj1 = 0.0, summj2 = 0.0, summj3 = 0.0, summj4 = 0.0, summj5 = 0.0, summj5_5 = 0.0; //общее число ошибок в программе
        int[] array;
        //double[][] data;
        int [][] data = new int[26][2];

        data[0][0] = 1;
        data[1][0] = 2;
        data[2][0] = 3;
        data[3][0] = 4;
        data[4][0] = 5;
        data[5][0] = 6;
        data[6][0] = 7;
        data[7][0] = 8;
        data[8][0] = 9;
        data[9][0] = 10;
        data[10][0] = 11;
        data[11][0] = 12;
        data[12][0] = 13;
        data[13][0] = 14;
        data[14][0] = 15;
        data[15][0] = 16;
        data[16][0] = 17;
        data[17][0] = 18;
        data[18][0] = 19;
        data[19][0] = 20;
        data[20][0] = 21;
        data[21][0] = 22;
        data[22][0] = 23;
        data[23][0] = 24;
        data[24][0] = 25;
        data[25][0] = 26;

        data[0][1] = 9;
        data[1][1] = 12;
        data[2][1] = 11;
        data[3][1] = 4;
        data[4][1] = 7;
        data[5][1] = 2;
        data[6][1] = 5;
        data[7][1] = 8;
        data[8][1] = 5;
        data[9][1] = 7;
        data[10][1] = 1;
        data[11][1] = 6;
        data[12][1] = 1;
        data[13][1] = 9;
        data[14][1] = 4;
        data[15][1] = 1;
        data[16][1] = 3;
        data[17][1] = 3;
        data[18][1] = 6;
        data[19][1] = 1;
        data[20][1] = 11;
        data[21][1] = 33;
        data[22][1] = 7;
        data[23][1] = 91;
        data[24][1] = 2;
        data[25][1] = 1;

            /*FileReader finkol = new FileReader(route);
            Scanner src1 = new Scanner(finkol); // Чтение из файла

            while (src1.hasNext()) {str1 = src1.nextLine(); zz++;}

            finkol.close();
            FileReader fin = new FileReader(route);
            Scanner src = new Scanner(fin); // Чтение из файла

            array = new int[zz];
            data = new double[zz][6];

            while (src.hasNext()) {
                str = src.nextLine();
                if(str.length()!=0) {
                    array[i1] = Integer.parseInt(str);
                    i1++;}
            }
            fin.close();*/

            List<sobject> lSobjects = new ArrayList<>();

            for (int m = 0; m<=25;m++){
                sobject s = new sobject();
                //Номер ошибки (i)
                double i = data[m][0];
                //Интервал между ошибками (Xi, дни)
                int xi = data[m][1];
                // i * Xi
                double p1 = i * xi;
                // 1/B-i+1
                double p2 = 1 / (b - i + 1);
                // (B-i+1)*Xi
                double p3 = (b - i + 1) * xi;
                // 1/i
                double p4 = 1 / i;

                s.i = (int)i;
                s.xi = xi;
                s.coeff1 = p1;
                s.coeff2 = p2;
                s.coeff3 = p3;
                s.coeff4 = p4;
                lSobjects.add(s);
            }

            if (!lSobjects.isEmpty()){
                int iCount = 0;
                double EiXi = 0;
                double EXi = 0;
                double nEXi = 0;
                double EBi1Xi = 0;
                double Bn = 0;
                double B1EXi = 0;
                double fb1 = 0;
                double fb2 = 0;
                double fb3 = 0;
                double k = 0;
                double xn1 = 0;
                double tk = 0;
                double odi = 0;
                List <Double> lP4 = new ArrayList<>();
                for (sobject s : lSobjects){
                    int i = s.i;
                    int xi = s.xi;
                    double p1 = s.coeff1;
                    double p2 = s.coeff2;
                    double p3 = s.coeff3;
                    double p4 = s.coeff4;

                    EiXi = EiXi + p1;
                    EXi = EXi + xi;
                    iCount++;
                    EBi1Xi = EBi1Xi + p3;
                    fb1 = fb1 + p2;
                    lP4.add(p4);
                }
                Bn = b - iCount;
                nEXi = iCount * EXi;
                B1EXi = (b + 1) * EXi;
                fb2 = nEXi / (B1EXi - EiXi);
                fb3 = fb1 - fb2;
                k = iCount / EBi1Xi;
                xn1 = 1 / (k * (b - iCount));

                for (int xz = 0; xz<(int) Bn; xz++){
                    odi = odi + lP4.get(xz);
                }

                tk = (1.0 / k) * odi;

                lobject l1 = new lobject();

                l1.ParamВ = b;
                l1.EiXi = EiXi;//E(i*Xi)
                l1.EXi = EXi;//E(Xi)
                l1.nEXi = nEXi;//n * E(Xi)
                l1.EBi1Xi = EBi1Xi;//E((B-i+1)*Xi)
                l1.Bn = Bn;//B - n
                l1.B1EXi = B1EXi;//(B+1) * E(Xi)
                l1.Fb1 = fb1;//F(b1)
                l1.Fb2 = fb2;//F(b2)
                l1.Fb1Fb2 = fb3;//F(b1) - F(b2)
                l1.K = k;//K
                l1.Xn1 = xn1;//Xn+1
                l1.tk = tk;//tk

                long stop_time = System.currentTimeMillis();
                long run_time = stop_time - start_time;
                output(l1,run_time);
            }
    }

    public static class sobject implements Cloneable
    {int i, xi; double coeff1, coeff2, coeff3, coeff4;}

    public static class lobject implements Cloneable
    {double ParamВ, EiXi, EXi, nEXi, EBi1Xi, Bn, B1EXi, Fb1, Fb2, Fb1Fb2, K, Xn1, tk;}

    public static void output(lobject l1, long run_time)
    {
        System.out.println("============================================");
        System.out.println("============================================");
        System.out.println("Тестовые параметры:");
        System.out.println("B: "+l1.ParamВ);
        System.out.println("E(i*Xi): "+l1.EiXi);
        System.out.println("E(Xi): "+l1.EXi);
        System.out.println("n * E(Xi): "+l1.nEXi);
        System.out.printf("E((B-i+1)*Xi): %2.2f",l1.EBi1Xi);
        System.out.println();
        System.out.printf("B - n: %2.2f",l1.Bn);
        System.out.println();
        System.out.println("(B+1) * E(Xi): "+l1.B1EXi);
        System.out.println("============================================");
        System.out.println("a)");
        System.out.printf("F(b1): %2.8f",l1.Fb1);
        System.out.println();
        System.out.printf("F(b2): %2.8f",l1.Fb2);
        System.out.println();
        System.out.printf("F(b1) - F(b2): %2.8f",l1.Fb1Fb2);
        System.out.println();
        System.out.println("b)");
        System.out.printf("K: %2.8f",l1.K);
        System.out.println();
        System.out.println("c)");
        System.out.printf("Xn+1: %2.8f",l1.Xn1);
        System.out.println();
        System.out.println("d)");
        System.out.printf("tk: %2.8f",l1.tk);
        System.out.println();
        System.out.println("Время выполнения: " + run_time + " сек.");
        System.out.println("============================================");
        System.out.println("============================================");
    }

}