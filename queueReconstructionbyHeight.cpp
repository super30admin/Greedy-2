#include<iostream>
#include<bits/stdc++.h>
#include<vector>
using namespace std;
/*
First, we sort the people by height in descending order, and if heights match, by the number of taller or equal people they expect ahead (in ascending order).
Then we insert each person at the index equal to how many taller or equal people should be in front of them.
Since taller people are already placed, inserting at that index ensures everyone sees exactly the number of taller or equal people they expected.
*/
class Solution{
public:
    vector<vector<int>> reconstructQueue(vector<vector<int>>& people){
        sort(people.begin(), people.end(), [](vector<int>& a, vector<int>& b){
            if(a[0] == b[0]){
                return a[1] < b[1];
            }
            return a[0] > b[0];
        });

        vector<vector<int>> result;
        for(auto& p : people){
            result.insert(result.begin() + p[1], p);
        }
        return result; 
    }
};
