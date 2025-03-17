// Author: Subhed Chavan
// Batch: December 24
// Problem Statement: Task Scheduler
// Approach: Map and Count
// Time Complexity: O(n)
// Space Complexity: O(1) - 26 Chars

class Solution {
public:
    int leastInterval(vector<char>& tasks, int n) {
        if (tasks.empty()) {
            return 0;
        }
        unordered_map<char, int> freqMap;
        int maxFreq = 0, maxCount = 0;
        
        for (char c : tasks) {
            freqMap[c]++;
            maxFreq = max(maxFreq, freqMap[c]);
        }
        
        for (const auto& pair : freqMap) {
            if (pair.second == maxFreq) {
                maxCount++;
            }
        }
        
        int partitions = maxFreq - 1;
        int empty = partitions * (n - (maxCount - 1));
        int pending = tasks.size() - (maxFreq * maxCount);
        int idle = max(0, empty - pending);
        
        return tasks.size() + idle;
    }
};
