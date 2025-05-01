// Time Complexity :
// Space Complexity :
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
class Solution {
    public List<Integer> partitionLabels(String s) {
        List<Integer> result = new ArrayList<>();
        Map<Character, Integer> m = new HashMap<>();
        int start=0;
        int end=0;
        for (int i=0;i<s.length();i++) {
            m.put(s.charAt(i), i);
        }
        for(int i=0;i<s.length();i++) {
            end = Math.max(end, m.get(s.charAt(i)));
            if (i == end) {
                result.add(end-start+1);
                start=i+1;
            }
        }

        return result;
    }
}
class Solution {
    public int leastInterval(char[] tasks, int n) {
        Map<Character, Integer> m = new HashMap<>();
        int time=0;
        for (int i=0;i<tasks.length;i++) {
            if (!m.containsKey(tasks[i])) {
                m.put(tasks[i], 1);
            } else {
                m.put(tasks[i], m.get(tasks[i])+1);
            }
        }
        PriorityQueue<Integer> q = new PriorityQueue<>((a, b) -> (b - a));
        m.forEach((k,v) -> q.add(v));

        while (!q.isEmpty()) {
            int cycle = n +1 ;
            int tasksCount=0;
            List<Integer> store = new ArrayList<>();
            while (cycle > 0 && !q.isEmpty()) {
                int currfreq = q.poll();
                if (currfreq > 1) {
                    store.add(currfreq-1);                    
                }
                tasksCount++;
                cycle--;
            }
            store.forEach(num -> q.add(num));
            time = time + (q.isEmpty() ? tasksCount : n+1);
        }
        return time;
    }
}


class Solution {
    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, (a,b) -> {
            if(a[0] == b[0]) {
                return a[1] - b[1];
            } else {
                return b[0] - a[0];
            }
    });
        List<int[]> q = new LinkedList<>();
        for(int[] person:people) {
            q.add(person[1], person);
        }

        return q.toArray(new int[][] {});
    }
}
