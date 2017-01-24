package hello;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;


/**
 * Created by Пользователь on 13.09.2016.
 */

public class WithoutNGrammy {

    public static String[] read(String fileName) throws FileNotFoundException {
        List<String> list = new ArrayList<String>();
        Scanner in = new Scanner(new File(fileName));
        while (in.hasNextLine())
            list.add(in.nextLine());
        String[] array = list.toArray(new String[0]);
        return array;
    };

    public static int distance(String S1, String S2){
        int m = S1.length(), n = S2.length();
        int[] D1;
        int[] D2 = new int[n + 1];

        for (int i = 0; i <= n; i++)
            D2[i] = i;

        for (int i = 1; i <= m; i++) {
            D1 = D2;
            D2 = new int[n + 1];
            for (int j = 0; j <= n; j++) {
                if (j == 0) D2[j] = i;
                else {
                    int cost = (S1.charAt(i - 1) != S2.charAt(j - 1)) ? 1 : 0;
                    if (D2[j - 1] < D1[j] && D2[j - 1] < D1[j - 1] + cost)
                        D2[j] = D2[j - 1] + 1;
                    else if (D1[j] < D1[j - 1] + cost)
                        D2[j] = D1[j] + 1;
                    else
                        D2[j] = D1[j - 1] + cost;
                }
            }
        }
        return D2[n];
    }


    public static ArrayList<String> editdist(String S1, List<String> S) {
        ArrayList<String> MoreRightWords = new ArrayList<String>();
        HashMap<Integer, ArrayList<String>> Map = new HashMap<Integer, ArrayList<String>>();
        for (int p = 0; p < S.size(); p++) {
            String S2 = S.get(p);
            int m = S1.length(), n = S2.length();
            int[] D1;
            int[] D2 = new int[n + 1];

            for (int i = 0; i <= n; i++)
                D2[i] = i;

            for (int i = 1; i <= m; i++) {
                D1 = D2;
                D2 = new int[n + 1];
                for (int j = 0; j <= n; j++) {
                    if (j == 0) D2[j] = i;
                    else {
                        int cost = (S1.charAt(i - 1) != S2.charAt(j - 1)) ? 1 : 0;
                        if (D2[j - 1] < D1[j] && D2[j - 1] < D1[j - 1] + cost)
                            D2[j] = D2[j - 1] + 1;
                        else if (D1[j] < D1[j - 1] + cost)
                            D2[j] = D1[j] + 1;
                        else
                            D2[j] = D1[j - 1] + cost;
                    }
                }
            }
            if (Map.containsKey(D2[n]))
                Map.get(D2[n]).add(S2);
            else {
                ArrayList<String> tmp = new ArrayList<String>();
                tmp.add(S2);
                Map.put(D2[n],tmp);
            }

        }
        int min_way = 100;
        for (int k:Map.keySet()){
            if (k<min_way) min_way = k;
        }

        return Map.get(min_way);
    }


    public static void main(String[] arg) throws FileNotFoundException {
        long time = System.currentTimeMillis();

        Scanner in = new Scanner(System.in);
        System.out.println("Введите слово: ");
        String n = in.nextLine();

        String[] file_list = read("words.txt");

        //System.out.println(editdist(n,file_list));
        System.out.println("time : " + (System.currentTimeMillis() - time)/1000D + " sec");
    }
}
