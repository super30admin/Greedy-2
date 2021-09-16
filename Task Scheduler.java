class Solution {
    public int leastInterval(char[] tasks, int n) {

        HashMap<Character,Integer> map = new HashMap<>();

        for(char c : tasks)
        {
            map.put(c , map.getOrDefault(c,0)+1);
        }

        int max = 0;
        int index = 0;
        int num_max = 0;

        for(char key : map.keySet())
        {
            max = Math.max(max,(map.get(key)));
        }

        for(char key : map.keySet())
        {
           if(map.get(key) == max) ++num_max;
        }

        int ans =  (max-1)*(n+1) + num_max;

        return ans<tasks.length?tasks.length:ans;

    }
}
