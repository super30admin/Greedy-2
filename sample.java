import java.util.*;

// Time Complexity :
// Space Complexity :
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
class Solution {
    //o(2n) time and constant space
    public List<Integer> partitionLabels(String s) {
        if(s == null || s.length() == 0) return new ArrayList<>();
        List<Integer> li = new ArrayList<>();
        HashMap<Character, Integer> map = new HashMap<>();
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            map.put(c, i);
        }
        int start = 0;
        int end = 0;
        for(int i = 0; i< s.length(); i++){
            char c = s.charAt(i);
            end = Math.max(end, map.get(c));
            if(i == end){
                li.add(i - start + 1);
                start = i + 1;
            }

        }
        return li;
    }
    public int leastInterval(char[] tasks, int n) {
        //o(n) for freq -  time and cont o(n) space
        if (tasks == null || tasks.length == 0) return 0;
        HashMap<Character, Integer> map = new HashMap<>();
        int maxFreq = 0; 
        for(int i = 0; i < tasks.length; i++){
            map.put(tasks[i] ,map.getOrDefault(tasks[i], 0) + 1);
            maxFreq = Math.max(maxFreq, map.get(tasks[i]));
        }
        int maxCount = 0;

        for(char task: map.keySet()){
            if(maxFreq == map.get(task)){
                maxCount++;
            }
        }
        int partitions = maxFreq -1;
        int empty = partitions * (n - (maxCount-1));
        int pending= tasks.length - (maxCount * maxFreq);
        int idle = Math.max(0, empty - pending);
        return idle + tasks.length;
        
    }

        public int[][] reconstructQueue(int[][] people) {

            //o(n^2) o(n) space 
            List<int[]> q = new ArrayList<>();
            Arrays.sort(people, (a,b) ->{
                if(a[0] == b[0]) return a[1] - b[1];
                return b[0] - a[0];
            });
            
            for(int[] person: people){
                q.add(person[1],person);
            }
            return q.toArray(new int[0][]);
        }
    
    
}