// Time complexity: O(n), where n is the number of tasks.
// Space complexity: O(1), since the size of the map is limited to 26 characters.
// Did this code run successfully on LeetCode: Yes

// Approach: 
// 1. Count the frequency of each task using a hash map.
// 2. Find the maximum frequency of any task.
// 3. Count how many tasks have this maximum frequency.
// 4. Calculate the number of parts needed to schedule the tasks.
// 5. Calculate the total number of empty slots needed.
// 6. Return the maximum of the total tasks and the empty slots.

class Solution {
public:
    int leastInterval(vector<char>& tasks, int n) {
        unordered_map<char, int> map;
        for(char c : tasks){
            map[c]++;
        }
        int freqMax = 0;
        for(auto& p : map){
            freqMax = max(freqMax, p.second);
        }
        int maxCount = 0;
        for(auto& p : map){
            if(p.second == freqMax){maxCount++;}
        }

        int partCount = freqMax - 1;
        int partLength = n + 1;
        int empty = partCount * partLength + maxCount;

        return max((int)tasks.size(), empty);
    }
};