// Time Complexity : O(N^2)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : No.
// Any problem you faced while coding this : Unable to write in c++ correctly

class Solution {
public:
    vector<vector<int>> reconstructQueue(vector<vector<int>>& people) {
        // if(people.size()==NULL){
        //     return {{}};
        // }
        sort(people.begin(),people.end(),[](const vector<int>& a, const vector<int>& b){
            if(a[0]==b[0]){
                return a[1]-b[1];
            }
            return b[0]-a[0];
        });
        vector<vector<int>> q;
        for(vector<int> person : people){
            q.push_back().push_back(person[1], person);
        }
        return q;
    }
};
