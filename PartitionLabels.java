/*
 * TC = O(N)
 * SC = O(N)
 */
import java.util.*;
public class PartitionLabels {
    public static List<Integer> partitionLabels(String s) {
        if(s == null || s.length() == 0) return new ArrayList<>();
        
        HashMap<Character,Integer> map = new HashMap<>();
        ArrayList<Integer> result = new ArrayList<>();
        
        for(int i =0;i<s.length();i++)
        {
            char curr = s.charAt(i);
            map.put(curr,i);
        }
        
        int start = 0,end = 0;
        
        for(int i = 0;i< s.length(); i++)
        {
            char c = s.charAt(i);
            end = Math.max(end, map.get(c));
            
            if(i == end)
            {
                result.add(end - start + 1);
                start = end + 1;
            }
        }
        
        return result;
    }

    public static void main(String args[])
    {
        String s = "ababcbacadefegdehijhklij";
        List<Integer> ans = partitionLabels(s);
        for(int i: ans)
        {
            System.out.print(i+" ");
        }
    }
}
