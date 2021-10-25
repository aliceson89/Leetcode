package String;

import java.util.HashSet;
import java.util.Set;

/**
 * Arrays and Strings page 90
 * 1.1 Is Unique : Implement an algorithm to determine if a string has all unique characters. What if you cannot use
 * additional data structure?
 */
public class uniqueChar {

    /**
     * WAY 1
     */
    // Big O
    // Time complexity : O(n)
    // Space complexity : O(1)
    // extended ASCII : 256
    // ASCII : 128
    public static boolean isUniqueChar1(String str){
        if (str.length() > 256 ) return false;

        boolean[] char_set = new boolean[256];


        for(int i = 0; i <str.length(); i++){
            //It takes the character which is at index i in str and substracts the ASCII value of the character 'a'.
            int val = str.charAt(i);
            System.out.println("String value is : "+val);
            // if 'a' is 97 (ASCII), char_set[97] has "true" that means this char is already existed in the String.
            // Therefore, should return false and close the loop
            if(char_set[val]){
                return false;
            }
            char_set[val] = true;
        }
        return true;
    }
    /**
     * WAY 2 : https://cjh5414.github.io/bit-vector/
     * https://stackoverflow.com/questions/9141830/explain-the-use-of-a-bit-vector-for-determining-if-all-characters-are-unique
     */
    //Using Bit Vector
    //condition : String consists with only LowerCase alphabet
    //Can reduce space usage by a factor of eight
    public static boolean isUniqueChar2(String str){
        if (str.length() > 256 ) return false;
        int checker = 0;
        for (int i =0; i<str.length(); i++){
            int val = str.charAt(i) -'a';
            if ((checker & (1 << val)) > 0){
                return false;
            }
            checker |=(1 << val);
        }
        return true;
    }

    /**
     * WAY 3
     * Compare every character of the string to every other character of the string. This will take o(n^2) time and O(1) space
     */
    public static boolean isUniqueChar3(String str){
        String str2 = str;
        for (int i = 0; i < str.length(); i++){
            for (int j = 0; j < str.length(); j++){

                if ( i == j ){
                    System.out.println("Do not need check");
                    System.out.println("=================");
                    System.out.println(str.charAt(i));
                    System.out.println(str2.charAt(j));

                } else
                    if (str.charAt(i) == str2.charAt(j)) {
                        System.out.println("Identical part");
                        System.out.println("=================");
                        System.out.println(str.charAt(i));
                        System.out.println(str2.charAt(j));
                        return false;
                    }else{
                        System.out.println("Different Part");
                        System.out.println("=================");
                        System.out.println(str.charAt(i));
                        System.out.println(str2.charAt(j));
                    }
                }
            }
            return true;
    }

    /**
     * WAY 4
     * if we are allowed to modify the input string, we could sort the string O(n log(n)) time and then linearly check the string
     * for neighboring characters that are identical. Careful, though : many sorting algorithms take up extra space
     */

    /**
     * WAY 5
     * using set
     */
    public static boolean isUniqueChar5(String str){
        Set<Character> visit = new HashSet<>();
        for (char c: str.toCharArray())
            if (visit.contains(c))
                return false;
            else
                visit.add(c);
        return true;
    }


    public static void main (String[] args){

        String str = "absdfkejwelfadb";
        boolean check1 = isUniqueChar1(str);

        if (check1 == true){
            System.out.println("ALL char are different");
        }else{
            System.out.println("There are duplicated char in String");
        }
        boolean check2 = isUniqueChar2(str);
        if (check2 == true){
            System.out.println("ALL char are different");
        }else{
            System.out.println("There are duplicated char in String");
        }
        boolean check3 = isUniqueChar3(str);
        if (check3 == true){
            System.out.println("ALL char are different");
        }else{
            System.out.println("There are duplicated char in String");
        }




    }
}
