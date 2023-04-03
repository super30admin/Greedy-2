763. Partition Labels

TC O(n)
SC O(1)

class Solution {
public:
    vector<int> partitionLabels(string s) { 
        int size = 0;
        int end = 0;
        vector<int> lastindex(26);
        for(int i=0;i<s.size();i++)
        {
            lastindex[s[i]-'a'] = i;
        }
        vector<int> result;
        for(int i=0;i<s.size();i++)
        {
            size++;
            end = max(end,lastindex[s[i]-'a']);
            if(i==end)
            {
                result.push_back(size);
                size=0;
            }
        }
        return result;
    }
};
