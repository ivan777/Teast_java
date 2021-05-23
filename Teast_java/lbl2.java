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
//       String route = "C:\\Users\\privalovie\\YandexDisk\java\Java_Информатика\Курсовые\Graph6.txt", docsx, str, str1,u, ii;
//         Graph Gor Graph12
        String route = "F:\\YandexDisk\\java\\Java_Информатика\\Курсовые\\Graph6.txt", docsx, str, str1,u, ii;
        int zz,NUMBER_CITIES = 0,i11 = 0,i1 = 0,q = 0;
        double m;

        int[][] array;

        try
        {
            FileReader finkol = new FileReader(route);
            Scanner src1 = new Scanner(finkol); // Чтение из файла

            while (src1.hasNext()) {
                str1 = src1.nextLine();
                i11++;}

            finkol.close();
            FileReader fin = new FileReader(route);
            Scanner src = new Scanner(fin); // Чтение из файла

            zz = i11;
            NUMBER_CITIES = zz;
            array = new int[zz][zz];

            while (src.hasNext()) {
                if(i1!=zz) {
                    int i2 = 0;
                    str = src.nextLine();
                    if(str.length()!=0) {
                        StringTokenizer st = new StringTokenizer(str, "_");
                        while (st.hasMoreTokens()) {
                            docsx = st.nextToken();
                            array[i1][i2] = Integer.parseInt(docsx);
                            i2++;}
                        i1++;}
                } else {break;}
            }

            fin.close();
            if (provverkatxt(array)) {
                System.out.println("Файл сформирован верно!!!");

                int z = array.length - 1;

                System.out.println("============================================");
                System.out.println("============================================");
                System.out.print("  |");
                while (q <= z) {
                    q++;
                    u = texet(q);
                    System.out.print(" " + u + "|");
                }
                System.out.println();

                for (int i = 0; i <= z; i++) {
                    ii = texet(i + 1);
                    System.out.printf(" " + ii + "|");
                    for (int j = 0; j <= z; j++) {
                        m = array[i][j];
                        System.out.printf("%2.0f|", m);
                        if (z == (j)) {
                        }
                    }
                    System.out.println();
                }

                int[][] maintemp;
                int x = 0;
//                x = reduce1(array, x, 9999, 9999);
                maintemp = reduce(array, x, 9999, 9999);
                lobject l1 = new lobject(NUMBER_CITIES);

                int dl = 0, m1 = 0;
                String ct = "";

                for (int i = 0; i <= z; i++) {
                    for (int j = 0; j <= z; j++) {
                        if (maintemp[i][j] == 0) {
                            continue;
                        } else {
                            m1 = maintemp[i][j];
                            dl = dl + m1;
                            if (ct == "") {
                                ct = texet(1) + " --> " + texet(i + 1);
                            } else {
                                ct = ct + " --> " + texet(i + 1);
                            }
                        }
                    }
                }

                l1.city = ct;
                l1.cost = dl;

                long stop_time = System.currentTimeMillis();
                long run_time = stop_time - start_time;

                output(l1,run_time);
            }
            else
            {
                System.out.println("Файл сформирован не верно!!!");
            }
        }

        catch(IOException e)
        {
            e.printStackTrace();
        }
    }

    public static int minimum(int min, int zn)
    {
        if((zn < min)&&(zn>0))
        {
            min = zn;

            if (min == 9999)
            {
                return 0;
            }
            else
            {
                return min;
            }
        }
        else if ((zn == min)&&(zn>0)) {return min;}
        else {return 0;}
    }

    public static class lobject implements Cloneable
    {
        String city;
        int cost;
        int[][] matrix ;
        lobject(int number)
        {
            matrix = new int[number][number];
        }
    }

    public static void output(lobject l1, long run_time)
    {
        System.out.println("============================================");
        System.out.println("============================================");
        System.out.println("Путь коммивояжера: "+l1.city);
        System.out.println("Стоимость пути коммивояжера в одну сторону: "+l1.cost);
        System.out.println("Стоимость пути коммивояжера в обе стороны: "+(l1.cost*2));
        System.out.println("Время выполнения: " + run_time + " сек.");
        System.out.println("============================================");
        System.out.println("============================================");
    }

    public static int[][] reduce(int[][] array, int cost, int row, int column)
    {
        int[][] matrix = new int[array.length][array.length];
        int x=0,y=0,zn=0, min = 9999,i00=0;
        int[] array_to_reduce = new int[array.length];
        String[] Names = new String[array.length];
        for(int i=0; i<array.length; i++)
        {array_to_reduce[i] = minimummin(i,array);}
        int new_cost = cost;
        for(int i=0; i<array.length; i++)
        {
            if(i == row) continue;
            for(int j=0; j<array.length; j++) {
                if (array[i][j] == 0 && j<=i) {
                    continue;
                } else {
                    int cnst = array_to_reduce[i];
                    cnst = cnst != 0 ? cnst : min;
                    x = j;
                    y = i;
                    if(j>i) {
                        zn = array[i][j];
                        int minin = minimum(cnst, zn);
                        if (minin != 0) {
                            int index = Arrays.asList(Names).indexOf(String.valueOf(x) + "_" + String.valueOf(y));
                            if (provverkachikla(index, Names.length)) {
                                new_cost = minin + new_cost;
                                Names[i00] = String.valueOf(x) + "_" + String.valueOf(y);
                                i = x;
                                j = y + 1;
                                matrix[x][y] = minin;
                                i00++;
                            }
                        }
                    }
                }
            }
        }

        return matrix;
    }

    public static int minimummin(int i, int [][] array)
    {   int[] array_to_reduce = new int[array.length];
        for(int j=0;j<array.length;j++)
        {if (j>i)
        {array_to_reduce[j] = array[j][i];}
        }

        int min = 9999;
        for(int in=0; in < array_to_reduce.length; in++)
        {
            if (i == (array.length - 2)) {
                if (array_to_reduce[i + 1] < min && (array_to_reduce[i + 1] > 0)) {
                    min = array_to_reduce[i + 1];
                }
            } else if (i == (array.length - 1)) {
                min = 0;
            } else {

                if (array_to_reduce[in] < min && (array_to_reduce[in] > 0)) {
                    min = array_to_reduce[in];
                }
            }
        }

        if (min == 9999)
        {return 0;}
        else
        {return min;}}

    public static String texet (int cost)
    {
        if(cost == 1)
        {return "A";}
        else if(cost == 2)
        {return "B";}
        else if(cost == 3)
        {return "C";}
        else if(cost == 4)
        {return "D";}
        else if(cost == 5)
        {return "E";}
        else if(cost == 6)
        {return "F";}
        else if(cost == 7)
        {return "J";}
        else if(cost == 8)
        {return "K";}
        else if(cost == 9)
        {return "K";}
        else if(cost == 10)
        {return "L";}
        else if(cost == 11)
        {return "M";}
        else if(cost == 12)
        {return "N";}
        else if(cost == 13)
        {return "O";}
        else if(cost == 14)
        {return "P";}
        else if(cost == 15)
        {return "Q";}
        else if(cost == 16)
        {return "R";}
        else if(cost == 17)
        {return "S";}
        else if(cost == 18)
        {return "T";}
        else if(cost == 19)
        {return "U";}
        else if(cost == 20)
        {return "V";}
        else if(cost == 21)
        {return "W";}
        else if(cost == 22)
        {return "X";}
        else if(cost == 23)
        {return "Y";}
        else if(cost == 24)
        {return "Z";}
        else
            return "";
    }

    public static boolean provverkatxt (int [][] array)
    {
        int z = array.length-1,m=0;
        boolean tt = true;
        for (int i=0; i <= z; i++){
            for (int j=0; j <= z; j++) {
                if(array[i][j] != array[j][i])
                {tt = false;}
            }

        }
        return tt;
    }

    public static boolean provverkachikla (int tt1, int array)
    {   boolean tt = false;
        if(tt1 == -1){tt = true;}
        return tt;}


//    public static int reduce1(int[][] array, int cost, int row, int column)
//    {
//        int x,y,zn, min = 9999,i00=0;
//        int[] array_to_reduce = new int[array.length];
//        String[] Names = new String[array.length];
//        for(int i=0; i<array.length; i++)
//        {array_to_reduce[i] = minimummin(i,array);}
//        int new_cost = cost;
//        for(int i=0; i<array.length; i++)
//        {
//            if(i == row) continue;
//            for(int j=0; j<array.length; j++)
//            {if(array[i][j] == 0 && j<=i) {continue;}
//            else {
//                int cnst = array_to_reduce[i];
//                cnst = cnst != 0 ? cnst : min;
//                x = j;
//                y = i;
//                if(j>i) {
//                zn = array[i][j];
//                int minin = minimum(cnst, zn);
//                if (minin != 0) {
//                    int index = Arrays.asList(Names).indexOf(String.valueOf(x) + "_" + String.valueOf(y));
//                    if (provverkachikla(index, Names.length)) {
//                        System.out.println(String.valueOf(y) + " / " + String.valueOf(x));
//                        new_cost = minin + new_cost;
//                        Names[i00] = String.valueOf(x) + "_" + String.valueOf(y);
//                        i = x;
//                        j = y + 1;
//                        i00++;
//                    }
//                }
//            }
//            }
//            }
//        }
//
//        return new_cost;
//    }
}