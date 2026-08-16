//problem1
class Solution {
    public int leastInterval(char[] tasks, int n) {
        int maxim=0;
        HashMap<Character,Integer>map=new HashMap<>();
        for(char ch:tasks){
            map.put(ch,map.getOrDefault(ch,0)+1);
            maxim=Math.max(maxim,map.get(ch));
        }
        int cnt=0;
        for(char c:map.keySet()){
            if(map.get(c)==maxim){
                cnt++;
            }
        }
        int parition=maxim-1;
        int available=parition*(n-(cnt-1));
        int pendingslots=tasks.length-(maxim*cnt);
        int emptyslot=Math.max(0,available-pendingslots);
        return tasks.length+emptyslot;
    }
}
//problem2
class Solution {
    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people,(a,b)->{
            if(a[0]==b[0]){
                return a[1]-b[1];
            }
            return b[0]-a[0];
        });
        List<int[]> ls=new ArrayList<>();
        for(int[] pe:people){
            ls.add(pe[1],pe);
        }
        return ls.toArray(new int[people.length][2]);
    }
}
//problem3
class Solution {
    public List<Integer> partitionLabels(String s) {
        int n=s.length();
        HashMap<Character,Integer> map=new HashMap<>();
        for(int i=0;i<n;i++){
            char ch=s.charAt(i);
            map.put(ch,i);
        }
        List<Integer> ans=new ArrayList<>();
        int st=0,end=0;
        for(int i=0;i<n;i++){
            char c=s.charAt(i);
            end=Math.max(end,map.get(c));
            if(i==end){
                ans.add(end-st+1);
                st=i+1;
            }
        }
        return ans;
    }
}
