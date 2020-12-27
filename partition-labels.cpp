// Time Complexity: O(n) n = S.size()
// Space Complexity: O(1). max size of map is 26 only.
class Solution {
public:
    vector<int> partitionLabels(string S) {
        vector<int> res;
        unordered_map<char, int> map;
        for(int i = 0; i < S.size(); i++) {
            map[S[i]] = i;
        }
        int start = 0; 
        int end = 0;
        for(int i = 0; i < S.size(); i++) {
            end = max(end, map[S[i]]);
            if(i == end) {
                res.push_back(end-start+1);
                start = end+1;
            }
         }
        return res;
    }
};
