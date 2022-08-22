// Time Complexity -> O(n)
// Space Complexity -> O(1) 
// Problems Faced - No!
// It runs on Leetcode!
class Solution {
public:
    vector<int> partitionLabels(string s) {
        unordered_map<char, int> map;
        vector<int> answer;
        int l = s.size();
        for(int i = 0; i < l; i++){
            char c = s[i];
            map[c] = i;
        }
        int start = 0; int end = 0;
        for(int i = 0; i < l; i++){
            char c = s[i];
            end = max(end, map[c]);
            if(i == end){
                int subStrLen = end - start + 1;
                answer.push_back(subStrLen);
                start = end + 1;
            }
        }
        return answer;
    }
};