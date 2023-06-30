// Time Complexity : O(m) ,m = tasks.size()
// Space Complexity :O(1) (because map has only 26 characters, we are not considering it)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach

// Approach: Greedy
// we try to start the server with maxFreq work because that leads us to min answer possible.
// we find the no. of characters having maxFreq.
// simple intutition is: given some tasks, we need to do all the tasks, so we require a minimum of ans = all tasks==>task.size().
// now based on n value , we might have some gaps in between, if there are no gaps, answer would be tasks.size(), and 
// if there are gaps, we add them to tasks.size().
// Rest is mathematics.

class Solution {
public:
    int leastInterval(vector<char>& tasks, int n) {
        int m = tasks.size();
        unordered_map<char,int>map;
        int maxFreq = 0,maxCount = 0;
        for(int i = 0;i<m;i++)
        {
            char c = tasks[i];
            map[c]++;
            if(maxFreq<map[c]){
                maxFreq = map[c];
            }  
        }
        for(auto& p:map){
            if(p.second==maxFreq){
                maxCount++;
            }
        }
        int slots = maxFreq - 1;
        int total = tasks.size();
        int gaps = slots * (n - (maxCount-1));
        int Remaining = total - (maxFreq*maxCount);
        int idle = gaps - Remaining;
        idle = max(0,idle);
        return tasks.size()+idle;
    }
};