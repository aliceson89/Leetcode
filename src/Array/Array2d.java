package Array;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;

/**
 * Question
 * You are assigned to put some amount of boxes onto one truck. You are given a 2D array boxTypes, where boxTypes[i] = [numberOfBoxesi, numberOfUnitsPerBoxi]:
 *
 *     numberOfBoxesi is the number of boxes of type i.
 *     numberOfUnitsPerBoxi is the number of units in each box of the type i.
 *
 * You are also given an integer truckSize, which is the maximum number of boxes that can be put on the truck. You can choose any boxes to put on the truck as long as the number of boxes does not exceed truckSize.
 *
 * Return the maximum total number of units that can be put on the truck.
 *
 * Example 1:
 * Input: boxTypes = [[1,3],[2,2],[3,1]], truckSize = 4
 * Output: 8
 * Explanation: There are:
 * - 1 box of the first type that contains 3 units.
 * - 2 boxes of the second type that contain 2 units each.
 * - 3 boxes of the third type that contain 1 unit each.
 * You can take all the boxes of the first and second types, and one box of the third type.
 * The total number of units will be = (1 * 3) + (2 * 2) + (1 * 1) = 8.
 *
 * Example 2:
 * Input: boxTypes = [[5,10],[2,5],[4,7],[3,9]], truckSize = 10
 * Output: 91
 *
 *
 *
 */

public class Array2d {

    /**
     * Way 1 : Brute Force
     * @param boxTypes
     * @param truckSize
     * @return
     * ************************************************************************************************************
     * Time Complexity : O(n^2+ 2n).
     * Space complexity : O(2) -> I need extra sortedBox Array to store the temp value
     *
     * Runtime: 148 ms, faster than 5.00% of Java online submissions for Maximum Units on a Truck.
     * Memory Usage: 39.9 MB, less than 6.47% of Java online submissions for Maximum Units on a Truck.
     */


    public static int maximumUnits1(int[][] boxTypes, int truckSize) {
        int maximumUnit = 0;
        int[][] sortedBoxTypes = sort(boxTypes);
        for ( int i = 0; i < boxTypes.length; i++){
            if ( truckSize <= boxTypes[i][0]){
                maximumUnit += truckSize* boxTypes[i][1];
                truckSize = truckSize - boxTypes[i][0];
                return maximumUnit;
            }
            else{

                maximumUnit +=  boxTypes[i][0] * boxTypes[i][1];
                truckSize = truckSize - boxTypes[i][0];

            }
        }

        return maximumUnit;

    }

    public static int[][] sort (int [][] boxTypes) {
        int[][] arr = new int [boxTypes.length][2];
        for ( int i = 0; i < boxTypes.length;i++){
            for ( int j = i+1; j <boxTypes.length; j++){
                if (boxTypes[i][1] < boxTypes[j][1]){
                    arr[i][0] = boxTypes[j][0];
                    arr[i][1] = boxTypes[j][1];
                    boxTypes[j][0] = boxTypes[i][0];
                    boxTypes[j][1] = boxTypes[i][1];
                    boxTypes[i][0] = arr[i][0];
                    boxTypes[i][1] = arr[i][1];
                }
            }
        }

        for (int i = 0; i < boxTypes.length; i++) {
            System.out.println("["+boxTypes[i][0]+","+boxTypes[i][1]+"]");
        }


        return arr;

    }










    /**
     * Way 2 : with Sort Collection in Arrays
     * @param boxTypes
     * @param truckSize
     * @return
     * ************************************************************************************************************
     * Time Complexity : O(nlogn) - java avg quicksort with collection in sort / O(n^2) worst case
     * Space complexity : O(logn)
     */
    public static int maximumUnits2(int[][] boxTypes, int truckSize) {
        //aescending order
        //Arrays.sort(boxTypes);
        //descending order with lambda
        Arrays.sort(boxTypes, (a,b)-> b[1] - a[1]);
        //descending order with Collections
        //Arrays.sort(boxTypes, Collections.reverseOrder());
        int totalMaxunit = 0;
        for(int[] box : boxTypes){
            if (truckSize >= box[0]){
                //box[0] == boxTypes[i][0]
                totalMaxunit += box[0]*box[1];
                truckSize -= box[0];
            }else{
                totalMaxunit += box[1]*truckSize;
                //truck is already full therefore I can return the totalMaxunit in here
                return totalMaxunit;
            }
        }
        return totalMaxunit;

    }





    public static void main(String[] args) throws NumberFormatException, IOException {
        int[][] Test1 = {{1,3},{2,2},{3,1}};
        int truckTest1 = 4;
        int[][] Test2 = {{5,10},{2,5},{4,7},{3,9},{6,15},{1,8}};
        int truckTest2 = 10;

        System.out.println(maximumUnits1(Test1,truckTest1));
        System.out.println(maximumUnits1(Test2,truckTest2));
        //System.out.println(maximumUnits2(Test1,truckTest1));
        //System.out.println(maximumUnits2(Test2,truckTest2));

    }

}
