import java.util.*;

public class Test1 {
    public static void main(String[] args){
        String input2 = "CBADEGFGGGGGG";
        char[] arr_char2=input2.toCharArray();
        quickSort(arr_char2);
        System.out.println("result"+Arrays.toString(arr_char2));
    }
    public static void quickSort(char[] arr){
        shuffle(arr);
        merge(arr,0,arr.length-1);
    }
    public static void merge(char[] arr,int lo,int hi){
        if(hi<=lo) return;
        int j =partition(arr,lo,hi);
        merge(arr,lo,j-1);
        merge(arr,j+1,hi);
    }
    public static int partition(char[] arr,int lo,int hi){
        int i =lo,j=hi+1;
        char v = arr[lo];
        while(true){
            while(less(arr[++i],v)){
                if(i==hi){
                    break;
                }
            }
            while(less(v,arr[--j])){
                if(j==lo){
                    break;
                }
            }
            if(i>=j) break;
            exch(arr,i,j);
        }
        exch(arr,lo,j);
        return j;
    }
    public static void shuffle(char[] array) {
        Random rand = new Random();

        for (int i = 0; i < array.length; i++) {
            int randomIndexToSwap = rand.nextInt(array.length);
            char temp = array[randomIndexToSwap];
            array[randomIndexToSwap] = array[i];
            array[i] = temp;
        }
    }
    public static void exch(char[] arr,int lo,int hi){
        char temp = arr[lo];
        arr[lo] = arr[hi];
        arr[hi]=temp;
    }
    public static boolean less(char a,char b){
        return a<b;
    }
}



