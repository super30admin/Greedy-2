class Solution {
    public int leastInterval(char[] tasks, int n) {
        HashMap<Character, Integer> map = new HashMap<>();
        int temp;
        int max = Integer.MIN_VALUE;
        for(char c:tasks){
            temp = map.getOrDefault(c, 0);
            map.put(c, temp+1);
            max = Math.max(max, temp+1);
        }
        int f = max-1;
        int positions = f*(n+1);
        for(int i:map.values()){
            positions -= Math.min(i, f);
            if(positions<0)
                break;
        }

        return tasks.length + Math.max(positions,0);
    }
}