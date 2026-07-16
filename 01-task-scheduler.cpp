/*
TC - O(N) - performed linear scans only
SC - O(26) i.e. O(1) - used extra space to hold constant freq counts for lowercase alphaeb
Issues Faced - that idle slots logic does make sense, but I often forget to account for more than one character having max frequency .. need to be more careful
Solved on LeetCode - Yes


*/




class Solution {
    public:
        int leastInterval(vector<char>& tasks, int n) {
            int freq_table[26] = {0};
    
            int totalTasks = tasks.size();
    
            int maxFreq = INT_MIN;
    
            for (char c: tasks) {
                freq_table[c - 'A'] += 1;
                maxFreq = max(maxFreq, freq_table[c - 'A']);
            }
    
            int maxFreqCount = 0;
            for (int i = 0; i < 26; i++) {
                if (freq_table[i] == maxFreq) {
                    maxFreqCount++;
                }
            }
    
            int idle_slots = (maxFreq - 1) * (n - (maxFreqCount - 1));
    
            idle_slots = idle_slots - (totalTasks - (maxFreq*maxFreqCount));
            if (idle_slots < 0) idle_slots = 0;
    
            return totalTasks + idle_slots; 
            
        }
    };
