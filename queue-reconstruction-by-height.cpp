//Time - O(n^2)
//Space - O(1)


class Solution {
public:
    
    bool static sortCompare(vector<int> & a, vector<int>& b){
        if(a[0]>b[0]) return true;
        else if(a[0]==b[0]){
            return a[1]<b[1];
        }
        return false;
    }

    

    vector<vector<int>> reconstructQueue(vector<vector<int>>& people) {
        vector<vector<int>> ans;
        sort(people.begin(),people.end(),sortCompare);
        
        for(auto p:people){
            ans.insert(ans.begin()+p[1],p);
        }
        
        return ans;
    }
};