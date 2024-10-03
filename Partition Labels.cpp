//time: O(n)
//space: O(1)
class Solution {
public:
    vector<int> partitionLabels(string s) {
        int start = 0, end = 0;
        vector<int> result;
        unordered_map<char,int> umap;
        for(int i = 0; i < s.length(); i++) {
            umap[s[i]] = i;
        }
        for(int i = 0; i < s.length(); i++) {
            end = max(end, umap[s[i]]);
            if(end == s.length()-1) {
                result.push_back(end - start + 1);
                break;
            }
            if(i == end) {
                result.push_back(end - start + 1);
                start = i + 1;
                end = start;
            }
        }
        return result;
    }
};