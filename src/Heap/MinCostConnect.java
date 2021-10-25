package Heap;

import java.util.PriorityQueue;

/**
 *
 * [Minimum Cost to Connect Sticks - no.1167]
 * Question :
 * In order to decorate your new house, you need to process some sticks with positive integer length.
 * You can connect any two sticks of lengths X and Y into one stick by paying a cost of X + Y.
 * Due to the construction needs, you must connect all the bars into one.
 * Return the minimum cost of connecting all the given sticks into one stick in this way.
 * Please note that you can choose any order of sticks connection
 *
 * Example 1:
 * Input:
 * [2,4,3]
 * Output:
 * 14
 * Explanation:
 * First connect 2 and 3 to 5 and cost 5; then connect 5 and 4 to 9; total cost is 14
 *
 * Example 2:
 * Input:
 *  [1,8,3,5]
 * Output:
 *  30
 *
 *
 * Constraint :
 * 1≤sticks.length≤10^4
 * 1≤sticks[i]≤10^4
 *
 */
public class MinCostConnect {


    /**
     * Approach 1
     * @param sticks
     * @return
     *
     * ************************************************************************************************************
     * Time Complexity : O(nlogn) - quick sort
     * Space complexity : O(n), The space required to store the values in min heap
     */
    public static int connectSticks(int[] sticks){
        int cost = 0;

        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        //ascending order with priority (1 -> 3 -> 5 -> 8)
        for (int stick: sticks){
            minHeap.add(stick);

        }


        while(minHeap.size()>1){
            // remove 1st, 2nd priority number
            int sum = minHeap.remove() + minHeap.remove();
            cost += sum;
            minHeap.add(sum);

        }
        return cost;
    }

    public static void main (String[] args){
        int[] sticks = {1,8,3,5};
        System.out.println(connectSticks(sticks));

    }
}
