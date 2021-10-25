package Easy;
import java.util.*;

/**
 * Question:
 * Given an array of integers nums and an integer target,
 * return indices of the two numbers such that they add up to target.
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 * You can return the answer in any order.
 * ************************************************************************************************************
 * Sample Output:
 * Input: nums = [2,7,11,15], target = 9
 * Output: [0,1]
 * Output: Because nums[0] + nums[1] == 9, we return [0, 1]
 *
 * ************************************************************************************************************
 *
 * Assumption and Constraints
 * 1)    What is the length of “num” Array ?
 * 2)    What is the maximum number of Integer(each elements of “num”) can be stored in Array?
 * 3)    What is the maximum number of target?
 * 4)    Is there any space limitation?
 * 5)    Can I use same element twice?
 *
 * ************************************************************************************************************
 * Trade off way 1 and way 2
 * way 2 can reduce more time depends on increasing arrays size. However, we need more extra space to store Map data.
 *
 *
 */
public class twoSum {

    /**
     * Way 1 : Brute Force
     * @param nums
     * @param target
     * @return
     * ************************************************************************************************************
     * Time Complexity : O(n^2). For each element, we try to find its complement by looping through the rest of
     *                  array which takes O(n)O(n)O(n) time. Therefore, the time complexity is O(n^2)
     * Space complexity : O(1)
     */
    public static int[] twoSum1(int[] nums, int target) {
        for (int i=0; i<nums.length; i++){  //N
            for (int j=i+1; j<nums.length;j++){ //N
                if (nums[j] == target -nums[i] ){
                    return new int[] {i,j};
                }
            }
        }
        throw new IllegalArgumentException("No two Sum solutino");
    }
    /**
     * Way 2 : Hash Map
     * @param nums
     * @param target
     * @return
     * ************************************************************************************************************
     * Time Complexity : O(n). Traverse the list containing n elements exactly twice. Since the hash table reduces
     * the look up time to O(1)
     * Space complexity : O(n). The extra space required depends on the number of items stored in the hash table,
     * which stores exactly n elements
     */
    public static int[] twoSum2(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();

        /**
         * first iteration, we add each element's value and its index to table
         */
        for (int i=0; i<nums.length; i++){
            map.put(i, nums[i]);
        }

        /**
         * second iteration, we check if each element's complement target-nums[i] exists in the table.
         */
        for (int i=0; i<nums.length; i++){  //O(N) - two pointer algorithm, sum -> two pointers
            int complement = target -nums[i];
            if (map.containsKey(complement) && map.get(complement) != i){
                return new int[] {i, map.get(complement)};
            }
        }

        return new int[] {-1,-1};
        //throw new IllegalArgumentException("No two Sum solutino");
    }







    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int[] test = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int target = sc.nextInt();
        //int[] result1 = twoSum1(test,target);
        int[] result2 = twoSum2(test,target);
        for (int i = 0; i <result2.length; i++){
            System.out.print(result2[i]+" ");
        }
    }
}
