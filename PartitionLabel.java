import java.util.*;

/*
TC: O(N) N - length of string
SC: O(1) hashmap can be max size 26.

1. Traverse the string from end. Store the indices of each character in map.
2. Keep two pointers start and end. Fix the end by fetching it from map. That is the last occurence of the letter.
3. When i == end, that is the end of partition. Update start to end + 1.

*/

public class PartitionLabel{
    public List<Integer> partitionLabels(String S) {
        if(S == null || S.length() == 0) return new ArrayList<>();
        
        HashMap<Character, Integer> map = new HashMap<>();
        List<Integer> list = new ArrayList<>();
        
        //create character-index map
        for(int i = S.length() - 1; i >= 0; i--){
            char c = S.charAt(i);
            if(!map.containsKey(c)){
                map.put(c, i);
            }
        }
        
        int start = 0, end = 0;
        for(int i = 0; i < S.length(); i++){
            end = Math.max(end, map.get(S.charAt(i)));
            
            if(i == end){
                list.add(end - start + 1);
                start = end + 1;
            }
        }
        return list;
    }

    public static void main(String[] args){
        String S = "ababcbacadefegdehijhklij";
        PartitionLabel pl = new PartitionLabel();

        System.out.println(pl.partitionLabels(S));

    }
}