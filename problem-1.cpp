// https://leetcode.com/problems/task-scheduler/description/
// Test Complexity: O(n)
// Space Complexity: O(1)

class Solution {
    public:
        int leastInterval(vector<char>& tasks, int n) {
            unordered_map<char,int> mp;
            int maxFreq=0;
            for(auto i:tasks){
                mp[i]++;
                maxFreq = max(maxFreq, mp[i]);
            }
            int maxCount=0;
            for(auto i:mp){
                if(i.second == maxFreq) maxCount++;
            }
            int partitions = maxFreq-1;
            int available = partitions*(n-(maxCount-1));
            int pending = tasks.size() - maxFreq*maxCount;
            int idle = max(0, available-pending);
            return idle+tasks.size();
        }
    };