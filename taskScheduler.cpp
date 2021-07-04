// Time Complexity :O(n) for hashmap
// Space Complexity : O(1)  
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
public:
    int leastInterval(vector<char>& tasks, int n) {
        unordered_map<char,int> hMap;
        int maxFreq = INT_MIN;
        for(auto c: tasks){
            hMap[c]++;
            maxFreq = max(maxFreq,hMap[c]);
        }
        int maxCount = 0;
        for(auto c : hMap){
            if(c.second == maxFreq) maxCount++;
        }
        int partition = maxFreq - 1;
        int available = (n-maxCount+1)*partition;
        int pending = tasks.size() - (maxCount*maxFreq);
        int idle = max(0,available - pending);
        return idle + tasks.size();
    }
};