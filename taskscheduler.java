//Time Complexity: O(n)
//Space Complexity: O(n)
class Solution {
    public int leastInterval(char[] tasks, int n) {
        if(n==0) return tasks.length;
        
       // Calculate the maximum frequency
        int[] maxFreq = new int[26];
        for(char c : tasks)
        {
            maxFreq[c-'A']++;
        }
        
        // to access the maximum frequency just sort it. also time complexity for sorting 26 size of array is constant.(O(26log26)).
        
        Arrays.sort(maxFreq);
        
        // Calculate the total idle_spaces that can be there
        
        int m = maxFreq[25] - 1; // -1 because we are calculating in between spaces only
        int idleSpaces = m * n;
        
        // fill the idleSpaces
        for(int i = 24;i>=0;i--)
        {
            idleSpaces-=Math.min(m,maxFreq[i]); // Math.min because [A,A,A,B,B,B] if the 2 frequncies are same then one element of other frequncy will obtain a space outside the idlespaces
        }
        
        return idleSpaces<0 ? tasks.length : idleSpaces + tasks.length;
    }
}