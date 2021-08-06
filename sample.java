//https://leetcode.com/problems/partition-labels/
//Time Complexity = O(N)
//Space Complexity = O(1)
class Solution {
    public List<Integer> partitionLabels(String s) {
        List<Integer> result = new ArrayList<>(); 
        if(s == null || s.length() == 0) return result;
        
        HashMap<Character, Integer> map = new HashMap<>(); 
        
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            map.put(c, i); 
        }
        
        int start = 0; int end = 0; 
        
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

//https://leetcode.com/problems/task-scheduler/
//Time Complexity = O(N)
//Space Complexity = O(1)
class Solution {
    public int leastInterval(char[] tasks, int n) {
        if(tasks == null || tasks.length == 0) return 0; 
        
        HashMap<Character, Integer> map = new HashMap<>(); 
        int maxCount = 0;
        
        for(int i = 0; i < tasks.length; i++){
            int count = map.getOrDefault(tasks[i], 0); 
            count++; 
            maxCount = Math.max(maxCount, count);
            map.put(tasks[i], count); 
        }
        
        int maxFreq = 0; 
        
        for(char c : map.keySet()){
            if(map.get(c) == maxCount){
                maxFreq++; 
            }
        }
        
        int partition = maxCount - 1; 
        int available = partition * (n - maxFreq + 1); 
        int pending = tasks.length - (maxFreq * maxCount);
        int idle = Math.max(0, available - pending); 
        
        return idle + tasks.length; 
    }
}

//https://leetcode.com/problems/queue-reconstruction-by-height/
//Time Complexity = O(N^2)
//Space Complexity = O(N)
class Solution {
    public int[][] reconstructQueue(int[][] people) {
        if(people == null || people.length == 0) return new int[0][0];
        
        Arrays.sort(people, (a,b) -> {
            if(a[0] == b[0]){
                return a[1] - b[1]; 
            }
            return b[0] - a[0]; 
        });
        
        List<int[]> q = new ArrayList<>(); 
        
        for(int[] p : people){
            q.add(p[1], p); 
        }
        return q.toArray(new int[0][]);
    }
}
