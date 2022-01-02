class Solution {
    public List<Integer> partitionLabels(String s) {
        HashMap<Character, Integer> end = new HashMap<>();
        char c;
        for(int i =0;i<s.length();i++)
            end.put(s.charAt(i), i);

        List<Integer> res = new ArrayList<>();
        int currMax = 0;
        int prev =0;
        for(int i =0;i<s.length();i++){
            if(i>currMax){
                res.add(i-prev);
                prev = i;
            }

            currMax = Math.max(currMax, end.get(s.charAt(i)));

        }
        res.add(s.length()-prev);

        return res;

    }
}