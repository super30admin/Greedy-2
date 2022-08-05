//141.763.Partition Labels
// Time Complexity :o(n);
// Space Complexity :o(n); for map that we are maintaining
// Did this code successfully run on Leetcode :Y;
// Any problem you faced while coding this :N;

class Solution {
    public List<Integer> partitionLabels(String s) {
        HashMap<Character, Integer> map =new HashMap<>();
        ArrayList<Integer> res=new ArrayList<>();
        
        for(int i=0;i<s.length();i++)
        {
            char c=s.charAt(i);
            
            map.put(c,i);
        }
        int start=0;
        int end=0;
        for(int i=0;i<s.length();i++)
        {
            char c=s.charAt(i);
            int endofc=map.get(c);
            end=Math.max(end, endofc);
            
            if(i==end)
            {
                int cou=end-start+1;
                res.add(cou);
                start=i+1;
            }
            
        }
        return res;
    }
}


//*****621. TASK SCHEDULER****
// Time Complexity :o(n);
// Space Complexity :o(n); for map that we are maintaining
// Did this code successfully run on Leetcode :Y;
// Any problem you faced while coding this :N;

class Solution {
    public int leastInterval(char[] tasks, int n) {
        HashMap<Character, Integer> map=new HashMap<>();
        int maxfreq=0;
        int maxcount=0;
        
        //Getting the maxfreq and putting everything into the map;
        for(char task: tasks)
        {
            //Getting the count
            int count= map.getOrDefault(task, 0);
            count++;
            maxfreq=Math.max(maxfreq, count);
            map.put(task, map.getOrDefault(task,0)+1);
        }
        
        //getting the count of elements that have max freq
        for(char key: map.keySet())
        {
            if(map.get(key)==maxfreq)
            {
                maxcount++;
            }
        }
        
        //Applying all formulas
        int partition =maxfreq-1;
        int avaiable= partition*(n-(maxcount-1));
        int pending=tasks.length-(maxfreq*maxcount);
        int idle=Math.max(0,avaiable-pending);
        
        return tasks.length+idle;
    }
}

// Your code here along with comments explaining your approach
