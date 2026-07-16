/*
TC - O(n) - two linear passes only
SC - O(n) - used extra space to hold rightmost positions
Issues Faced - fairly intuitive, but need to remember two-pass is just one of several greedy string approaches
Solved on LeetCode - Yes


*/



class Solution {
    public:
        
        vector<int> partitionLabels(string s) {
    
    
    
            int posFromRight[26];
            std::fill(std::begin(posFromRight), std::end(posFromRight), -1);
      
    
            for (int i = s.size() - 1 ; i >= 0 ; i--) {
                int currVal = s[i] - 'a';
                if (posFromRight[currVal] == -1) {
                    posFromRight[currVal] = i;
                    // cout<<"rightmost pos of "<<s[i]<<" is "<<posFromRight[currVal]<<"\n";
                }
            }
    
            int horizon = INT_MIN;
            int lastEnd = 0;
            vector<int> res;
    
            for (int i = 0 ; i < s.size() ; i++) {
                int currVal = s[i] - 'a';
                // cout<<"s[i] = "<<s[i]<<"\n";
                int rightPos = posFromRight[currVal];
    
                horizon = max(horizon, rightPos);
    
                if (i == horizon) {
                    res.push_back(i - lastEnd + 1);
                    lastEnd = i + 1;
                }
    
                // cout<<"horizon is now = "<<horizon<<" for s[i] = "<<s[i]<<"\n";
            }
    
            return res;
            
        }
    };
