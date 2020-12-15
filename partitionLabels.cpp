class Solution {
public:
    int leastInterval(vector<char>& tasks, int n) {
        
        unordered_map<char,int> um;
        priority_queue<int> pq;
        
        for(auto x:tasks)
        {
            um[x]++;
        }
        
        for(auto x:um)
        {
            pq.push(x.second);
        }
            
        int count=0;
        while(!pq.empty())
        {
            vector<int> answer;
            for(int i=0;i<n+1;i++)
            {
                if(!pq.empty())
                {
                answer.push_back(pq.top());
                pq.pop();
                }
            }
            
            for(int i=0;i<answer.size();i++)
            {
                if(answer[i]-1>0)
                {
                    answer[i]--;
                    pq.push(answer[i]);
                }
            }
            
            count+=pq.empty()?answer.size():n+1;
        }
        
        return count;
    }
};