//
// Created by shazm on 9/17/2019.
//

#include <algorithm>
#include <algorithm>
#include <vector>
#include <string>

using namespace std;

class Solution {
public:
    vector<int> partitionLabels(string S) {
        int last[26];
        for(int x = 0; x<S.size(); x++){
            last[S[x]-'a'] = x;
        }
        int j = 0; int anchor = 0;
        vector<int> retVec;
        for(int x = 0; x<S.size(); x++){
            j = max(j, last[S[x]-'a']);
            if(x==j){
                retVec.push_back(x - anchor + 1);
                anchor = x+1;
            }
        }
        return retVec;
    }
};