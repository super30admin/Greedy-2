//Timecomplexity:- O(n).
//space:- O(n).

class Solution {
    public int leastInterval(char[] tasks, int n) {
        HashMap<Character,Integer> cache=new HashMap<>();
        int maxfrequency=0;
        int maxcount=0;// denotes how many elements are there with max frequency.
        for(char ch:tasks){
            cache.put(ch,cache.getOrDefault(ch,0)+1);  //storing characters as keys and respective frequencies
            maxfrequency=Math.max(maxfrequency,cache.get(ch));
        }
        for(int values:cache.values()){
            if(values==maxfrequency){
                maxcount++;             //counting how many characters are having max frequency.
            }
        }
        int partition=maxfrequency-1;
        int empty=(n-maxcount+1)*partition;           //greedy approach of intuition alloting first for maxfrequency .
        int pending=tasks.length - (maxfrequency*maxcount);
        int idle=Math.max(0,empty-pending);
        return idle+tasks.length;
        
    }
}