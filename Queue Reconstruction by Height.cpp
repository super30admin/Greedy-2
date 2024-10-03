//time: O(n2)
//space: O(1)
class Solution {
public:
    vector<vector<int>> reconstructQueue(vector<vector<int>>& people) {
        sort(people.begin(), people.end(), [](vector<int> &a, vector<int> &b) {
            if (a[0] == b[0])
                return a[1] < b[1];  // Ascending order by second element if first elements are equal
            return a[0] > b[0];         // Descending order by first element
        });
        vector<vector<int>> result;
        for(vector<int> vec : people) {
            result.insert(result.begin() + vec[1], vec);
        }
        return result;
    }
};