package Array;
import java.util.*;
public class FindWord {


    public static boolean find1(String[] arrs, String word){
        Set<String> set = new HashSet<>();
        for (String arr : arrs){
            set.add(arr);
        }

        if (set.contains(word)){
            return true;
        }else{
            return false;
        }
    }

    public static int find2(String[] arrs, String word){
        for (int i = 0; i < arrs.length; i++){
            if(arrs[i].equals(word)){
                return i;
            }
        }
        return -1;
    }
    public static void main(String[] args){

        String[] arrs = {"apple","banana","cat","duck"};
        String word = "duck";

        System.out.println(find1(arrs,word));
        System.out.println(find2(arrs,word));
    }

}
