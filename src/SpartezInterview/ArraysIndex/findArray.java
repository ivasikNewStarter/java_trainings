package SpartezInterview.ArraysIndex;

/**
 * Created by u0139221 on 2/18/2020.
 */
public class findArray {
    private static int[] array1 = {4,9,3,7,8};
    private static int[] subArray1 = {3,7};
    private static int[] array2 = {7,8,9,10};
    private static int[] subArray2 = {7,8,9};
    private static  int[] array3 = {4,9,3,7,8,3,7,1};
    private static  int[] subArray3 = {3,7};

    public static void main(String[] args) {

        System.out.println(findArray(array1, subArray1));
        System.out.println(findArray(array2, subArray2));
        System.out.println(findArray(array3, subArray3));

    }
    static int findArray(int [] array,int []subArray){
        int index= -1;
        next :
        for (int i = 0; i <array.length ; i++) {
            if (array[i] == subArray[0]){
                for (int j = 1; j <subArray.length ; j++) {
                    if(i+j> array.length-1 || array[i+j] !=subArray[j])
                      continue next;
                }
                index = i;
            }
        }
        return index;
    }
}


