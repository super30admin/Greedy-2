class Solution{
    //Identify max frequency element and calculate the no of idle positions based on that
    //Time Complexity:O(n)
    //Space Complexity: O(n) 
    public int leastInterval(char[] tasks, int n)
    {
        if(n==0) return tasks.length;
        int length = tasks.length;
        int[] arrayDict = new int[26];
        int max = Integer.MIN_VALUE;
        int maxcount = -1;
        for(int i=0;i<tasks.length;i++)
        {
            ++arrayDict[tasks[i]-'A'];
            if(max<arrayDict[tasks[i]-'A'])
            {
                max = arrayDict[tasks[i]-'A'];
            }
        }

        for(int i=0;i<26;i++)
        {
            if(arrayDict[i]==max)
            {
                maxcount++;
            }
        }

        int size = (max-1)*(n+1)+1;
        if(size+maxcount>=length)
        {
            return size+maxcount;
        }
        else{
            return length;
        }

    }
}