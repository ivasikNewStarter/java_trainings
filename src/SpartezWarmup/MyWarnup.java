package SpartezWarmup;

import java.util.Arrays;
import java.util.Collection;
import java.util.stream.IntStream;

/**
 * Created by u0139221 on 2/20/2020.
 */
public class MyWarnup implements Warmup {
    private static int [] array1 = {11,2,3,4,5,6, -1};

    @Override
    public int findMax(int[] array) {
          int maxIndex =-1;
        if (array != null && array.length>0) {
            maxIndex = IntStream.range(0,array.length)
                    .reduce((i,j)-> array [i]>=array[j]?i:j)
                    .getAsInt();
        }


        return maxIndex;
    }
    public static Collection<Object[]> paramData() {
        return Arrays.asList(new Object[][] {
                {null, -1},
                {new int[] {}, -1},
                {new int[] {1, 2, 3, 0, -1}, 2},
                {new int[] {1, 2, 2, 1}, 1},
                {new int[] {1, 2, 3, 2, 3, 2, 1, 3}, 2}
        });
    }

    public static void main(String[] args) {
        MyWarnup mw = new MyWarnup();
        mw.findMax(array1);
        System.out.println(mw.findMax(array1));
    }

}
