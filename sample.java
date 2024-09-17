// Problem 1 - Queue Reconstruction by Height
// Time Complexity : O(nlogn)
// Space Complexity : O(n) extra space for hashmap

// Your code here along with comments explaining your approach
// 1 - sort the array
// 2 - loop over array
// 3 - add to list
// 4 - convert list to 2D array
class Solution {
    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, (a,b) -> a[0] == b[0] ? a[1] - b[1] : b[0] - a[0]);
        List<int[]> result = new ArrayList<>();

        for(int[] p : people) {
            result.add(p[1], p);
        }

        return result.toArray(new int [0][]);
    }
}

// Problem 2 - Partition Labels
// Time Complexity : O(n)
// Space Complexity : O(n) extra space for hashmap

// Your code here along with comments explaining your approach
// 1 - create a hashmap for latest index of char
// 2 - initialize start and end index to 0
// 3 - loop over string
// 4 - update end to max of end and curr char's last index
// 5 - if curr index equals end, add the length to list
// 6 - set start to next element
// 7 - return output
class Solution {
    public List<Integer> partitionLabels(String S) {
        List<Integer> output = new ArrayList<>();
        
        if (S == null || S.length() == 0) {
            return output;
        }
        // 1
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i=0; i<S.length(); i++) {
            map.put(S.charAt(i), i);
        }
        // 2
        int s = 0;
        int e = 0;
        // 3
        for (int i=0; i<S.length(); i++) {
            // 4
            e = Math.max(e, map.get(S.charAt(i)));
            // 5
            if (i == e) {
                output.add(e - s + 1);
                // 6
                s = e + 1;
            }
        }
        // 7
        return output;
    }
}
