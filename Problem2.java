
// time - O(N)
// space - O(1)



class Solution {
    public int leastInterval(char[] tasks, int n) {
        if(tasks == null || tasks.length == 0) return 0;

        HashMap<Character,Integer> map = new HashMap<>();

        int maxFreq = 0;
        int maxCount = 0;

        for(char c: tasks) {
            int cnt = map.getOrDefault(c,0);
            cnt++;
            maxFreq = Math.max(maxFreq,cnt); // calculate the maxFreq of each. character
            map.put(c,cnt);
        }

        for(char task: map.keySet()) {
            if(map.get(task) == maxFreq) maxCount++; // check the maxCount for each character if we have multiple elements with same count then incremeent the max count
        }

        int partition = maxFreq - 1;
        int available = partition * (n - (maxCount - 1));
        int pending = tasks.length - (maxFreq * maxCount);
        int idle = Math.max(0, available - pending);

        return idle + tasks.length;

    }
}