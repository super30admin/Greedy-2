// Time Complexity : O(N)
// Space Complexity : O(1)
import java.util.*;
public class PartitionLabels {
    static List<Integer> partitionLabels(String s) {
        int len = s.length();

        HashMap<Character, Integer> map = new HashMap<>();
        for(int i = 0; i < len; i++) {
            char c = s.charAt(i);
            map.put(c, i);
        }

        List<Integer> sol = new ArrayList<>();
        int start = 0; int end = 0;

        for(int i = 0; i < len; i++) {
            char c = s.charAt(i);
            end = Math.max(end, map.get(c));
            if(i == end) {
                sol.add(end - start + 1);
                start = i+1;
            }
        }

        return sol;
    }
    public static void main(String[] args) {
        String s = "ababcbacadefegdehijhklij";
        System.out.println("Partitions Length" + partitionLabels(s));
    }
}
