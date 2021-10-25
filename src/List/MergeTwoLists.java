package List;

import java.nio.charset.CharsetEncoder;
import java.util.*;

public class MergeTwoLists {


      //Definition for singly-linked list.
      //그 다음 노드를 가리킨다. recursive 한 개념이라고 생각하면 됨. 
      public static class ListNode {
         int val;
         ListNode next, prev;
         ListNode() {}
         ListNode(int val) { this.val = val; }
         ListNode(int val, ListNode next) { this.val = val; this.next = next; }

          @Override
          public String toString() {
              return "Node{" + "val=" + val +"{next="+ next  +"}";
          }
      }

      // 1 <-> 2 <-> 3

    static class Solution {
        public static ListNode mergeTwoLists1(ListNode l1, ListNode l2) {
            ListNode head = new ListNode(); //merge
            ListNode tail = head;

            while (l1 != null || l2 != null){
                if (l2 == null || (l1 != null && l1.val < l2.val)){
                    //System.out.println(head.toString());
                    tail.next = l1;
                    //System.out.println(tail.toString());
                    tail = l1;
                    //System.out.println(tail.toString());
                    l1 = l1.next;
                    //System.out.println(l1.toString());
                    //System.out.println(head.toString());
                }else{
                    //System.out.println(head.toString());
                    tail.next = l2;
                    //System.out.println(tail.toString());
                    tail = l2;
                    //System.out.println(tail.toString());
                    l2 = l2.next;
                    //System.out.println(l2.toString());
                    //System.out.println(head.toString());
                }
            }
            return head.next;
        }


        /**
         * O(N) N is the size of the smaller list .we only have N iteration in our while loop.
         * O(1) no extra space
         * @param l1
         * @param l2
         * @return
         */
        public static ListNode mergeTwoLists2(ListNode l1, ListNode l2) {
            ListNode dummy = new ListNode(0);
            //head points to dummy
            ListNode head = dummy;
            // a.next = b : add b node pointer value in a node
            while(l1 != null && l2 != null) {
                if (l1.val <= l2.val) {
                    // dummy next node is l1 smaller node.
                    dummy.next = l1;
                    // point to the next l1 node to compare next iterator
                    l1 = l1.next;
                } else {
                    dummy.next = l2;
                    //l2 = l2.next mean pointer move !!!
                    l2 = l2.next;
                }
                // avoid overwrite next iterator, dummy pointer should be move next dummy.
                dummy = dummy.next;
            }

            // if any list remain element add this after dummy.
            if (l1 != null) {
                dummy.next = l1;
            } else if (l2 != null) {
                dummy.next = l2;
            }

            // the reason why we can't retrive dummy , dummy pointer is moving after while
            return dummy;
        }

        //l1 : 1 -> 2 -> 4
        //l2: 1 -> 3 -> 4

        // 1 -> 1 -> 2 -> 3

        /**
         * Time Complexity:
         * Since we are traversing through the two lists fully.
         * So, the time complexity is O(m+n) where m and n are the lengths of the two lists to be merged.
         * @param l1
         * @param l2
         * @return
         */
        private static ListNode mergeTwoLists3(ListNode l1, ListNode l2) {
            //base case
            if (l1 == null) return l2;  //l2 == null, l2 == ?
            if (l2 == null) return l1; //l1 == ?
            //l1 != null && l2 != null
            ListNode cur = null;
            if (l1.val <= l2.val) {
                cur = l1;
                cur.next = mergeTwoLists3(l1.next, l2);
            } else {
                cur = l2;
                cur.next = mergeTwoLists3(l1, l2.next);
            }
            return cur;
        }

        public static ListNode mergeTwoLists4(ListNode A, ListNode B){
            if(A == null) return B;
            if(B == null) return A;

            if(A.val < B.val)
            {
                A.next = mergeTwoLists4(A.next, B);
                return A;
            }
            else
            {
                B.next = mergeTwoLists4(A, B.next);
                return B;
            }
        }

        public static void main(String[] args){
            ListNode l1 = new ListNode(1);
            l1.next = new ListNode(2);
            l1.next.next = new ListNode(4);

            ListNode l2 = new ListNode(1);
            l2.next = new ListNode(3);
            l2.next.next = new ListNode(4);

            //ListNode h = mergeTwoLists2(l1, l2);
            ListNode h1 = mergeTwoLists2(l1, l2);
           // System.out.println(h);

            mergeTwoLists3(l1, l2);


        }
    }
}
