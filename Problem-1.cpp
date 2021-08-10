//O(n) + O(n), better solution than taught in class, tbh
class Solution {
public:
    int leastInterval(vector<char>& tasks, int n) {
        vector<int> map(26);
        for (auto c:tasks)
        {
            map[c-'A']++;
        }
        sort(map.begin(),map.end());
        
        int max_val = map[25]-1;
        int idle_slots = max_val*n;
        for (int i = 24;i>=0 && map[i]>0;i--)
        {
            idle_slots-=min(map[i],max_val);
        }
        return idle_slots > 0 ? idle_slots + tasks.size() : tasks.size();
    }
};

