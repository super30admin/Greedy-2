// Time Complexity: O(n^2) n = size of people
// Space Complexity: O(1)
class Solution {
public:
    vector<vector<int>> reconstructQueue(vector<vector<int>>& people) {
        vector<vector<int>> res;
        auto cmp = [] (const vector<int>& p1, const vector<int>& p2) {
            return p1[0] > p2[0] || (p1[0] == p2[0] && p1[1] < p2[1]);
        };
        sort(people.begin(), people.end(), cmp);
        for(int i = 0; i < people.size(); i++) {
            if(people[i][1] == res.size()) {
                res.push_back(people[i]);
            } else {
               res.insert(res.begin() + people[i][1], people[i]); 
            }
        }
        return res;
    }
};
