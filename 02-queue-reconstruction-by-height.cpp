/*
TC - O(N^2) - performed sorting operation O(NlogN), but insertion can be quadratic worst case.
SC - O(n) - used extra space to hold sorted person objects
Issues Faced - need to be clear about why we sort like this - it is because without the greedy approach, we would overwrite entries for previously placed people
Solved on LeetCode - Yes


*/


class Solution {
    public:
        vector<vector<int>> reconstructQueue(vector<vector<int>>& source) {
    
            std::vector<std::pair<int, int>> target;
            target.reserve(source.size()); 
    
            for (const auto &vec : source) {
                if (vec.size() == 2) {
                    target.emplace_back(vec[0], vec[1]);
                }
            }
    
            // 2. Sort: Descending by 2nd element, Ascending by 1st element on ties
            std::sort(target.begin(), target.end(), [](const auto& a, const auto& b) {
                if (a.first != b.first) {
                    return a.first > b.first; // Primary sort: Descending heights
                }
                return a.second < b.second; // Tie-breaker: Ascending number of people ahead of you (to really put the tallest first)
            });
    
            vector<vector<int>> result;
            for (const auto& person : target) {
                int height = person.first;
                int count = person.second;
                
                // Greedily insert directly at the position dictated by 'count'
                result.insert(result.begin() + count, {height, count});
            }
            return result;
    
            
        }
    };
