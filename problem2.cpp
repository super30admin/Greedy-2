/*
Time complexity: O(n*m)
Space complexity: O(1)
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No
*/

class Solution {
public:
    static bool srt(vector<int>& a, vector<int>& b){
        if(a[0]!=b[0])return a[0]>b[0];
        return a[1]<b[1];
    }
    vector<vector<int>> reconstructQueue(vector<vector<int>>& p) {
        sort(p.begin(), p.end(), srt);
        for(int i=0;i<p.size();i++){
            int j = i;
            while(j!=p[j][1]){
                swap(p[j], p[j-1]);
                j--;
            }
        }
        return p;
    }
};