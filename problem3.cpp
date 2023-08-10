/*
// Time Complexity : O(N)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
arrange the height in descending order , if same height tham use second value must be less than the compared
Then add the values to the queue by the index provided by the second value
*/

#include<iostream>
#include<vector>
#include<queue>

using namespace std;

class Solution {
    void display(vector<vector<int>>& res){
        for(auto& vec:res){
            cout<<"[ "<<vec.at(0)<<" , "<<vec.at(1)<<" ] ";
        }
        cout<<endl;
    }
public:
    vector<vector<int>> reconstructQueue(vector<vector<int>>& people) {
        sort(begin(people),end(people),[](const auto& lhs,const auto& rhs){
            if(lhs.at(0)>rhs.at(0)){
                return true;
            }
            else if(lhs.at(0) == rhs.at(0)){
                return lhs.at(1)<rhs.at(1);
            }
            return false;
        });
        //display(people);
        vector<vector<int>> res{};
        for(auto& vec:people){
            if(vec.at(1)>res.size()){
                res.push_back(vec);
            }
            else{
                res.insert(res.begin()+vec.at(1),vec);
            }
        }
        return res;
    }
};