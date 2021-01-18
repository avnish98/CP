// Find the maximum and minimum element in an array
// Time Complexity: O(n)

import java.util.Arrays;

class MinMaxElement{
    public static void main(String[] args){
        int[] Arr = new int[6];
        Arr[0] = 99;
        Arr[1] = 9;
        Arr[2] = 56;
        Arr[3] = 78;
        Arr[4] = 12;
        Arr[5] = 18;

        int min = Arr[0];
        int max = Arr[0];

        for(int i=0;i<Arr.length;i++){
            if(Arr[i]>max){
                max = Arr[i];
            }
            if(Arr[i]<min){
                min = Arr[i];
            }
        }

        System.out.println("Array: "+Arrays.toString(Arr));
        System.out.println("Greatest Element: "+max);
        System.out.println("Smallest Element: "+min);
    }
}