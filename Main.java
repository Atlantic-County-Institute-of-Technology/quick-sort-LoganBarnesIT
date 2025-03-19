import java.util.Arrays;
import java.util.Random;

public class Main {
    public static int partition(int[] arr, int low, int high){
        //variables for swapping
        int a = low - 1;
        int piv = arr[high];
        
        //goes through array between low high
        for(int x = low; x <= high-1; x++){
            //flips to put them into the order
            if(arr[x] < piv){
                a++;
                swap(arr, a, x);
            }
        }
        //swaps the pivot
        swap(arr, a + 1, high);
        return a+1;
    }
    public static void swap(int arr[], int i, int j){
        //uses a placeholder to swap to positions
        int placeholder = arr[i];
        arr[i] = arr[j];
        arr[j] = placeholder;
    }
    public static void quickSort(int arr[], int low, int high){
        //checks if the low is less than the high
        if(low < high){
            //gets pivot and runs on both sides of pibot
            int pivot = partition(arr, low, high);
            quickSort(arr, low, pivot - 1);
            quickSort(arr, pivot + 1, high);
        }
    }
    public static void main(String[] args){
        int[] arr = new int[10];
        
        //makes random numbers
        Random random = new Random();
        for(int i = 0; i<arr.length; i++){
            arr[i] = random.nextInt(1, 100);
        }
        
        //shows original
        System.out.println("random array");
        for(int i : arr){ System.out.print(i + " "); }
        System.out.println("");
        
        //sorts array
        quickSort(arr, 0, arr.length - 1);
        
        
        //shows sorted
        System.out.println("sorted array");
        for(int i : arr){ System.out.print(i + " "); }
    }
}
