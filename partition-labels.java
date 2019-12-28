/*

Did it run Leet code: yes
Time Complexity: 0(N) // create hashmap and traverse string to calculate
Space Complexity: 0(N) // for hashmap

Algorithm:
- Create a hashmap where key is character of the string and value is the last index of the character in the string
- Whie traversing the string, compare the current index with the end variable 
    - if they both are eqaul then you have reached the end of the current window
    - if hMap value of character is greater than index it means the same character will be encountered later in the current window,
    so the window has to be extended till that point.


*/





class Solution {
    public List<Integer> partitionLabels(String S) {
        
        Map<Character, Integer> hMap = new HashMap<>();
        
        for(int i=0;i<S.length();++i){ hMap.put(S.charAt(i),i); }
        
        List<Integer> output = new ArrayList<>();
        int start=0,end=hMap.get(S.charAt(start));
        
        for(int i=0;i<S.length();++i){
            end = Math.max(end,hMap.get(S.charAt(i)));
            if(i==end){
                output.add(end - start + 1);
                start = end+1;
            }
        }
        
        return output;
        
    }
}
