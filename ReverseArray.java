// Reverse an Array
// Time Complexity: O(n)

import java.util.Arrays;

class ReverseArray{
    public static void main(String[] args){
        int[] Arr = new int[6];
        Arr[0] = 99;
        Arr[1] = 9;
        Arr[2] = 56;
        Arr[3] = 78;
        Arr[4] = 12;
        Arr[5] = 18;

        int[] reverseArr = new int[Arr.length];
        int j = 0;

        for(int i=(Arr.length-1);i>(-1);i--){
            reverseArr[j] = Arr[i];
            j++;
        }

        System.out.println("Original Array: "+Arrays.toString(Arr));
        System.out.println("Reverse Array: "+Arrays.toString(reverseArr));
    }
}