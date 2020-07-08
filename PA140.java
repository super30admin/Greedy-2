//Leetcode: 763. Partition Labels
//Time Complexity: O(n)
//Spacew Complexity: O(1), As size of hashmap wil neveer be greater than 26
class Solution {
    public List<Integer> partitionLabels(String S) {
        List<Integer> res= new ArrayList<>();    
        if(S==null || S.length()==0){
            return res;
        }
        HashMap<Character, Integer> hm = new HashMap<>();
        for(int i=0;i<S.length();i++){
            hm.put(S.charAt(i),i);
        }      
        int start=0;
        int end=0;        
          for(int i=0;i<S.length();i++){          
              end= Math.max(end, hm.get(S.charAt(i)));
                 if(i==end) {
                  res.add(i-start+1);
                  start=end+1;
              }
          }
        return res;
    }
}