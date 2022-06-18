import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Problem3 {

    // TC : O(n)
    // SC : O(1) since s consists of lowercase English letters which is 26 max
    public List<Integer> partitionLabels(String s) {
        if (s == null || s.length() == 0) return new ArrayList<>();

        int n = s.length();
        HashMap<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            map.put(c, i);
        }
        int sPoint = 0, ePoint = 0;
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            int index = map.get(c);
            ePoint = Math.max(ePoint, index);
            if (i == ePoint) {
                result.add(ePoint - sPoint + 1);
                sPoint = ePoint + 1;
            }
        }

        return result;
    }
}
