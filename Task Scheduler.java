// time complexity:O(n)
//space complexity:O(n)

class Solution {
    public int leastInterval(char[] tasks, int n) {
        int max=0;
        int count=0;
        HashMap<Character,Integer> map=new HashMap<>();
        for(char c:tasks)
        {
            int cnt= map.getOrDefault(c,0);
            map.put(c,cnt+1);
            max=Math.max(max,cnt+1);
        }
        for(char c:map.keySet())
        {
            if(map.get(c)==max)
            {
                count++;
            }
        }
        int partitions=max-1;
        int empty=partitions*(n-count+1);
        int pending=tasks.length-count*max;
        int idle=Math.max(0,empty-pending);
        return tasks.length+idle;
        
    }
}
