//Time Complexity :O(n)
//Space Complexity :O(n)

class Solution {
    public List<Integer> partitionLabels(String S) {
        HashMap<Character,Integer> map = new HashMap<Character,Integer>();
        List<Integer> result = new ArrayList<>();
        int[] count = new int[26];
        HashSet<Character> set = new HashSet<>();
        int length = 0 ;
        int startIndex =-1 ;
        for(int index = 0 ; index < S.length();index++){
              char c = S.charAt(index);
              count[c -'a']+=1;
        }
        
        for(int j = 0; j < S.length();j++){
            char c = S.charAt(j);
            count[c - 'a']-=1;
            if(count[c - 'a'] == 0){
                if(set.size()!=0)
                    set.remove(c);
            }
            if(count[c-'a'] == 0 && set.size() == 0 ){
                length = j - startIndex;
                startIndex = j;
                result.add(length);
                length = 0;
            }
            if(count[c-'a'] > 0){
                set.add(c);
            }
            
            
        }
        
        return result;
        
    }
}