// Time Complexity -> O(n)
// Space Complexity -> O(1) 
// Problems Faced - No!
// It runs on Leetcode!
class Solution {
public:
    int leastInterval(vector<char>& tasks, int n) {
        unordered_map<char, int> map;
        int maxFreq = 0;
        for(char task : tasks){
            int currCount = map[task];
            currCount++;
            maxFreq = max(maxFreq, currCount);
            map[task]++;
        }
        int maxCount = 0;
        for(auto i : map){
            if(i.second == maxFreq)
                maxCount++;
        }
        int tSize = tasks.size();
        int partitions = maxFreq - 1;
        int availableSlots = partitions*(n - (maxCount - 1));
        int pending = tSize - (maxFreq*maxCount);
        int idle = max(0, availableSlots - pending);
        int answer = tSize + idle;
        return answer;
    }
};