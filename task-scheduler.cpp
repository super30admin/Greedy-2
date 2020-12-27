// Time Complexity: O(tasks.size())
// Space Complexity: O(1) max size of map is 26 (upper-case English letters)
class Solution {
public:
    int leastInterval(vector<char>& tasks, int n) {
        int maxFreq = 0;
        unordered_map<char, int> map;
        for(char c : tasks) {
            map[c]++;
            maxFreq = max(maxFreq, map[c]);
        }
        int maxCount = 0;
        for(auto it : map) {
            if(it.second == maxFreq)
                maxCount++;
        }
        
        int partitions = maxFreq-1;
        int empty = partitions * (n-maxCount+1);
        int pendingTasks = tasks.size() - (maxFreq*maxCount);
        int idle = max(0, empty - pendingTasks);
        return tasks.size() + idle;
    }
};
