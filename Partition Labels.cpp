// Time Complexity: O(n)
// Space Complexity: O(1)
// Did this code run successfully on LeetCode: Yes

// Approach:
// 1. Create a hash map to store the last occurrence of each character.
// 2. Iterate through the string and update the end index for each character.
// 3. If the current index is equal to the end index, it means we have found a partition.
// 4. Push the size of the partition into the result vector.
// 5. Update the start index to the next character after the end index.
// 6. Return the result vector.

class Solution {
public:
    vector<int> partitionLabels(string s) {
        vector<int> result;
        unordered_map<char, int> map;
        for(int i = 0; i < s.size(); i++){
            map[s[i]] = i; 
        }
        int start = 0, end = 0;
        for(int i = 0; i < s.size(); i++){
            end = max(end, map[s[i]]);
            if(i == end){
                result.push_back(end - start + 1);
                start = end + 1;
            }
        }
        return result;
    }
};