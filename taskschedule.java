TC: O(n)
SC:O(1). constant sized map

stored the freq of the characters and arranged them

class Solution {
    public int leastInterval(char[] tasks, int n) {
        HashMap<Character,Integer>map = new HashMap<>();
        int maxfreq = 0,maxcount=0;
        for(char c:tasks){
            if(map.containsKey(c)){
                int cnt = map.get(c);
                cnt++;
                map.put(c,cnt);
                maxfreq = Math.max(maxfreq,cnt);
            }
            else{
                 map.put(c,1);
            }
        }
        for(char key:map.keySet()){
            if(map.get(key) == maxfreq){
                maxcount++;
            }
        }
        
        int partitions = maxfreq -1;
        int availableSlots = partitions*(n-(maxcount-1));
        int pending = tasks.length - (maxfreq*maxcount);
        int idle = Math.max(0,availableSlots-pending);
        return tasks.length+idle;
    }
}