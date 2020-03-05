package SpartezInterview.ArraysIndex;

import interfaces.FindArray;
import java.util.Arrays;
import java.util.stream.IntStream;
/**
 * Created by u0139221 on 2/18/2020.
 */
public class MyFindArray implements FindArray{


    @Override
    public int findArray(int[] array, int[] subArray) {
        int subArrayIdx = -1;

        if(array !=null && subArray !=null && array.length>0 && subArray.length > 0 &&
                subArray.length<array.length) {

            Integer[] subArr = IntStream.of(subArray)
                    .boxed()
                    .toArray(Integer[]::new);
            for (int i = 0; i < (array.length - subArray.length + 1); i++) {
                Integer[] tempArray = IntStream
                        .of(Arrays.copyOfRange(array, i, subArray.length + 1))
                        .boxed()
                        .toArray(Integer[]::new);
                if (Arrays.equals(tempArray, subArr)) {
                    subArrayIdx = i;
                }
            }
        }
        return subArrayIdx;
    }
}

