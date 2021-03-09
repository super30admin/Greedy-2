class Solution {
    public int leastInterval(char[] tasks, int n) {
        HashMap<Character, Integer> hm = new HashMap<>();
        int max = 0;
        int count = 0;
        if(n==0)
            return tasks.length;
        //finding the max number of times a char is repeated
        for(int i=0;i<tasks.length;i++){
            int k = hm.getOrDefault(tasks[i], 0) + 1;
            hm.put(tasks[i], k);
            if(k>max){
                max = k;
            }
        }
       //finding the number of diff char with max count
        for(Map.Entry m:hm.entrySet()){
            if((Integer)m.getValue()==max)
                count++;
        }
        //number of spaces between character group of max count
        int spaces = Math.max(n-count+1,0);
        //number of spaces needed to maintain this gap
        int needed = (count+spaces)*(max-1)+count;
        //return the max of needed and actual
        return Math.max(tasks.length, needed);
    }
}

//Time complexity : O(N)
//Space complexity : O(N) for extra space used by hashmap
