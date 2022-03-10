/**
 * @Time Complexity:
 * O(N) where N is the size of the string
 * 
 */

/**
 * @Space Complexity:
 * O(1)
 * 
 */

//The code ran perfectly on leetcode


class Solution {
public:
    vector<int> partitionLabels(string s) {
        vector<int> result;
        
        if(s.size()==0 || s.empty()) return result;
        
        unordered_map<char, int> store;
        for(int i = 0; i<s.size(); i++){
            store[s[i]] = i;
        }
        
        int start = 0;
        int windowEnd = 0;
        for(int i = 0; i<s.size(); i++){
            char c = s[i];
            windowEnd = max(windowEnd, store[c]);
            if(i == windowEnd){
                result.push_back(windowEnd - start +1);
                start = i+1;
            }
        }
        return result;
    }
};