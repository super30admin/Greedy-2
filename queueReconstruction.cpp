// Time Complexity -> O(n^2)
// Space Complexity -> O(n) for the answer vector, although it is an auxiliary data structure.
// Problems Faced - No!
// It runs on Leetcode!
class Solution {
    static bool comp(vector<int> v1, vector<int> v2){
        if(v1[0] == v2[0])
            return v1[1] < v2[1];
        return v1[0] > v2[0];
    }
public:
    vector<vector<int>> reconstructQueue(vector<vector<int>>& people) {
        vector<vector<int>> answer;
        sort(people.begin(), people.end(), comp);
        for(vector<int> p : people){
            vector<vector<int>>:: iterator it = answer.begin() + p[1];
            answer.insert(it, p);
        }
        return answer;
    }
};