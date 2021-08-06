
// time - O(N)
// space - O(1)



class Solution {
    public List<Integer> partitionLabels(String s) {

        List<Integer> result = new ArrayList<>();
        if(s == null) return result;

        HashMap<Character,Integer> map = new HashMap<>();

        // count the characters in the map with their count
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            map.put(c,i);

        }

        // partitioning

        int start = 0; int end = 0;

        for(int i = 0; i < s.length(); i++) {

            char c = s.charAt(i);
            end = Math.max(end,map.get(c)); // update the max window if new position of the element is found
            if(i == end) { // if i hits the end then add the index position to the result

                result.add(end - start + 1);
                start = end + 1; // increment the start's position

            }

        }

        return result;


    }
}