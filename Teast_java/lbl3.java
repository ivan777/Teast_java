
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.lang.*;

import static java.lang.Math.*;

public class lbl3 {

    public static void main(String[] args) throws FileNotFoundException, CloneNotSupportedException
    {   long start_time = System.currentTimeMillis();
//       String route = "C:\\Users\\privalovie\\YandexDisk\\Универ\\Конструирование\\labs\\lbl3.txt", str, str1, docsx;
//         Graph Gor Graph12
        //String route = "F:\\YandexDisk\\Универ\\Конструирование\\labs\\lbl3.txt", str, str1, docsx;
        int zz,i11 = 0, i1 = 0, A = 20,B = 30,C = 10,D = 3, m = 30, v = 15, r0 = 1000,arrayV = 0;
        double lamda = 1.53, R_1 = 0.0, R_2 = 0.0, R_3 = 0.0, CAR_1 = 0.0, CAR_2 = 0.0, CAR_3 = 0.0; //уровень языка программирования ////λ
        int[][] array;
        //double[][] data;
        System.out.println("Введите значения переменных: ");
        Scanner inA = new Scanner(System.in);
        System.out.print("A: ");
        A = inA.nextInt();
        Scanner inB = new Scanner(System.in);
        System.out.print("B: ");
        B = inB.nextInt();
        Scanner inC = new Scanner(System.in);
        System.out.print("C: ");
        C = inC.nextInt();
        Scanner inD = new Scanner(System.in);
        System.out.print("D: ");
        D = inD.nextInt();

        lobject l1 = new lobject();
        //data = new double[zz+1][9];
        //Первая задача
        l1.n2_1 = (A*B*C)+(D*A);//n2
        l1.V_1 = (l1.n2_1+2)*((log(l1.n2_1+2))/log(2));//V

        l1.B_1 = pow(l1.V_1,2)/(3000*l1.lamda);//B

        //Вторая задача
        l1.k_2 = l1.n2_1/8;//k
        l1.i_2 = (((log(l1.n2_1))/log(2))/3)+1;//i
        l1.m_2 = m;//m
        l1.v_2 = v;//v
        l1.K_2 = (l1.n2_1/8)+(l1.n2_1/pow(8,2));//K
        l1.N_2 = (220*l1.K_2)+(l1.K_2*(log(l1.K_2)/log(2)));//N
        l1.V_2 = (220*l1.K_2*(log(48)/log(2)));//V
        l1.P_2 = (3*l1.N_2)/8;//P
        l1.TK_2 = (3*l1.N_2)/(8*l1.m_2*l1.v_2);//Tk
        l1.B_2 = l1.V_2/3000;//B
        l1.TN_2 = l1.TK_2/(2*(log(l1.B_2)));//tn

        //Третья задача
        //B, V
        int [][] bv = new int[5][2];
        //r0 = 1000
        l1.lamda = lamda;
        bv[0][0] = 0;
        bv[1][0] = 2;
        bv[2][0] = 5;
        bv[3][0] = 4;
        bv[4][0] = 0;

        bv[0][1] = 5;
        bv[1][1] = 7;
        bv[2][1] = 9;
        bv[3][1] = 11;
        bv[4][1] = 0;

        double[][] data = new double [6][4];
        int sumB = 0;
        int sumV = 0;
        double sumF = 0;
        /**
         * Нулевой столбец - R
         * Первый столбец - B
         * Второй столбец - V
         * Третий столбец - формула
         */

        //C(λ,R) = 1/λ+1/R
        System.out.println("" +" " + "R" + " " + "B" + " " + "V" + " " + "C(λ,R)");
        for (int i = 0; i<=5;i++){
            if (i==0){
                data[i][0] = r0;
                data[i][1] = 0;
                data[i][2] = 0;
                data[i][3] = 0;
            }
            else {
                double tr = data[i-1][0];
                int tb = bv[i-1][0];
                int tv = bv[i-1][1];
                double f = tb / ((1/lamda) + (1 / tr));
                data[i][1] = tb;
                data[i][2] = tv;
                sumB = sumB + tb;
                sumV = sumV + tv;
                sumF = sumF + f;
                double r = tr * (1+(1 * 0.001) * (sumV - sumF));
                data[i][0] = r;
            }
            String srNumber = String.valueOf(i);
            String srValue = String.format("%.3f",data[i][0]);
            System.out.println("r"+String.valueOf(i) +": " + data[i][0] + " " + data[i][1] + " " + data[i][2] + " " + data[i][3]);
        }
    }

    public static class lobject implements Cloneable
    {double lamda, n2_1, V_1, B_1, k_2, i_2, K_2, N_2, V_2, P_2, TK_2, B_2, TN_2, m_2, v_2;
        double[][] data;}

    public static void output(lobject l1,int zz, long run_time)
    {
        System.out.println("============================================");
        System.out.println("============================================");
        System.out.println("Первая задача");
        System.out.println("============================================");
        System.out.printf("n2: %2.2f",l1.n2_1);
        System.out.println();
        System.out.printf("V: %2.2f",l1.V_1);
        System.out.println();
        System.out.printf("λ: %2.2f",l1.lamda);
        System.out.println();
        System.out.printf("B: %2.2f",l1.B_1);
        System.out.println();
        System.out.println("============================================");
        System.out.println("Вторая задача");
        System.out.println("============================================");
        System.out.printf("k: %2.2f",l1.k_2);
        System.out.println();
        System.out.printf("m: %2.2f",l1.m_2);
        System.out.println();
        System.out.printf("i: %2.2f",l1.i_2);
        System.out.println();
        System.out.printf("v: %2.2f",l1.v_2);
        System.out.println();
        System.out.printf("K: %2.2f",l1.K_2);
        System.out.println();
        System.out.printf("N: %2.2f",l1.N_2);
        System.out.println();
        System.out.printf("V: %2.2f",l1.V_2);
        System.out.println();
        System.out.printf("P: %2.2f",l1.P_2);
        System.out.println();
        System.out.printf("Tk: %2.2f",l1.TK_2);
        System.out.println();
        System.out.printf("B: %2.2f",l1.B_2);
        System.out.println();
        System.out.printf("Tn: %2.2f",l1.TN_2);
        System.out.println();

        System.out.println("============================================");
        System.out.println("Третья задача");
        System.out.println("============================================");
        System.out.println("C(λ,R) = 1/λ+1/R");
        System.out.println("============================================");
        System.out.print(" ri|");
        System.out.print("          R|");
        System.out.print("       B|");
        System.out.print("       V|");
        System.out.print("  C(λ,R)|");
        System.out.println();

        for (int i = 0; i <= zz; i++) {
            System.out.printf("r%2.0f|", l1.data[i][0]);
            System.out.print("    ");
            System.out.printf("%2.2f|", l1.data[i][3]);//R
            System.out.print("    ");
            System.out.printf("%2.2f|", l1.data[i][1]);//B
            System.out.print("    ");
            System.out.printf("%2.2f|", l1.data[i][2]);//V
            System.out.print("    ");
            System.out.printf("%2.4f|", l1.data[i][6]);//C(λ,R)
            System.out.println();
        }
        System.out.println("============================================");


        System.out.println("============================================");
        System.out.println("C(λ,R) = 1/(λ*R)");
        System.out.println("============================================");
        System.out.print(" ri|");
        System.out.print("          R|");
        System.out.print("       B|");
        System.out.print("       V|");
        System.out.print("  C(λ,R)|");
        System.out.println();

        for (int i = 0; i <= zz; i++) {
            System.out.printf("r%2.0f|", l1.data[i][0]);
            System.out.print("    ");
            System.out.printf("%2.2f|", l1.data[i][4]);//R
            System.out.print("    ");
            System.out.printf("%2.2f|", l1.data[i][1]);//B
            System.out.print("    ");
            System.out.printf("%2.2f|", l1.data[i][2]);//V
            System.out.print("    ");
            System.out.printf("%2.2f|", l1.data[i][7]);//C(λ,R)
            System.out.println();
        }
        System.out.println("============================================");


        System.out.println("============================================");
        System.out.println("C(λ,R) = 1/(λ+R)");
        System.out.println("============================================");
        System.out.print(" ri|");
        System.out.print("          R|");
        System.out.print("       B|");
        System.out.print("       V|");
        System.out.print("  C(λ,R)|");
        System.out.println();

        for (int i = 0; i <= zz; i++) {
            System.out.printf("r%2.0f|", l1.data[i][0]);
            System.out.print("    ");
            System.out.printf("%2.2f|", l1.data[i][5]);//R
            System.out.print("    ");
            System.out.printf("%2.2f|", l1.data[i][1]);//B
            System.out.print("    ");
            System.out.printf("%2.2f|", l1.data[i][2]);//V
            System.out.print("    ");
            System.out.printf("%2.2f|", l1.data[i][8]);//C(λ,R)
            System.out.println();
        }
        System.out.println("============================================");

        System.out.println("Время выполнения: " + run_time + " сек.");
        System.out.println("============================================");
        System.out.println("============================================");
    }

}