#include<iostream>
#include<bits/stdc++.h>
#include<vector>
using namespace std;
/*
We first map every character to its index value using a hashmap
Then we take a result vector and take a start and an end variable to track each character
and push the index into the result and finally we return the result
*/
class Solution{
public:
    vector<int> partitionLabels(string s){
        unordered_map<char, int> map;
        for(int i = 0; i < s.length(); i++){
            map[s[i]] = i;
        }    
        vector<int> result;
        int start = 0, end = 0;

        for(int i = 0;i < s.length(); i++){
            end = max(end, map[s[i]]);

            if(i == end){
                result.push_back(end - start + 1);
                start = i + 1;
            }
        }
        return result;
    }
};
