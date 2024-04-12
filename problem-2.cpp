// t-c: n^2
// s-c: 1
class Solution {
public:
    vector<vector<int>> reconstructQueue(vector<vector<int>>& people) {
        sort(people.begin(), people.end(), cmp);
        vector<vector<int>> result;
        for(int i = 0; i < people.size(); i++){
            result.insert(result.begin() + people[i][1], people[i]);
        }
        return result;
    }
    static bool cmp(vector<int> c1, vector<int> c2){
        if(c1[0] != c2[0]){
            return c1[0] > c2[0];
        }
        return c1[1] < c2[];
    }
};
