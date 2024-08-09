/*
Time: O(n)
Space: O(1)

Sliding Window:
Start left border at the start of a partition,
For each character in the window, adjust the right border to maximum index of last occurence of any such character
When we reach the right border, end the partition
*/
class Solution {
public:
    vector<int> partitionLabels(string s) {
        int n = s.length();
        vector<int> last(26,-1);

        //get last occurence
        for(int i=0;i<n;i++){
            int val = s[i] - 'a';
            
            last[val] = max(last[val],i);
        }
        
        vector<int> ret;

        int prev = -1;
        int next = 0;

        //for every character, check its last occurence (which denotes the right boundary for this character) and track the max right boundary
        //if current index is beyond the max right boundary so far, it means we are in a new partition
        for(int i=0;i<n;i++){
            if(i>next){ //new parition!
                ret.push_back(i-1-prev);
                prev = i-1; //store previous partition's end point
            }

            int val = s[i] - 'a';
            int l = last[val];

            next = max(next,l);
        }

        ret.push_back(n-1-prev); //last partition
        return ret;
    }
};