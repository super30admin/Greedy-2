import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class LabelPartition {
//we record the last index of each character using HashMap
//Traverse through the string, we keep track of the farthest last index of any characters seen so far
//When current index reaches the farthest index, make it a partition and continue from the next character
//Time Complexity : O(n)
//Space Complexity : O(1)
    public List<Integer> partitionLabels(String s)
    {
        HashMap<Character,Integer> map = new HashMap<>();
        for(int i=0;i<s.length();i++)
        {
            char ch = s.charAt(i);
            map.put(ch,i);
        }
        List<Integer> result = new ArrayList<>();
        int start = 0, end=0;

        for(int i=0;i<s.length();i++)
        {
            char c = s.charAt(i);
            end = Math.max(end, map.get(c));

            if(i==end)
            {
                result.add(end-start+1);
                start = i+1;
            }
        }
    }
}
