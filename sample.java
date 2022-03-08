// Time Complexity :O(N)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :

//Partition Labels
// Your code here along with comments explaining your approach


class Solution {
    public List<Integer> partitionLabels(String s) {
        Map<Character,Integer> map = new HashMap<>();
        for(int i=0;i<s.length();i++)
            map.put(s.charAt(i),i);
        List<Integer> res = new ArrayList<>();
        int prev = -1,max = 0;
        for(int i=0;i<s.length();i++)
        {
            max = Math.max(max,map.get(s.charAt(i)));
            if(max == i)
            {
                res.add(max - prev);
                prev = max;
            }
        }
        return res;
    }
}


//task-scheduler
//Time complexity: O(N)
//space: O(1)

class Solution {
    public int leastInterval(char[] tasks, int n) {
        if (n == 0)
            return tasks.length;
        if (tasks.length == 0)
            return 0;
        // lets create an int array to store the frequency
        int [] freq = new int [26];
        for (char ch: tasks) 
            freq[ch-'A'] += 1;
        // now sort the array to get the most frequenct charcater at the last
        Arrays.sort(freq); // 26 * log(26) => Considered as O(1)
        int maxValue = freq[25] - 1;  // we do -1 as we dont want idle state if we are at the very end;
        int availableIdleSlot = maxValue * n;  // this many idle slot will be avaiable
        for (int i=24; i>=0; i--) {
            // now update the available slot
            availableIdleSlot -= Math.min(freq[i], maxValue);
        }
        return availableIdleSlot > 0 ? availableIdleSlot + tasks.length : tasks.length; 
    }
}




//queue-reconstruction-by-height
//time complexity : TimeO(NLOGN + N^2)
//Space: O(n)

class Solution {
    public int[][] reconstructQueue(int[][] people) {
        
        Arrays.sort(people,new peopleComparator());
        
        List<int[]> result=new ArrayList<int[]>();
        
        for(int[] p:people){
            result.add(p[1],p);
        }
        
        return result.toArray(new int[people.length][2]);
    }
    
    public class peopleComparator implements Comparator<int[]>{
        public int compare(int[] one,int[] two){
            if(one[0]==two[0]) return one[1]-two[1];
            return two[0]-one[0];
        }
    }


