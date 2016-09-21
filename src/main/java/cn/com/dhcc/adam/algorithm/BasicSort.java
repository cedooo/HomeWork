package cn.com.dhcc.adam.algorithm;

import org.apache.log4j.Logger;
import org.junit.Test;


/**
 * Created by cedo on 2016/9/21.
 * 基础的排序算法实现
 */
public class BasicSort {

    static private Logger log = Logger.getLogger(BasicSort.class);

    private static int[] arr;
    static{
        java.util.Random random = new java.util.Random();
        int arrNums = random.nextInt(1<<5);
        arr = new int[arrNums];
        for (int i = 0; i < arrNums; i++) {
            arr[i] = random.nextInt(Integer.MAX_VALUE);
        }
        log.info(java.util.Arrays.toString(arr));
    }
    @Test
    public final void bubbleSort(){
        int [] sortedArr = java.util.Arrays.copyOf(arr, arr.length);
        int loopCounter = 0;
        for(int i=0;i<sortedArr.length-1;i++){
            boolean changed = false;
            for(int j=sortedArr.length-1;j>i;j--){
                if(sortedArr[j]<sortedArr[j-1]){
                    int changeVal = sortedArr[j-1];
                    sortedArr[j-1] = sortedArr[j];
                    sortedArr[j]=changeVal;
                    changed = true;
                }
                loopCounter++;
            }
            if(!changed) break;
        }
        log.info(java.util.Arrays.toString(sortedArr));
        log.info("array length = " + sortedArr.length + ", loop counter = " + loopCounter);
    }
}
