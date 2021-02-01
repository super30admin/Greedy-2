// Time Complexity : O(N)
// Space Complexity : O(1) as there can be a maximum of 26 characters
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
public:
    vector<int> partitionLabels(string S) {
        if(S.length()==0){
            return {};
        }
        unordered_map<char,int> map;
        for(int i=0;i<S.length();i++){
            if(map.find(S[i])==map.end()){
                map.insert(pair<char,int>(S[i],i));
            }
            else{
                map[S[i]] = i;
            }
        }
        int start=0, end=0;
        vector<int>result;
        for(int i=0;i<S.length();i++){
            end = max(end, map[S[i]]);
            if(i==end){
                result.push_back(end-start+1);
                start = i+1;
            }
        }
        return result;
    }
};
