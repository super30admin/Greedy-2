import java.util.ArrayList;
import java.util.List;
/*
Time Complexity: O(N), N is the length of the input string
Space Complexity: O(1), constant space
Run on Leetcode: yes
Any difficulties: No

Approach:
1. Well Commented code
 */
public class PartitionLabels {
    public static List<Integer> partitionLabels(String str){
        int []freqMap = new int[26];

        // Maintaining frequency map
        for(int i = 0; i<str.length(); i++){
            freqMap[str.charAt(i)-'a'] = i;
        }
        int maxFreq = 0;
        int runner = 0;
        List<Integer> result = new ArrayList<>();
        for(int i = 0; i<str.length(); i++){
            maxFreq = Math.max(maxFreq, freqMap[str.charAt(i)-'a']);
            /*
                We will partition the string when the index becomes equal to the maxFrequency
                and will add the index-runner pointer +1 in to the resultant and will increment runner pointer by one
            */
            if( i == maxFreq){
                result.add(i-runner+1);
                runner  = i+1;
            }
        }
        return result;
    }
    public static void main(String[] args){
        System.out.println("Partition Labels: "+ partitionLabels( "ababcbacadefegdehijhklij") );
    }
}
