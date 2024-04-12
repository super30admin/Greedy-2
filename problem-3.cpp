// t-c: n
// s-c : 1
class Solution {
public:
    vector<int> partitionLabels(string s) {
        vector<int> lastIdx(26);
        for(int i = 0; i < s.size(); i++){
            lastIdx[s[i] - 'a'] = i;
        }
        int i = 0, j = 0, partition = 0;
        vector<int> result;
        while(i < s.size()){
            partition = lastIdx[s[i] - 'a'];
            j = i + 1;
            while(j < partition && j < s.size()){
                if(lastIdx[s[j] - 'a'] > partition){
                    partition = lastIdx[s[j] - 'a'];
                }
                j++;
            }
            result.push_back(partition - i + 1);
            i = partition + 1;
        }
        return result;
    }
};
