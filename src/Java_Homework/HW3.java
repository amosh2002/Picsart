package Java_Homework;

import java.util.Arrays;

public class HW3 {

    public static void main(String[] args) {
        // Homework 1
        //1 Create an array and fill it with 2 number
        System.out.println("1. --------");
        int[] arr = new int[10];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = 2;
        }
        System.out.println(Arrays.toString(arr));
        System.out.println("2. --------");
        //2 Create an array and fill it with numbers from 1:1000
        int[] bigArr = new int[1000];
        for (int i = 1; i <= 1000; i++) {
            bigArr[i - 1] = i;
        }
        System.out.println(Arrays.toString(bigArr));
        System.out.println("3. --------");
        //3 Create an array and fill it with odd numbers from -20:20
        int[] oddArr = new int[21];
        int y = 0;
        for (int i = -20; i < 21; i += 2) {
            oddArr[y++] = i;
        }
        System.out.println(Arrays.toString(oddArr));
        System.out.println("4. --------");

        // Homework 2
        //4. Create an array and fill it. Print all elements which can be divided by 5
        int[] divBy5Arr = new int[20];
        for (int i = 0; i < divBy5Arr.length; i++) {
            divBy5Arr[i] = i;
        }
        for (int item : divBy5Arr) {
            if (item % 5 == 0) {
                System.out.print(item + ", ");
            }
        }
        System.out.println();
        System.out.println("5. --------");

        //5. Create an array and fill it. Print all elements which are between 24.12 and 467.23
        double[] numberArray = {2.1, 3.56, 24.15, 39.45, 180.65, 300.67, 467.20, 468.10, 502.91};
        for (int i = 0; i < numberArray.length; i++) {
            if (numberArray[i] < 467.23 && numberArray[i] > 24.12) {
                System.out.print(numberArray[i] + ", ");
            }
        }
        System.out.println();
        System.out.println("6. --------");

        //6. Create an array and fill it. Print count of elements which can be divided by 2
        int[] divBy2 = {1, 2, 3, 4, 5, 7, 8, 12, 14, 6};
        int count = 0;
        for (int item : divBy2) {
            if (item % 2 == 0) {
                count++;
            }
        }
        System.out.println(count);
        System.out.println("7. --------");

        //Homework 3
        int N = 3;
        for (int i = 1; i < 11; i++) {
            System.out.println(N + " x " + i + " = " + N * i);
        }

        System.out.println("X. --------");
        //Find the non-duplicate element in the array, O(n)
        int[] nnarr = {2, 3, 4, 4, 6, 5, 3, 2, 7, 7, 5};
        int someNUmber = nnarr[0];
        for (int i = 1; i < nnarr.length; i++) {
            someNUmber ^= nnarr[i];
        }
        System.out.println(someNUmber);

    }
}
