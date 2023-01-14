//Time complexity is O(N) N is lenght of s
//Space complexity is O(K) K is 26
class Solution {
    public List<Integer> partitionLabels(String s) {
        int[] arr = new int[26];
        List<Integer> result= new ArrayList<Integer>();
        for(int p=0;p<s.length();p++){
            arr[s.charAt(p)-'a']=p;
        }
        int start =0;
        int i=0;
        int hi = arr[s.charAt(i)-'a'];
        System.out.println(hi);
        while(i<s.length()){
            if(i==hi){
                result.add(hi-start+1);
                i=i+1;
                start = i;
                
            }
            else{
                i=i+1;
            }
            if(i<s.length()){
                hi = Math.max(hi,arr[s.charAt(i)-'a']);
            }
        }
        return result;
    }
}