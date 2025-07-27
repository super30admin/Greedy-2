// Approach:
// Sort the people in descending order of height, and for those with the same height, in ascending order of the number of people in front (k). 
// Then, insert each person at the index equal to their k value in the result list, which ensures the queue is reconstructed correctly.

// Time Complexity (TC): O(N^2) in the worst case due to insertions into a vector (N insertions with O(N) shift each).
// Space Complexity (SC): O(N) for storing the result queue.

class Solution {
public:
    vector<vector<int>> reconstructQueue(vector<vector<int>>& people) {
        sort(people.begin(), people.end(),
             [](const vector<int>& a, const vector<int>& b) {
                 return a[0] != b[0] ? a[0] > b[0] : b[1] > a[1];
             });
        vector<vector<int>> res;
        for (vector<int> v : people) {
            res.insert(res.begin() + v[1], v);
        }
        return res;
    }
};
