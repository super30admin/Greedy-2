/**
 * @Time Complexity:
 * O(N) where n is the size of the given vector.
 * We are building a hash map so we are iterating
 * through the given array.
 */

/**
 * @Space Complexity:
 * O(1) becasue we are creating the map of only 26 
 * character in worst case.
 */


//The code ran perfectly on leetcode

class Solution {
public:
    int leastInterval(vector<char>& tasks, int n) {
        if(n==0) return (int)tasks.size();
        unordered_map<char, int> store;
        int mFreq =0, tSize = 0;
        for(auto task: tasks){
            store[task]++;
            mFreq = max(mFreq, store[task]);
        }
        
        for(auto it: store ){
            if(it.second == mFreq)
            tSize++;
        }
            
        int part = mFreq -1;
        int avail = part*(n-(tSize-1));
        int pending = tasks.size() - (mFreq*tSize);
        int idle = max(0, avail - pending);
        
        return tasks.size() + idle;
    }
};