package Heap;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 *
 * [K Closest Points to Origin - no.973]
 * URL : https://leetcode.com/problems/k-closest-points-to-origin/
 *
 * Question :
 * Given an array of points where points[i] = [xi, yi]
 * represents a point on the X-Y plane and an integer k, return the k closest points to the origin (0, 0).
 *
 * The distance between two points on the X-Y plane is the Euclidean distance
 * (i.e., √(x1 - x2)2 + (y1 - y2)2).
 *
 * You may return the answer in any order.
 * The answer is guaranteed to be unique (except for the order that it is in).
 *
 * Example 1:
 * Input: points = [[1,3],[-2,2]], k = 1
 * Output: [[-2,2]]
 *
 * Explanation:
 * The distance between (1, 3) and the origin is sqrt(10).
 * The distance between (-2, 2) and the origin is sqrt(8).
 * Since sqrt(8) < sqrt(10), (-2, 2) is closer to the origin.
 * We only want the closest k = 1 points from the origin, so the answer is just [[-2,2]].
 *
 * Example 2:
 *
 * Input: points = [[3,3],[5,-1],[-2,4]], k = 2
 * Output: [[3,3],[-2,4]]
 * Explanation: The answer [[-2,4],[3,3]] would also be accepted.
 *
 *
 *
 * Constraints:
 *
 *     1 <= k <= points.length <= 10^4
 *     -10^4 < xi, yi < 10^4
 *
 */
public class KCloestPoint {

    /**
     * Approach 1 : priority queue
     * @param points
     * @param k
     * @return
     * *********************************************************************************************************
     * Complexity Analysis
     *
     *     Time Complexity: O(nlogn), where N is the length of points.
     *
     *     Space Complexity: O(n),The space required to store the values in min heap
     */
    public static int[][] kClosest1(int[][] points, int k) {

        //descending order
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a,b)-> (b[0]*b[0]+b[1]*b[1])-(a[0]*a[0]+a[1]*a[1]));
        for (int[] point : points){
            maxHeap.add(point);
            if(maxHeap.size()>k){
                maxHeap.remove();
            }
        }

        int[][]result = new int[k][2];
        //until queue is empty
        while(k-- > 0){
            result[k] = maxHeap.remove();

        }

        return result;
    }

    /**
     * Approach 2 : create new array to store distance b/t (0,0) and point
     * @param points
     * @param K
     * @return
     * *********************************************************************************************************
     * Complexity Analysis
     *
     *     Time Complexity: O(NlogN), where N is the length of points.
     *
     *     Space Complexity: O(1)
     */
    public static int[][] kClosest2(int[][] points, int K) {
        int N = points.length;
        int[] dists = new int[N];
        for (int i = 0; i < N; ++i)
            dists[i] = dist(points[i]);

        Arrays.sort(dists);
        int distK = dists[K-1];

        int[][] ans = new int[K][2];
        int t = 0;
        for (int i = 0; i < N; ++i)
            if (dist(points[i]) <= distK)
                ans[t++] = points[i];
        return ans;
    }

    public static int dist(int[] point) {
        // root ignore and the distance from (0,0) to point
        return point[0] * point[0] + point[1] * point[1];
    }


    public static void main (String[] args){
        int[][] points1 = {{1,3},{-2,2}};
        int[][] result1 = kClosest1(points1,1);
        int[][] points2 = {{3,3},{5,-1},{-2,4}};
        int[][] result2 = kClosest2(points2,2);

        for (int i = 0; i < result1.length; i++){
            System.out.println(result1[i][0]+","+result1[i][1]);
        }

        for (int i = 0; i < result2.length; i++){
            System.out.println(result2[i][0]+","+result2[i][1]);
        }

    }

}
