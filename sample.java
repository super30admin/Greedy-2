// Time Complexity :
// Space Complexity :
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach


//Queue Reconstruct from Height
//Time Complexity ->(O(nlogn)+O(n^2)->(O(n2)))
//Space Complexity->(O(n) -> space of arraylist)
class Solution {
    public int[][] reconstructQueue(int[][] people) {

        Arrays.sort(people,(int[] a,int[] b)->{
            if(a[0]==b[0]){
                return a[1] - b[1];
            }
            else{
                return b[0]-a[0];
            }
        });

        List<int[]> q = new ArrayList(); //Basically creatng a array of array,Passing a Integer array into the type of the List
        for(int[] person : people ){
            q.add(person[1],person);  //(int index,int object)
        }

        int[][] result = new int[people.length][2];
        for(int i=0;i<q.size();i++){
            result[i] = q.get(i);
        }


        return result;     
        
    }
}


//Partition labels
//Time Complexity ->(O(n))
//Space Complexity->(O(26) -> constant as s string contains only english letters )
class Solution {
    //Using greedy approach
    public List<Integer> partitionLabels(String s) {
        Map<Character,Integer> map = new HashMap();
        List<Integer> result = new ArrayList();
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
             map.put(ch,i);
        }
        int end = 0;
        int start = 0;
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            
            if(map.containsKey(ch)){
                end = Math.max(end,map.get(ch));
            }
            if(i==end){
                result.add(end-start+1);
                start = i+1;
            }
        }

        return result ;

        
    }
}


//Task Scheduler
//TimeComplexity->O(n) as we wil be needing to go over the tasks array 
//SpaceComplexity->(O(26)->O(1) as hashmap will consist of only english letters)
class Solution {
    public int leastInterval(char[] tasks, int n) {

        int maxFreq = 0;
       int  maxCount =0;
       Map<Character,Integer> map = new HashMap();
        for(Character task : tasks){
             map.put(task,map.getOrDefault(task,0)+1);
             maxFreq = Math.max(maxFreq,map.get(task));
        }
        //Now when we find the task with 
        for(Character task : map.keySet()){
            if(map.get(task)==maxFreq){
                 maxCount++;
            }

        }

        int partitions = maxFreq - 1;
        int available = (n-(maxCount - 1))*partitions;
        int pending = tasks.length - (maxCount*maxFreq);
        int idle = Math.max(0,available - pending);

        return tasks.length + idle;        
    }
}
