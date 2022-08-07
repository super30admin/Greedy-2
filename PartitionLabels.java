import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

//Time Complexity=O(n)
//Space Complexity=O(n)
public class PartitionLabels {

    public List<Integer> partitionLabels(String s) {
        int n=s.length();
        List<Integer> result=new ArrayList<>();
        HashMap<Character,Integer> map=new HashMap<>();
        for(int i=0;i<n;i++){
            char c=s.charAt(i);
            map.put(c,i);
        }
        int end=-1,start=0;
        for(int i=0;i<n;i++){
            char c=s.charAt(i);
            int curr=map.get(c);
            end=Math.max(end,curr);
            if(i==end){
                result.add(end-start+1);
                start=end+1;
            }
        }

        return result;
    }
}
