import java.util.*;

public class PartitionString {
    //Start the first character and find the last occurance of the current character and form a window.
    //Iterate all the character inside the window. 
    //- If it exists inside the window i would say it is valid partiion.
    //- We can extend till the current character's last occurance.
    
    //TC: O(N) - Iterating the entire string only one time
    //SC: O(N) - Using HashMap to save the character entry
    public List<Integer> partitionLabels(String s) {
        //Validation
        //In order to find the last occurance we need to iterate the array many times. To avoid that initiall put all the string inside the hashmap.
        //First character and find the last occurance form the window
        //Iterate all the elements and expand or check the if it is valid or not.
        
        List<Integer> result = new ArrayList();
        if(s == null || s.length() == 0 ) return result;
        
        HashMap<Character, Integer> map = new HashMap();
        
        for(int i=0;i<s.length();i++) {
            map.put(s.charAt(i), i);
        }
        int start =0;
        int end = 0;
        
        for(int i=0;i<s.length();i++) {
            end = Math.max(map.get(s.charAt(i)), end);
            if(i == end) {
                int difference = end - start +1;
                result.add(difference);
                start = i+1;
            }
        }
        
        return result;
    }

    public static void main(String[] args) {
        PartitionString partitionString = new PartitionString();
        List<Integer> result = partitionString.partitionLabels("ababcbacadefegdehijhklij");
        System.out.println("The result: "+result);
    }

}