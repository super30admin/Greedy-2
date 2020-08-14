// Time Complexity : O(n)
// Space Complexity : O(1)
// Any problem you faced while coding this :
// Your code here along with comments explaining your approach
//1. Create a hashmap containing end position for each character
//2. Traverse through the string to find the max window containing all the characters
//3. When the string is over return the result
class Solution {
public:
    vector<int> partitionLabels(string S) {
        vector<int> result;
        //edge
        if(S.length()==0)
            return result;
        
        unordered_map<char,int> end_point_char_map;
        int len = S.length();
        for(int i=0;i<len; i++){
            end_point_char_map[S[i]] =i;
        }
        
        int start = 0;
        int end = end_point_char_map[S[0]];
        
        for(int i=0;i<len; i++){
            end = max(end, end_point_char_map[S[i]]);
            
            if(i==end){
                int window = end-start+1;
                result.push_back(window);
                start = i+1;
            }
            
        }
        return result;
    }
};
