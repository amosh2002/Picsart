package Java_InClass;

import java.util.Arrays;

public class Day_03_11_2020 {

    public static void main(String[] args) {
        /*
        int x = 3452543;
        int xx = x;
        int newX = 0;
        while (xx != 0) {
            newX = newX * 10 + (xx % 10);
            xx = xx / 10;
        }
        System.out.println(newX == x);

         */

        int row = 3;
        for (int i = 1; i <= row; i++) {
            for (int j = row; j >= i; j--) {
                System.out.print("*");
            }
            System.out.println();
        }

        int[] arr = {};
        int n = 0;
        for (int i = -14; i <= 30; i += 2) {
            n++;
        }
        arr = new int[n];
        int k = 0;

        for (int i = -14; i <= 30; i += 2) {
            arr[k++] = i;
        }
        System.out.println(Arrays.toString(arr));
        int[] revArr = new int[arr.length];
        for (int i = 0; i < revArr.length; i++) {
            int xx = arr[i];
            int newX = 0;
            while (xx != 0) {
                newX = newX * 10 + (xx % 10);
                xx = xx / 10;
            }
            revArr[i] = newX;
        }
        System.out.println(Arrays.toString(revArr));

        int[] nnarr = {2, 3, 4, 4, 6, 5, 3, 2, 7, 7, 5};
        int kk = 0;
        for (int i = 0; i < nnarr.length; i++) {
            int f = nnarr[i];
            for (int j = 0; j < nnarr.length; j++) {
                int ff = nnarr[j];
                if (f == ff) {
                    kk++;
                }
            }
            if (kk != 2) {
                System.out.println(nnarr[i]);
            }
            kk = 0;
        }

        int someNUmber = nnarr[0];
        for (int i = 1; i < nnarr.length; i++) {
            someNUmber ^= nnarr[i];
        }
        System.out.println(someNUmber);


    }
}
