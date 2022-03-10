/**
 * @Time Complexity:
 * O(N^2)
 * 
 */

/**
 * @Space Complexity:
 * O(N)
 * 
 */

//The code ran perfectly on leetcode


class Solution {
public:
    vector<vector<int>> reconstructQueue(vector<vector<int>>& people) {
        sort(people.begin(), people.end(), [](vector<int>& a, vector<int>& b) {
            return a[0] > b[0] || (a[0] == b[0] && a[1] < b[1]);
        });
        vector<vector<int>> q;
        for(auto person: people){
            q.insert(q.begin() + person[1], person);
        }
        return q;
        
    }
};