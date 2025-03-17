// Author: Subhed Chavan
// Batch: December 24
// Problem Statement: Queue Reconstruction by Height
// Approach: Greedy and using Queue
// Time Complexity: O(n^2)
// Space Complexity: O(n)

class Solution {
public:
    vector<vector<int>> reconstructQueue(vector<vector<int>>& people) {
        // Base Case
        if (people.empty()) {
            return {};
        }
        
        // Sort
        sort(people.begin(), people.end(), [](const vector<int>& a, const vector<int>& b) {
            if (a[0] == b[0]) {
                return a[1] < b[1];
            }
            return a[0] > b[0];
        });
        
        vector<vector<int>> q;
        for (const auto& person : people) {
            q.insert(q.begin() + person[1], person);
        }
        
        return q;
    }
};