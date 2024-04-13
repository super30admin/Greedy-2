
    // TC = O(n)
    //  SC = O(n)class Solution {
    public int leastInterval(char[] tasks, int n) {
        HashMap<Character, Integer> m = new HashMap<>();
        int mf=0;
        int ntmf=0;
        for(int i = 0; i< tasks.length; i++){
            char task = tasks[i];
            m.put(task, m.getOrDefault(task, 0)+1 );
            if(m.get(task) > mf){
                ntmf = 1;
                mf = m.get(task);
            }else if(m.get(task) == mf){
                ntmf++;
            }
        }
        int partitions = mf-1;
        int emp = partitions *(n-(ntmf -1));
        int pending= tasks.length - (mf*ntmf);
        int idle = Math.max(0, emp - pending);
        return tasks.length + idle;
    }
}