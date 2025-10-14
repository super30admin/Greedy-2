// This algorithm uses a greedy approach where we extend the rightMostIndex of a particular character and keep extending the range as long as we find a char within the initial range which has right most index greater than existing index
// This way we greedily grab the duplicated chars into one range and move to next one when its done
class Solution {
    public List<Integer> partitionLabels(String s) {
        int max = 0;

        Map<Character, Integer> map = new HashMap();
        for(int i=0;i<s.length();i++) {
            map.put(s.charAt(i), i);
        }

        List<Integer> totalPartitions = new ArrayList();

        for(int i=0;i<s.length();) {
            int j = i;
            char c = s.charAt(i);
            int rightMostIndex = map.get(c);

            while(j<rightMostIndex) {
                j++;
                rightMostIndex = Math.max(rightMostIndex, map.get(s.charAt(j)));
            }
            totalPartitions.add(j-i+1);
            i=j+1;
        }

        return totalPartitions;
    }
}
