// Time Complexity : O(N)(N is the total number of tasks)
// Space Complexity : O(1)(as we will keep 26 elements)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
public:
    int leastInterval(vector<char>& tasks, int n) {
        vector<int> frequencies(26);
        for(int i:tasks){
            frequencies[i-'A']++;
        }
        sort(frequencies.begin(), frequencies.end());
        int f_max = frequencies[25];
        int idle_time = (f_max-1)*n;
        for(int i=frequencies.size()-2;i>=0 && idle_time>0;i--){
            idle_time = idle_time - min(f_max-1, frequencies[i]);
        }
        idle_time = max(0,idle_time);
        
        return idle_time+tasks.size();
    }
};
