//Time Complexity-O(n)-->2 pass algorithm
//Space Complexity-O(1)
//Did the code run on Leetcode? Yes


class Solution {
public:
    vector<int> partitionLabels(string S) {
        vector<int>res={};
        if(S.length()==0)
        {
           return res;
        }
        unordered_map<char,int>m;
        for(int i=0;i<S.length();i++)
        {
            m[S[i]]=i;
        }
        int high=m[S[0]];
        int low=0;
        for(int i=0;i<S.length();i++)
        {
            if(m[S[i]]>high)
            {
                high=m[S[i]];
            }
            if(i==high)
            {
                res.push_back(high-low+1);     
                low=i+1;
            }
        }
        return res;
    }
};