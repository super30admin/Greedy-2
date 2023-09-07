//Problem 1 Task Scheduler
// Time Complexity : O(2n)
// Space Complexity : O(26)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :no


// Your code here along with comments explaining your approach
//Find the task with max frequency and how many tasks have maximum freq. then take idles and total task length. return addtion of both.
class Solution {
    //O(2n) O(26)
    public int leastInterval(char[] tasks, int n) {
        HashMap<Character, Integer> map= new HashMap<>();
        int maxFreq=0;
        for(char task: tasks){ //O(26)
            map.put(task, map.getOrDefault(task,0)+1);
            maxFreq=Math.max(maxFreq, map.get(task));
        }
        int maxCount=0;
        for(char c: map.keySet()){
            if(map.get(c)==maxFreq) 
                maxCount++;
        }

        int partitions= maxFreq-1;
        int availableSlots= (n-(maxCount-1))*partitions;
        int pending=tasks.length-(maxCount*maxFreq);
        int idle=Math.max(0, availableSlots-pending);

        return tasks.length+idle;

    }
}


//Problem 2 Queue reconstruction by height
// Time Complexity :O(n^2 + logn + n)
// Space Complexity : O(n) (space taken by list)
// Did this code successfully run on Leetcode : yes 
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach
//sort the queue based on height first and then based on number of people ahead with equal or greater height.
class Solution {
    //O(n^2 logn n) O(n)->but could have been 1
    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, (a,b)->{ //O(nlogn)
            if(a[0]==b[0]){
                return a[1]-b[1];
            }
            return b[0]-a[0];
        });
        int[][] res=new int[people.length][2];
        List<int[]> q= new ArrayList<>();
        for(int[] pers: people){//O(n)
            q.add(pers[1], pers);//O(n)
        }

        for(int i=0;i<people.length;i++){ //O(n)
            res[i]=q.get(i);
        }
        return res;
    }
}


//Problem 3 Partition labels
// Time Complexity :O(2n)
// Space Complexity :O(26)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :no


// Your code here along with comments explaining your approach
//for every single character, check last occurrence of that character. then keep an end pointer, and in a for loop increase end pointer if the current character last occurrence is more than end.
class Solution {
    //O(2n) O(26)
    public List<Integer> partitionLabels(String s) {
        int[] last = new int[26];
        List<Integer> res= new ArrayList<>();
        for(int i=0;i<s.length();i++){ //O(26)
            last[s.charAt(i) - 'a'] = i;
        }
        int start=0,end=0;
        
        for(int i=0;i<s.length();i++){ //O(26)
            char c=s.charAt(i);
            end=Math.max(end,last[c-'a']); //extend end if cur end index is beyond extends
            if(i==end){
                res.add(end-start+1);
                start=i+1;
            }
        }
        return res;
    }
}