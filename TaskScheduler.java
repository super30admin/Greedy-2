class Solution {
    public int leastInterval(char[] tasks, int n) {
        //frequency map
        HashMap<Character , Integer> map = new HashMap<>();
        for(char ch : tasks){
            if(!map.containsKey(ch)){
                map.put(ch , 1);
            }
            else{
                map.put(ch , map.get(ch) + 1);
            }
        }

        //what task have maxfreq and how many are they?
        int maxfreq = 0;
        for(int freq : map.values()){
            maxfreq = Math.max(freq , maxfreq);
        }
        int count = 0;
        for(int freq : map.values()){
            if(freq == maxfreq){count++;}
        }

        int partitions = maxfreq - 1;
        int available = partitions * (n - (count - 1));
        int pending = (tasks.length) - (maxfreq * count);
        int idle = Math.max(0 , (available - pending));
        int total = tasks.length + idle;
        return total;

        
    }
}