// Time Complexity : O(n) as we are travelling throught the array only once
// Space Complexity : O(1) 
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : no issues as of now.. Learning


bool sortcol(const vector<int> &v1, const vector<int> &v2){
    if(v1[0]==v2[0]){
        return v1[1] < v2[1];
    }else{
        return v1[0]>v2[0];
    }
}

class Solution {
public:
    vector<vector<int>> reconstructQueue(vector<vector<int>>& people) {
        vector<vector<int>> result;
       //edge
        if(people.size()==0)
            return result;
        
        //logic
        sort(people.begin(), people.end(), sortcol);
        int size = people.size();
   
        for(int i=0; i<size; i++){
            result.insert(result.begin()+people[i][1], people[i]);
            
            cout<<people[i][1]<<endl;
        }
        return result;
    }
};