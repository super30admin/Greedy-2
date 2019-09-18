package greedy3;

import java.util.ArrayList;
import java.util.List;

// TC : O(n) since we iterate over the entire string
// SC : O(1) array of length 26 

public class PartitionLabels {
	
	public static List<Integer> partitionLabels(String S) {
        if(S == null || S.length() == 0){
            return null;
        }
        List<Integer> result = new ArrayList<>();
        int[] charArray = new int[26];  // save the last index of the each character

        for(int i = 0; i < S.length(); i++){
            charArray[S.charAt(i)-'a'] = i;
        }
        // keep note of the end index of the current sub string
        int lastIndex = 0;
        int startIndex = 0;
        for(int i = 0; i < S.length(); i++){
            lastIndex = Math.max(lastIndex, charArray[S.charAt(i)-'a']);
            if(lastIndex == i){
                result.add(lastIndex - startIndex + 1);
                startIndex = lastIndex + 1;
            }
        }
        return result;
    }
	
	public static void main(String[] args ) {
		String s = "ababcbacadefegdehijhklij";
		
		System.out.println(partitionLabels(s)); // [9, 7, 8]
		
	}
}
