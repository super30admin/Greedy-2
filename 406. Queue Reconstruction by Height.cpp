/*
Time: O(n^2)
Space: O(1)

Greedy:
Sort the array according to heights (tiebreaker using k)
The first item will have smallest value, so it will be placed exactly k cells after
The second item will be placed at k(+ 1, if the first item is smaller than it)th cell

So, xth item will be placed at k + sm index, where sm is the no. of elements smaller than h that are placed before it
this is because since we are going ascending order, later items are guaranted not to be smaller than current item, so we can place it globally 
*/
class Solution {
public:
    vector<vector<int>> reconstructQueue(vector<vector<int>>& peeps) {
        int n = peeps.size();
        vector<vector<int>> ret(n, {-1,-1});

        sort(peeps.begin(), peeps.end(), [](vector<int> &a, vector<int> &b){
            if(a[0] == b[0])  return a[1] < b[1];
            return a[0] < b[0]; 
        });

        for(int i=0;i<n;i++){
            int h = peeps[i][0], offset = peeps[i][1], j = 0, cnt = 0;

            while(cnt < offset){
                if(ret[j][0] == -1 || ret[j][0] >= h)  cnt++;
                j++;
            }
            

            while(ret[j][0] != -1) j++;  

            //printf("Setting %d-%d at %d\n",peeps[i][0],peeps[i][1],j);
            ret[j] = peeps[i];
        }

        return ret;
    }
};
