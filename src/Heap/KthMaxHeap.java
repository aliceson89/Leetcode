package Heap;

import java.util.*;

/**
 * [K-th Greatest Element in a Min-Heap] - Priority Queue
 * URL : https://www.geeksforgeeks.org/max-heap-in-java/
 *
 * Def : A max-heap is a complete binary tree in which the value in each internal node is greater than
 *       or equal to the values in the children of that node.
 *       Mapping the elements of a heap into an array is trivial:
 *       if a node is stored an index k, then its left child is stored at index 2k+1
 *       and its right child at index 2k+2.
 *
 *       "How is Max Heap represented?"
 *
 *       A-Max Heap is a Complete Binary Tree.
 *       A-Max heap is typically represented as an array.
 *       The root element will be at Arr[0].
 *       elow table shows indexes of other nodes for the ith node, i.e., Arr[i]:
 *       Arr[(i-1)/2] Returns the parent node.
 *       Arr[(2*i)+1] Returns the left child node.
 *       Arr[(2*i)+2] Returns the right child node.
 *
 * Question:
 * Given a max-heap of size n, find the kth greatest element in the min-heap.
 *
 * Examples:
 *
 *     Input : maxHeap = {20, 15, 18, 8, 10, 5, 17}
 *     k = 4
 *     Output : 15
 *
 *     Input : maxHeap = {100, 50, 80, 10, 25, 20, 75}
 *     k = 2
 *     Output : 80
 *
 *  Approach : sorting Descending order -> find 4th element in Array maxHeap[3]
 *
 *
 */

class MaxHeap{

    private int[] Heap;
    private int size;
    private int maxsize;

    public MaxHeap(int maxsize){
        this.maxsize = maxsize;
        this.size = 0;
        Heap = new int[this.maxsize +1];
        Heap[0]=Integer.MAX_VALUE;
    }

    private int parent (int pos) { return pos/2; }

    private int leftChild(int pos){ return (2*pos); }
    private int rightChild(int pos){ return (2*pos)+1; }

    private boolean isLeaf(int pos){
        if ( pos > (size/2) && pos <=size){
            return true;
        }
        return false;
    }

    private void swap(int fpos, int spos){
        int tmp;
        tmp = Heap[fpos];
        Heap[fpos] = Heap[spos];
        Heap[spos] = tmp;
    }

    private void maxHeapify(int pos){
        if(isLeaf(pos))
            return;

        if(Heap[pos] < Heap[leftChild((pos))] || Heap[pos] < Heap[rightChild(pos)]){

            if(Heap[leftChild(pos)]> Heap[rightChild(pos)]){
                swap(pos,leftChild(pos));
                maxHeapify(leftChild(pos));
            }else{
                swap(pos,rightChild(pos));
                maxHeapify(rightChild(pos));
            }
        }
    }

    /**
     *  insert(): Inserting a new key takes O(Log n) time.
     *  We add a new key at the end of the tree.
     *  If the new key is smaller than its parent,
     *  then we don’t need to do anything.
     *  Otherwise, we need to traverse up to fix the violated heap property.
     * @param element
     */
    public void insert (int element){
        Heap[++size] = element;

        int current = size;
        while(Heap[current] > Heap[parent(current)]){
            swap(current, parent(current));
            current = parent(current);
        }
    }

    public void print(){
        for (int i = 1; i <= size/2 ; i++){
            System.out.println(" PARENT : " + Heap[i]
                                + " LEFT CHILD : " + Heap[2*i]
                                + " RIGHT CHILD: " + Heap[2*i +1]);
            System.out.println();
        }
    }

    /**
     * extractMax(): Removes the maximum element from MaxHeap.
     * Time Complexity of this Operation is O(Log n) as this operation needs to maintain
     * the heap property (by calling heapify()) after removing the root.
     * @return
     */
    public int extractMax(){
        int popped = Heap[1];
        Heap[1] = Heap[size--];
        maxHeapify(1);
        return popped;
    }
}
public class KthMaxHeap {

    public static void main (String[] args){
        int[] arr = {20, 15, 18, 8, 10, 5, 17};
        MaxHeap maxHeap = new MaxHeap(9);
        for (int element : arr){
            maxHeap.insert(element);
        }

        maxHeap.print();
        System.out.println("The max val is " + maxHeap.extractMax());

        //MaxHeap
        PriorityQueue<Integer> pQueue = new PriorityQueue<Integer>(Collections.reverseOrder());
        for (int element : arr){
            pQueue.add(element);
        }
        // Printing the most priority element
        System.out.println("Head value using peek function:"
                + pQueue.peek());

        // Printing all elements
        System.out.println("The queue elements:");
        Iterator itr = pQueue.iterator();
        while (itr.hasNext())
            System.out.println(itr.next());

        // Removing the top priority element (or head) and
        // printing the modified pQueue using poll()
        pQueue.poll();
        System.out.println("After removing an element "
                + "with poll function:");
        Iterator<Integer> itr2 = pQueue.iterator();
        while (itr2.hasNext())
            System.out.println(itr2.next());

        // Removing 30 using remove()
        pQueue.remove(30);
        System.out.println("after removing 30 with"
                + " remove function:");
        Iterator<Integer> itr3 = pQueue.iterator();
        while (itr3.hasNext())
            System.out.println(itr3.next());

        // Check if an element is present using contains()
        boolean b = pQueue.contains(20);
        System.out.println("Priority queue contains 20 "
                + "or not?: " + b);

        // Getting objects from the queue using toArray()
        // in an array and print the array
        Object[] array = pQueue.toArray();
        System.out.println("Value in array: ");
        for (int i = 0; i < array.length; i++)
            System.out.println("Value: "
                    + array[i].toString());

    }
}
