package Array;

import java.util.*;

public class SortArray {


    /**
     * Time Limit
     * @param nums
     * @return
     */
    public static int[] sortArray(int[] nums) {

            int results = 0;
            for (int i = 0; i < nums.length; i++){
                for (int j = 1+i; j< nums.length; j++){
                    if(nums[i] > nums[j]){
                        results  = nums[i];
                        nums[i] = nums[j];
                        nums[j] = results;

                    }
                }
            }
            return nums;
        }



        public static void main(String[] args){

            int[] arrs = {5,3,2,1};

            sortArray(arrs);
            for (int arr : arrs){
                System.out.println(arr);
            }
        }

}
