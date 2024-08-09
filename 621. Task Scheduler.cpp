/*
Time: O(n*logn)
Space: O(n)
*/
class Solution {
public:
    int leastInterval(vector<char>& tasks, int n) {
        vector<int> cnt(26,0);
        priority_queue<int> q;

        for(auto &c: tasks){
            cnt[c-'A']++;
        }

        for(auto &f: cnt){
            if(f)  q.push(f);
        }

        int ans = 0;
        
        //at every iteration, we take n+1 items (if available, otherwise we fillup remaining spots with 'idle')
        while(!q.empty()){
            //int mini = 1e9;
            vector<int> pops;

            //this loop can run cumulative of o(n) time at worst case
            while(!q.empty() && pops.size()<n+1){
                int top = q.top();
                q.pop();

                //mini = min(top, mini);
                pops.push_back(top);
            }
            
            //this loop can run cumulative of o(n) time at worst case
            for(auto &u: pops){
                u -= 1;
                if(u)  q.push(u);
            }

            if(q.empty())  ans += pops.size(); //last iteration -> no need of idle
            else  ans += n+1; //else, we take n+1 (potentially having a number of 'idle's)
        }

        return ans;
    }
};
