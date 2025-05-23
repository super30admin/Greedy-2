// Time Complexity: O(n^2)
// Space Complexity: O(n)
// Did this code run successfully on LeetCode: Yes

// Approach:
// 1. Sort the people in descending order of height and ascending order of k.
// 2. Initialize an empty result vector.
// 3. For each person in the sorted list, insert them into the result vector at the index specified by k.
// 4. Return the result vector.

class Solution {
public:
    vector<vector<int>> reconstructQueue(vector<vector<int>>& people) {
        //sorting people tallest to shortest
        sort(people.begin(), people.end(), [](const vector<int>& a, const vector<int>& b){
            return (a[0] > b[0]) || (a[0] == b[0] && a[1] < b[1]);
        });
        vector<vector<int>> result;
        for(auto& person : people){
            result.insert(result.begin() + person[1], person);
        }
        return result;
    }
};