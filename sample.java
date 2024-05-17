// Problem1 Task Scheduler (https://leetcode.com/problems/task-scheduler/)

// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes

class Solution {
    public int leastInterval(char[] tasks, int n) {
        HashMap<Character,Integer> map=new HashMap<>();
        int max=0;
        for(int i=0;i<tasks.length;i++)
        {
            map.put(tasks[i],map.getOrDefault(tasks[i],0)+1);
            max=Math.max(max,map.get(tasks[i]));
        }
        int max_count=0;
        for(int count:map.values())
        {
            if(count==max)
                max_count++;
        }
        int partitions=max-1;
        int available=partitions*(n-(max_count-1));
        int pending_tasks=tasks.length-(max*max_count);
        int empty= Math.max(0,available-pending_tasks);
        return (tasks.length+empty);
    }
}

// Problem2 Queue Reconstruction by Height (https://leetcode.com/problems/queue-reconstruction-by-height/)

// Time Complexity : O(n^2)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes

class Solution {
    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, (a,b) ->{
            if(a[0]==b[0]){
                return a[1]-b[1];
        }
        return b[0]-a[0];
        });
        List<int[]> li=new ArrayList<>();
        for(int person[]:people)
        {
            li.add(person[1],person);
        }
        int[][]res =new int[people.length][2];
        for(int i=0;i<li.size();i++)
        {
            res[i]=li.get(i);
        }
        return res;
        
    }
}

// Problem3 Partition Labels (https://leetcode.com/problems/partition-labels/)

// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes


class Solution {
    public List<Integer> partitionLabels(String s) {
        ArrayList<Integer> res=new ArrayList<>();
        HashMap<Character,Integer> map=new HashMap<>();
        for(int i=0;i<s.length();i++)
        {
            map.put(s.charAt(i),i);
        }
        int start=0;
        int end=0;
        for(int i=0;i<s.length();i++)
        {
            end=Math.max(end,map.get(s.charAt(i)));
            if(i==end)
            {
                res.add(end-start+1);
                start=i+1;
            }
        }
        return res; 
    }
}

