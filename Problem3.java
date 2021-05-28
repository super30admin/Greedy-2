//Parition Labels
import java.util.*;
//tc- O(n)
//sc- O(1)
public class Problem3 {
    public static void main(String[] args){
        Problem3 p = new Problem3();
        System.out.println(p.partitionLabels("ababcbacadefegdehijhklij"));

    }
    public List<Integer> partitionLabels(String s) {
        int n = s.length();
        List<Integer> res = new ArrayList<>();
        if(s == null || s.length() ==0){
            return res;
        }
        HashMap<Character, Integer> map = new HashMap<>();
        for(int i = 0;i< n ; i++){
            map.put(s.charAt(i), i);
        }
        
        int start = 0;
        int end = 0;
        for(int i = 0;i< n ;i++){
            end = Math.max(end, map.get(s.charAt(i)));
            if(end == i){
                res.add(end - start +1);
                start = i+1;
                
            }
        }
        return res;
        
    }

    
}
