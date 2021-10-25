package Array;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Question :
 * You are given an array of logs. Each log is a space-delimited string of words,
 * where the first word is the identifier.
 *
 * There are two types of logs:
 *
 *     Letter-logs: All words (except the identifier) consist of lowercase English letters.
 *     Digit-logs: All words (except the identifier) consist of digits.
 *
 * Reorder these logs so that:
 *
 *     The letter-logs come before all digit-logs.
 *     The letter-logs are sorted lexicographically by their contents. If their contents are the same,
 *     then sort them lexicographically by their identifiers.
 *     The digit-logs maintain their relative ordering.
 *
 * Return the final order of the logs.
 *
 * Example 1:
 *
 * Input: logs = ["dig1 8 1 5 1","let1 art can","dig2 3 6","let2 own kit dig","let3 art zero"]
 * Output: ["let1 art can","let3 art zero","let2 own kit dig","dig1 8 1 5 1","dig2 3 6"]
 * Explanation:
 * dig1, dig2, let3, let1, let2 are identifiers
 * The letter-log contents are all different, so their ordering is "art can", "art zero", "own kit dig".
 * The digit-logs have a relative order of "dig1 8 1 5 1", "dig2 3 6".
 *
 * Example 2:
 *
 * Input: logs = ["a1 9 2 3 1","g1 act car","zo4 4 7","ab1 off key dog","a8 act zoo"]
 * Output: ["g1 act car","a8 act zoo","ab1 off key dog","a1 9 2 3 1","zo4 4 7"]
 *
 * Constraints:
 *
 *     1 <= logs.length <= 100
 *     3 <= logs[i].length <= 100
 *     All the tokens of logs[i] are separated by a single space.
 *     logs[i] is guaranteed to have an identifier and at least one word after the identifier.
 */
public class ReorderData {
    /** Jinah Trial
    public static String[] reorderLogFiles1(String[] logs) {

        long maxCount = 0;
        //find max count
        for (int i = 0; i < logs.length ; i++){
            // split and count the number of words
            String[] log = logs[i].split("");
            if(maxCount < log.length)
                maxCount = log.length;
        }

        String[][] logsMatrix = new String[logs.length][(int)maxCount];
        for (int i= 0 ; i < logs.length; i++){
            String[] log2 = logs[i].split(" ");
            for (int j=0 ; j < maxCount; j++){
                logsMatrix[i][j] = log2[j];
            }
        }

        return logsMatrix;



    }
    **/

    public static String[] reorderLogFiles1(String[] logs) {

        /**
         * Way 1 : Using Comparator
         * @Comparator : compare method override, customized compare way, included in java.util
         * @Comparable : compareTo method override, Ascending order, included in java.lang, pulbic method
         * ************************************************************************************************************
         * Time Complexity : O(nlogn)
         * Space complexity : O(1)
         */
        Comparator<String> logComparator = new Comparator<String>(){
            @Override
            public int compare(String s1, String s2){
                // retrieve the first appeard space element index
                int s1SpaceIndex = s1.indexOf(' ');
                int s2SpaceIndex = s2.indexOf(' ');
                // the first char in first word
                char s1FirstCharater = s1.charAt(s1SpaceIndex+1);
                char s2FirstCharater = s2.charAt(s2SpaceIndex+1);


                // return -1 means
                // return  0 means
                // return  1 means
                // return  >1 means
                // number case ?? How to sort number compare
                if (s1FirstCharater <='9'){
                    if (s2FirstCharater <='9')
                        return 0; // do now change the location of char
                    else
                        return 1; // to change the location
                }
                if (s2FirstCharater <='9')
                    return -1; // do now change the location of char

                /**
                 * @substring
                 */

                //compareToIgnoreCase
                // preCompute retrieve the number of differences b/t s1 and s2
                int preCompute = s1.substring(s1SpaceIndex+1).compareTo(s2.substring(s2SpaceIndex+1));
                if (preCompute == 0)
                    return s1.substring(0,s1SpaceIndex).compareTo(s2.substring(0,s2SpaceIndex));
                return preCompute;
            }
        };
        Arrays.sort(logs, logComparator);
        return logs;

    }

    /**
     * Way 2 : Uppate sort method
     * ************************************************************************************************************
     * Time Complexity : O(nlogn)
     * Space complexity : O(1)
     */
    public String[] reorderLogFiles2(String[] logs) {
        if(logs.length == 0) return logs;

        Arrays.sort(logs, (o1, o2) -> {
            // to decide whether it is letter-logs or digit-logs
            char c1 = o1.split(" ")[1].charAt(0), c2 = o2.split(" ")[1].charAt(0);
            // to sort letter-logs
            String body1 = o1.substring(o1.indexOf(" ") + 1), body2 = o2.substring(o2.indexOf(" ") + 1);
            // to sort letter-logs, once the bodies are the equal
            String identifier1 = o1.substring(0, o1.indexOf(" ")), identifier2 = o2.substring(0, o2.indexOf(" "));

            // to sort logs if they both are letter-logs
            // Character.isLetter(c): if the "c" is letter -> return true
            // Character.isDigit(c) :  if the "c" is number -> return true
            if(Character.isLetter(c1) && Character.isLetter(c2)) {
                // to sort letter-logs by identifiers if the bodies are equal
                if(body1.equals(body2))
                    return identifier1.compareTo(identifier2);
                // to sort letter-logs by their bodies
                return body1.compareTo(body2);
            }
            // to sort logs, by always putting letter-logs ahead of digit-logs
            else if(Character.isLetter(c1) && Character.isDigit(c2)) return -1;
            // to sort logs, by always putting letter-logs ahead of digit-logs : c1 <-> c2
            else if(Character.isDigit(c1) && Character.isLetter(c2)) return 1;
            // to sort digit-logs, by leaving it as it is : The digit-logs maintain their relative ordering.
            return 0;
        });

        return logs;
    }


    public static void main(String[] args){
        String[] wordlist1 = {"dig1 8 1 5 1","let1 art can","dig2 3 6","let2 own kit dig","let3 art zero"};
        String[] wordlist2 = {"a1 9 2 3 1","g1 act car","zo4 4 7","ab1 off key dog","a8 act zoo"};

        String[] orderedlog1 = reorderLogFiles1(wordlist1);
        for(String word : orderedlog1){
            System.out.println(word);
        }

        System.out.println("=========================");
        String[] orderedlog2 = reorderLogFiles1(wordlist2);
        for(String word : orderedlog2){
            System.out.println(word);
        }










    }
}
