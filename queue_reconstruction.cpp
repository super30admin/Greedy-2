//Time Complexity-O(n^2)
//Space Complexity-O(1)
//Did the code execute on Leetcode? Yes

class Solution {
public:
     static bool cmp(vector<int>a,vector<int>b)
    {
       if(a[0]!=b[0])
       {
           return a[0]>b[0];
       }
        else
        {
            return a[1]<b[1];    
        }
    }
    
    vector<vector<int>> reconstructQueue(vector<vector<int>>& people) {
        vector<vector<int>>res;
        if(people.size()==0)
        {
            return res;
        }
        sort(people.begin(),people.end(),cmp);
        for(int i=0;i<people.size();i++)
        {
            res.insert(res.begin()+people[i][1],people[i]);
        }
        return res;
    }
};