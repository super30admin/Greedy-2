//Time - O(n)
//Space - O(1) - 26 characters

class Solution {
    public int leastInterval(char[] tasks, int n) {
        HashMap<Character, Integer> map = new HashMap<>();
        int maxfreq = 0;
        int maxfreqcount = 0;
        for(char c: tasks){
            map.put(c, map.getOrDefault(c, 0) + 1);
            maxfreq = Math.max(maxfreq, map.get(c));
        }
        for(char key: map.keySet()){
            if(map.get(key) == maxfreq){
                maxfreqcount++;
            }
        }
        
        int availableslots = (maxfreq - 1) * (n - (maxfreqcount - 1));
        int pendingslots = tasks.length - (maxfreq*maxfreqcount);
        int idleslotsleft = Math.max(0, availableslots - pendingslots);
        
        return tasks.length + idleslotsleft;
    }
}