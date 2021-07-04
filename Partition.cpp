/*
Intuition: BF: We can get all partitions and check if all characters are in the same partition.

We can optimize this by trackign the ending index of all the characters. We keep expanding the partition based on incoming characters last index.

Time Complexity: O(N), N = Size of array
Space Complexity: O(N)
*/


class Solution {
public:
    vector<int> partitionLabels(string s) {
        map<char, int> map;
        for ( int i = 0; i < s.size(); i++){
            char letter = s[i];
            map[letter]= i;
        }
        
        vector<int> result;
        int start = 0;
        int end = 0;
        for (int i = 0; i < s.size(); i++){
        
            end = max( end, map[s[i]] );
            if ( i == end){
                result.push_back(end - start + 1);
                start = end +1;
            }

        }
        return result;
    }
};