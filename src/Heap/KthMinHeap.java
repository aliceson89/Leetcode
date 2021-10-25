package Heap;
import java.util.*;
/**
 * [K-th Greatest Element in a Min-Heap] - Priority Queue
 * URL : https://www.geeksforgeeks.org/min-heap-in-java/
 * Ref : https://st-lab.tistory.com/205
 *
 * Def : A Min-Heap is a complete binary tree in which the value in each internal node is smaller than or equal to
 *       the values in the children of that node.
 *       Mapping the elements of a heap into an array is trivial:
 *       if a node is stored a index k,
 *       then its left child is stored at index 2k + 1 and
 *       its right child at index 2k + 2.
 *
 *       "How is Min Heap represented?"
 *
 *       A Min Heap is a Complete Binary Tree.
 *       A Min heap is typically represented as an array.
 *       The root element will be at Arr[0]. For any ith node, i.e., Arr[i]:
 *
 *       Arr[(i -1) / 2] returns its parent node.
 *       Arr[(2 * i) + 1] returns its left child node.
 *       Arr[(2 * i) + 2] returns its right child node.
 *
 * Question:

 *
 *
 *
 */

class MinHeap {

    private int[] Heap;
    private int size;
    private int maxsize;

    private static final int FRONT = 1;

    public MinHeap(int maxsize)
    {
        this.maxsize = maxsize;
        this.size = 0;
        Heap = new int[this.maxsize + 1];
        Heap[0] = Integer.MIN_VALUE;
    }

    // Function to return the position of
    // the parent for the node currently
    // at pos
    private int parent(int pos)
    {
        return pos / 2;
    }

    // Function to return the position of the
    // left child for the node currently at pos
    private int leftChild(int pos)
    {
        return (2 * pos);
    }

    // Function to return the position of
    // the right child for the node currently
    // at pos
    private int rightChild(int pos)
    {
        return (2 * pos) + 1;
    }

    // Function that returns true if the passed
    // node is a leaf node
    private boolean isLeaf(int pos)
    {
        if (pos >= (size / 2) && pos <= size) {
            return true;
        }
        return false;
    }

    // Function to swap two nodes of the heap
    private void swap(int fpos, int spos)
    {
        int tmp;
        tmp = Heap[fpos];
        Heap[fpos] = Heap[spos];
        Heap[spos] = tmp;
    }

    // Function to heapify the node at pos
    private void minHeapify(int pos)
    {

        // If the node is a non-leaf node and greater
        // than any of its child
        if (!isLeaf(pos)) {
            if (Heap[pos] > Heap[leftChild(pos)]
                    || Heap[pos] > Heap[rightChild(pos)]) {

                // Swap with the left child and heapify
                // the left child
                if (Heap[leftChild(pos)] < Heap[rightChild(pos)]) {
                    swap(pos, leftChild(pos));
                    minHeapify(leftChild(pos));
                }

                // Swap with the right child and heapify
                // the right child
                else {
                    swap(pos, rightChild(pos));
                    minHeapify(rightChild(pos));
                }
            }
        }
    }

    // Function to insert a node into the heap
    public void insert(int element)
    {
        if (size >= maxsize) {
            return;
        }
        Heap[++size] = element;
        int current = size;

        while (Heap[current] < Heap[parent(current)]) {
            swap(current, parent(current));
            current = parent(current);
        }
    }

    // Function to print the contents of the heap
    public void print()
    {
        for (int i = 1; i <= size / 2; i++) {
            System.out.print(" PARENT : " + Heap[i]
                    + " LEFT CHILD : " + Heap[2 * i]
                    + " RIGHT CHILD :" + Heap[2 * i + 1]);
            System.out.println();
        }
    }

    // Function to build the min heap using
    // the minHeapify
    public void minHeap()
    {
        for (int pos = (size / 2); pos >= 1; pos--) {
            minHeapify(pos);
        }
    }

    // Function to remove and return the minimum
    // element from the heap
    public int remove()
    {
        int popped = Heap[FRONT];
        Heap[FRONT] = Heap[size--];
        minHeapify(FRONT);
        return popped;
    }
}
public class KthMinHeap {

    public static void main (String[] args){
        int[] arr = {20, 15, 18, 8, 10, 5, 17};
        PriorityQueue<Integer> pQueue = new PriorityQueue<Integer>();

        for (int element : arr){
            pQueue.add(element);
        }
        // Printing the most priority element
        System.out.println("Head value using peek function:" + pQueue.peek());

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
            System.out.println("Value: " + array[i].toString());
    }
}
