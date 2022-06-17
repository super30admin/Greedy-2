class partitionLabels1 {
    public List<Integer> partitionLabels(String s) {
        if(s == null || s.length() == 0) return new ArrayList();
        
        List<Integer> result = new ArrayList();
        HashMap<Character, Integer> map = new HashMap();
        int start = 0;
        int end = 0;
        
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            map.put(c, i);
        }
        
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            end = Math.max(end, map.get(c));
            if(i == end){
                result.add(end - start + 1);
                start = end + 1;
            }
        }
        
        return result;
    }
}

//time complexity O(n) where n is the length of given string
//space complexity O(1)