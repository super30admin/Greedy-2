// Author: Subhed Chavan
// Batch: December 24
// Problem Statement: Partition Label
// Time Complexity: O(n)
// Space Complexity: O(1)

class Solution {
    public:
        vector<int> partitionLabels(string s) {
            
            // Base Case
            if (s.empty()) {
                return {};
            }
    
            vector<int> result;
            unordered_map<char, int> map;
            int start = 0, end = 0;
    
            for (int i = 0; i < s.length(); i++) {
                map[s[i]] = i;
            }
    
            for (int i = 0; i < s.length(); i++) {
                end = max(end, map[s[i]]);
                if (i == end) {
                    result.push_back(end - start +
                                     1); 
                    start = end + 1;     
                }
            }
    
            return result;
        }
    };
    