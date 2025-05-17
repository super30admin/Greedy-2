import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//TC: O(n)
//SC: O(1)
class PartitionLabels {
  public List<Integer> partitionLabels(String s) {
      List<Integer> res=new ArrayList<>();
      Map<Character,Integer> map=new HashMap<>();
      //or
      //int[] map=new int[26];
      for(int i=0;i<s.length();i++){
          map.put(s.charAt(i),i);
      }
      int l=0;int h=0;
      for(int i=0;i<s.length();i++){
          h=Math.max(h,map.get(s.charAt(i)));
          if(i==h){
              res.add(h-l+1);
              l=i+1;
          }
      }
      return res;
  }
}