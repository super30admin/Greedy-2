import java.util.ArrayList;
import java.util.List;

public class problem3 {
    // Time Complexity: O(n)
    // Space Complexity: O(26)

    public List<Integer> partitionLabels(String s) {
        int[] map= new int[26];
        for(int i=0;i<s.length();i++)
        {
            char c= s.charAt(i);
            map[c-'a']=i;
        }
        int start=0, end=0;
        ArrayList<Integer> res= new ArrayList<>();
        for (int i=0;i<s.length();i++)
        {
            char c= s.charAt(i);
            end= Math.max(end, map[c-'a']);
            if (end==i)
            {
                res.add(end-start+1);
                start=i+1;
            }
        }
        return res;

    }
}