//Time - O(n)
//Space - O(1)

class Solution {
public:
    vector<int> partitionLabels(string S) {
        unordered_map<char,int> mp;
        
        for(int i=0;i<S.size();i++){
            mp[S[i]] = i;
        }
        vector<int> ans;
        
        int i = 0;
        while(i<S.size()){
            int start = i;
            int end = mp[S[i]];
            
            while(i<end){
                end = max(end,mp[S[i]]);
                i++;
            }
            
            ans.push_back(end-start+1);
            i++;
        }
        
        return ans;
    }
};