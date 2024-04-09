
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//TC - O(n)
//SC - O(n)
class Solution {
  public List<Integer> partitionLabels(String s) {
	  Map<Character, Integer> map = new HashMap<>();
      for(int i=0;i<s.length();i++){
          char ch = s.charAt(i);
          map.put(ch,i);
      }
      List<Integer> output = new ArrayList<>();
      int start =0;
      int end =0;
      for(int i=0;i<s.length();i++){
    	  end = Math.max(end,map.get(s.charAt(i)));
          if(end==i){
              output.add(end+1-start);
              start = end+1;
          }      
      }
      return output;
  }
}
public class PartitionLabels {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
