// Time Complexity : O(n^2) // Insertion of an element in a vector requires o(n) time and repeat it for n elements
// Space Complexity : O(1)
// Any problem you faced while coding this :

//Understand creation of the result after sorting is a bit tricky;
//work on it
// Your code here along with comments explaining your approach
//1. Sort firt wrt height then wrt to the the number of members infront
//2. Arrange the result wrt to the indexes ("TRickiest part to understand")
//3. Return the result

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
        // for(int i=0; i<size; i++){
        //     cout<<people[i][0]<<" "<<people[i][1]<<"\t";
        // }
        // cout<<"\n";
        for(int i=0; i<size; i++){
            result.insert(result.begin()+people[i][1], people[i]);
        }
        return result;
    }
};
