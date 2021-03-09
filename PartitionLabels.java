class Solution {
    public List<Integer> partitionLabels(String s) {
        HashMap<Character, Integer> hm = new HashMap<>();
//Store last index of each character
        for(int i=0;i<s.length();i++){
            hm.put(s.charAt(i), i);
        }
        List<Integer> res = new ArrayList<>();
        int max_ind = 0;
        int last = 0;
//keep a global last and max, check when max index is equal to current index
//When this happens you can add that partition into the result list
        for(int i=0;i<s.length();i++){
            int k = hm.get(s.charAt(i));
            if(k>max_ind){
                max_ind = k;
            }
            if(max_ind == i){
                res.add(i+1-last);
                last = max_ind+1;
            }
        }
        return res;
    }
}

//Time complexity : O(N)
//Space complexity : O(N)
