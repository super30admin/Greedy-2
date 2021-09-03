// Time Complexity : O(N)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


class Solution {
    public int leastInterval(char[] tasks, int n) {
        if(tasks == null || tasks.length == 0) {
            return 0;
        }
        
        HashMap<Character, Integer> map = new HashMap<>();
        int maxFreq = 0;
        int maxCount = 0;
        for(Character task : tasks) {
            int count = map.getOrDefault(task,0);
            count++;
            maxFreq = Math.max(maxFreq, count);
            map.put(task,count);
        }
        
        for(char c : map.keySet()) {
            if(map.get(c) == maxFreq) {
                maxCount++;
            }
        }
        int partitions = maxFreq - 1;
        int availableSlots = partitions * (n - (maxCount - 1));
        int pendingTasks = tasks.length - maxFreq * maxCount;
        int idleTime = Math.max(0,availableSlots - pendingTasks);
        
        return idleTime + tasks.length;
        
    }
}

// Time Complexity : O(N log N)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


class Solution {
    public int[][] reconstructQueue(int[][] people) {
        if(people == null || people.length == 0) {
            return new int[0][0];
        }
        Arrays.sort(people,(a,b) -> a[0] == b[0] ?  a[1] - b[1] : b[0] - a[0]);
        
        //System.out.println(Arrays.deepToString(people));
        
        List<int[]> list = new ArrayList<>();
        
        for(int[] person : people) {
            list.add(person[1],person);
        }
        return list.toArray(new int[0][]);
    }
}


// Time Complexity : O(N)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

class Solution {
    public List<Integer> partitionLabels(String s) {
        int[] lastIndexes = new int[26];
        char[] chars = s.toCharArray();
        
        for(int i = 0; i < s.length(); i++) {
            lastIndexes[chars[i]-'a'] = i;
        }
        List<Integer> result = new ArrayList<>();
        int start = 0;
        int end = 0;
        
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            end = Math.max(end, lastIndexes[c - 'a']);
            
            if(i == end) {
                result.add(end - start + 1);
                start = i+1;
            }
        }
        return result;
        
    }
}