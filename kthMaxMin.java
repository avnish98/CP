// Find the kth maximum and minimum element in an array

// My solution
// Time Complexity: O(n*k)

// import java.util.Arrays;

// class kthMaxMin{

//     public static int[] arrayRemove(int[] arr, int x){
//         for(int i=0;i<arr.length;i++){
//             if(arr[i]==x){
//                 while(i+1<arr.length){
//                     arr[i] = arr[i+1];
//                     i++;
//                 }
//             }
//         }
//         arr[arr.length-1] = (-1);
//         return arr;
//     }

//     public static void main(String[] args){
//         int[] Arr = new int[6];
//         Arr[0] = 99;
//         Arr[1] = 9;
//         Arr[2] = 56;
//         Arr[3] = 78;
//         Arr[4] = 12;
//         Arr[5] = 18;

//         int k = 3;
//         int min = Arr[0];
//         int max = Arr[0];
//         int j = 0;

//         int[] originalArr = Arr.clone();

//         while(j!=k){
//             min = Arr[0];
//             max = Arr[0];
//             for(int i=0;i<Arr.length;i++){
//                 if(Arr[i]!=(-1) && Arr[i]>max){
//                     max = Arr[i];
//                 }
//                 if(Arr[i]!=(-1) && Arr[i]<min){
//                     min = Arr[i];
//                 }
//             }
//             Arr = arrayRemove(Arr, max);
//             Arr = arrayRemove(Arr, min);
//             j++;
//         }

//         System.out.println("Array: "+Arrays.toString(originalArr));
//         System.out.println(k+"th Greatest Element: "+max);
//         System.out.println(k+"th Smallest Element: "+min);
//     }
// }

// Optimal Solution: apply quicksort until pivot element is kth smallest/largest element
// Time Complexity: O(nlogn)

import java.util.Arrays;

public class kthMaxMin {

    public static void Swap(int[] A, int id1, int id2){
        int temp = A[id1];
        A[id1] = A[id2];
        A[id2] = temp;
    }

    public static int Partition(int[] A, int left, int right){
        // Returns pivot index 

        int pivot = A[right];
        int i = left; // Last position of smaller element pointer
        for(int j=left;j<=right-1;j++){ // j is loop pointer
            if(A[j]<=pivot){
                Swap(A, i, j); // Put that element in the new position
                i++;
            }
        }
        Swap(A, i, right); // Put pivot where it belongs i.e. middle
        return (i); // Location of pivot
    }

    public static int QuickSortModified(int[] A, int left, int right, int k){
        // Returns kth smallest element
        
        if(k>0 && k<=right-left+1){ // k is within bounds of the array
                int pivot = Partition(A, left, right);
                if(pivot - left == k-1){ // If number of elements in left subarray is equal to k
                    return A[pivot];     // then return pivot as it is kth smallest element
                }
                if(pivot-left > k-1){ // If size of left subarray is greater than k
                    return QuickSortModified(A, left, pivot-1, k); // Search in left subarray more
                }
                return QuickSortModified(A, pivot+1, right, k-pivot+left-1); // Else Search in right subarray
                                                                             // k-pivot because right subarray is shifted by value = pivot?
        }
        return (-1);
    }

    public static void main(String[] args) {
        int[] Arr = new int[10];
        Arr[0] = 99;
        Arr[1] = 9;
        Arr[2] = 56;
        Arr[3] = 78;
        Arr[4] = 12;
        Arr[5] = 18;
        Arr[6] = 76;
        Arr[7] = 19;
        Arr[8] = 12;
        Arr[9] = 5;
        System.out.println("Array: "+Arrays.toString(Arr));
        int k =5;
        int min = QuickSortModified(Arr, 0, Arr.length-1, k);
        System.out.println(k+"th Smallest Element: "+min);
    }
}
