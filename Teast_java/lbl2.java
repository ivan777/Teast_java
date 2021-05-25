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
//       String route = "C:\\Users\\privalovie\\YandexDisk\\Java_Информатика\\Курсовые\\Gor.txt", docsx, str, str1,u, ii;
//         Graph Gor Graph12
        String route = "F:\\YandexDisk\\Универ\\Конструирование\\labs\\lbl2.txt", str, str1;
        int zz=0,i1 = 0;
        double summj1 = 0.0, summj2 = 0.0, summj3 = 0.0, summj4 = 0.0, summj5 = 0.0, summj5_5 = 0.0; //общее число ошибок в программе
        int[] array;
        double[][] data;

        try
        {
            FileReader finkol = new FileReader(route);
            Scanner src1 = new Scanner(finkol); // Чтение из файла

            while (src1.hasNext()) {str1 = src1.nextLine(); zz++;}

            finkol.close();
            FileReader fin = new FileReader(route);
            Scanner src = new Scanner(fin); // Чтение из файла

            array = new int[zz];
            data = new double[zz][zz];

            while (src.hasNext()) {
                str = src.nextLine();
                if(str.length()!=0) {
                    array[i1] = Integer.parseInt(str);
                    i1++;}
            }
            fin.close();
            int z = array.length - 1; // Кол-во ошибок
            lobject l1 = new lobject();
            l1.ParamВ = 31.21; // В
            for (int j = 0; j <= z; j++) {
                int m = array[j], num = j+1;
                data[j][0] = num; //Номер ошибки (i)
                data[j][1] = m; //Интервал  между ошибками (Xi, дни)
                data[j][2] = num*m; //i*Xi
                data[j][3] = 1/(num-(l1.ParamВ+1)); //1/B-i+1
                data[j][4] = ((l1.ParamВ-num)+1)*m; //(B-i+1)*Xi
                data[j][5] = 1/num; //1/i

                //Суммирование
                summj1 = summj1 + data[j][1]; //Интервал  между ошибками (Xi, дни)
                summj2 = summj2 + data[j][2]; //i*Xi
                summj3 = summj3 + data[j][3]; //1/B-i+1
                summj4 = summj4 + data[j][4]; //(B-i+1)*Xi
                summj5 = summj5 + data[j][5]; //1/i
                if (m<=5) {
                        summj5_5 = summj5_5 + data[j][5]; //1/i
                    }
                }

            System.out.println("============================================");
            System.out.println("============================================");
            System.out.print(" i|");
            System.out.print("        Xi|");
            System.out.print("      i*Xi|");
            System.out.print("   1/B-i+1|");
            System.out.print(" (B-i+1)*Xi|");
            System.out.print("       1/i|");
            System.out.println();

            for (int i = 0; i <= z; i++) {
                System.out.printf("%2.0f|", data[i][0]);
                for (int j = 1; j <= 5; j++) {
                    double m = data[i][j];
                    System.out.print("        ");
                    System.out.printf("%2.0f|", m);
                    if (z == (j)) {
                    }
                }
                System.out.println();
            }

            l1.EiXi = summj2;//E(i*Xi)
            l1.EXi = summj1;//E(Xi)
            l1.nEXi = z * summj1;//n * E(Xi)
            l1.EBi1Xi = summj4;//E((B-i+1)*Xi)
            l1.Bn = l1.ParamВ - z;//B - n
            l1.B1EXi = (l1.ParamВ + 1)*summj1;//(B+1) * E(Xi)
            l1.Fb1 = summj3;//F(b1)
            l1.Fb2 = l1.nEXi/(l1.B1EXi-l1.EXi);//F(b2)
            l1.Fb1Fb2 = l1.Fb1 - l1.Fb2;//F(b1) - F(b2)
            l1.K = z/l1.EBi1Xi;//K
            l1.Xn1 = 1/(l1.K*(l1.ParamВ - z));//Xn+1
            l1.tk = (1/l1.K)*(summj5_5);//tk

            long stop_time = System.currentTimeMillis();
            long run_time = stop_time - start_time;
            output(l1,run_time);

        }

        catch(IOException e)
        {
            e.printStackTrace();
        }
    }

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
        System.out.println("E((B-i+1)*Xi): "+l1.EBi1Xi);
        System.out.println("B - n: "+l1.Bn);
        System.out.println("(B+1) * E(Xi): "+l1.B1EXi);
        System.out.println("============================================");
        System.out.println("a)");
        System.out.println("F(b1): "+l1.Fb1);
        System.out.println("F(b2): "+l1.Fb2);
        System.out.println("F(b1) - F(b2): "+l1.Fb1Fb2);
        System.out.println("b)");
        System.out.println("K: "+l1.K);
        System.out.println("c)");
        System.out.println("Xn+1: "+l1.Xn1);
        System.out.println("d)");
        System.out.println("tk: "+l1.tk);
        System.out.println("Время выполнения: " + run_time + " сек.");
        System.out.println("============================================");
        System.out.println("============================================");
    }

}