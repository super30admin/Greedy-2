//Time -> O(n)
//Space -> O(1)

public class Problem3 {
        public List<Integer> partitionLabels(String s) {
            HashMap<Character, Integer> map = new HashMap<>();
            List<Integer> result = new ArrayList<>();
            int start = 0; 
            int end = 0;
            for(int i = 0; i < s.length(); i++){
                char c = s.charAt(i);
                map.put(c, i);
            }
            for(int i = 0; i < s.length(); i++){
                char c  = s.charAt(i);
                end = Math.max(end, map.get(c));
                if(i == end){
                    result.add(end - start + 1);
                    start = end + 1;
                }
            }
            return result; 
        }
}
