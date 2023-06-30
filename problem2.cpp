// Time Complexity : O(n^2)  ==>actual nlogn + n^2
// Space Complexity : O(1) (not considering the output array)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach

// Intuition: we need to arrange them based on short heights to put them in correct order.
// inorder to do that we choose to sort them based on heights(decreasing) and if heights are equal, then sort based on k values(increasing)
// After that we maintain result array and if k is not present as an index in the result, we add that [h,k] at last. else we 
// insert [h,k] at the particular index=k .


class Solution {
public:
    vector<vector<int>> reconstructQueue(vector<vector<int>>& people) {
        int n = people.size();
        sort(people.begin(),people.end(),[&](auto const &a,auto const &b){
            if(a[0]!=b[0]) return a[0]>b[0];
            return a[1]<b[1];
        });
        vector<vector<int>>result;
        for(auto& v: people){
            int idx = v[1];
            if(result.size()<=idx){
                result.push_back(v);
            }
            else{
                result.insert(result.begin()+idx,v);
            }
        }
        return result;
    }
};