// Time Complexity : O(n)
// Space Complexity :  O(n)
// Did this code successfully run on Leetcode : Almost. Complete 61/71 tests.
// Any problem you faced while coding this : Issue comes when empty slots are full and additional slots needed at end

class Solution {
public:
    int leastInterval(vector<char>& tasks, int n) {
        
        int i;
        
        map<char, int> freq_map;
        
        if(n == 0)
            return tasks.size();
        
        
        // Add the tasks in Frequency Map to know the number of occurrences
        for(i = 0; i < tasks.size(); i++)
        {
            if(freq_map.find(tasks[i]) != freq_map.end())
                freq_map[tasks[i]] += 1;
            else
                freq_map.insert({tasks[i],1});
        }
        
        int max_val = -1;
        int max_count = 0;
        
        map<char, int>::iterator itr;

        // Find maximum frequency and number of such tasks        
        for(itr = freq_map.begin(); itr != freq_map.end(); itr++)
        {
            if(itr->second > max_val)
            {
                max_val = itr->second;
                max_count = 1;
            }
            else if(itr->second == max_val)
                max_count += 1;
        }
        
        // Max Frequency dictats the number of units of time required
        int final_val = ((n+1)*(max_val-1)) + max_count;
        
        return final_val;
    }
};
