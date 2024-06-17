package Greedy-2;
// TC: O(n)
// SC: O(1)
public class Problem3 {
    public List<Integer> partitionLabels(String s) {
        int n = s.length();
        int start=0,end=0;
        HashMap<Character,Integer> map=new HashMap<>();
        for(int i=0;i<n;i++){
            char c = s.charAt(i);
            map.put(c, i);
        } 
        List<Integer> result = new ArrayList<>();
        for(int i=0;i<n;i++){
            end = Math.max(end, map.get(s.charAt(i)));
            if(i==end){
                result.add(end-start+1);
                start=i+1;
            }
            
        }
        return result;
    }
}
