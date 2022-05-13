import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

//Time Complexity : O(n)
//Space Complexity : O(1) as the size of map is max 26
public class PartitionLabels {	
	/**Approach: Greedy + Two Pointers**/
	public List<Integer> partitionLabels(String s) {
        List<Integer> res= new ArrayList<>();
        //store last index of each char
        HashMap<Character, Integer> map= new HashMap<>();        
        for(int i=0; i<s.length(); i++){
            map.put(s.charAt(i), i);
        }
        int start=0;
        int end=0;
        for(int i=0; i<s.length(); i++){
            end=Math.max(end, map.get(s.charAt(i)));
            if(i==end){
                res.add(end - start + 1);
                start = end + 1;
            }
        }
        return res;
    }
	
	// Driver code to test above
	public static void main (String[] args) {	
		PartitionLabels ob  = new PartitionLabels();		
		String s = "ababcbacadefegdehijhklij";
		System.out.println("SIze of partitions: "+ob.partitionLabels(s));
	}
}
