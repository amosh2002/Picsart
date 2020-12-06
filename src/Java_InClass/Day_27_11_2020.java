package Java_InClass;

import java.util.Arrays;

public class Day_27_11_2020 {
    public static void main(String[] args) {
        int[] arr = {2, 3, 5, 1, 7, 3, 9, 5};
        System.out.println((find2ndSmallest(arr)));
    }

    public static int find2ndSmallest(int[] arr) {
        if(arr.length==1){
            return arr[0];
        }
        int max = arr[0];
        int indexOfMax = 0;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
                indexOfMax = i;
            }
        }
        int secondMax;
        if (indexOfMax != 0) {
            secondMax = arr[0];
        } else {
            secondMax = arr[1];
        }
        for (int i = 0; i < arr.length; i++) {
            if (i == indexOfMax || arr[i] == max) {
                continue;
            }
            if (arr[i] > secondMax) {
                secondMax = arr[i];
            }
        }
        return secondMax;
    }
}
