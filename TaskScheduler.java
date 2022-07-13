//Time -O(n)
//Space - O(1)
class Solution {
    public int leastInterval(char[] tasks, int n) {
        int maxfreq =0;
        HashMap<Character,Integer> map = new HashMap<>();
        for(int i =0; i< tasks.length; i++){
            int freq = map.getOrDefault(tasks[i],0);
            freq++;
            maxfreq = Math.max(maxfreq,freq);
            map.put(tasks[i], freq);
        }
        int maxEl =0;
        for(char task: map.keySet()){
            if(map.get(task) == maxfreq){
                maxEl++;
            }
        }


        int part = maxfreq-1;
        int avail = part *(n-(maxEl-1));
        int pend = tasks.length - (maxfreq*maxEl);
        int idle = Math.max(0, avail-pend);
        
        return tasks.length + idle;
    }
}