class Solution {
    public int leastInterval(char[] tasks, int n) {
        int s = tasks.length;
        HashMap<Character,Integer> hm = new HashMap<>();
        int maxf = 0;
        int maxelement = 0;

        for(int i=0;i<s;i++){
            if(hm.containsKey(tasks[i])){
                hm.put(tasks[i],hm.get(tasks[i])+1);
                maxf = Math.max(maxf,hm.get(tasks[i]));
            }
            else{
                hm.put(tasks[i],1);
                maxf = Math.max(maxf,hm.get(tasks[i]));
            }

        }

        for(char t : hm.keySet()){

            if(hm.get(t)==maxf){
                maxelement++;
            }

        }
        int partion = maxf - 1;
        int available = partion * (n-(maxelement-1));
        int pending = tasks.length - (maxf * maxelement);
        int idle  = Math.max(0,available - pending);


        

        return tasks.length + idle;
        
    }
}