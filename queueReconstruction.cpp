// Time Complexity :O(nlogn) where n in the number elements in the vector
// Space Complexity : O(1)  
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

bool mycompare(vector<int> a,vector<int> b){
        if(a[0] == b[0]) return a[1] < b[1];
        return a[0] > b[0];
    }
class Solution {
public:
    vector<vector<int>> reconstructQueue(vector<vector<int>>& people) {
        sort(people.begin(),people.end(),mycompare);
        vector<vector<int>> ans;
        ans.push_back(people[0]);
        for(int i = 1;i < people.size();i++){
            ans.insert(ans.begin()+people[i][1],people[i]);
        }
        return ans;
    }
};