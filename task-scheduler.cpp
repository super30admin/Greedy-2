//Time - O(n)
//Space - O(1)
class Solution {
public:
    int leastInterval(vector<char>& tasks, int n) {
        if(n == 0) return  tasks.size();
        int maxFreq = 0, maxCount = 0;
        unordered_map<char,int> umap;
        for(auto t:tasks){
            umap[t]++;
            maxFreq = max(maxFreq, umap[t]);
        }
        
        for(int i=0;i<26;i++){
            if(maxFreq == umap['A'+i]){
                maxCount++;
            }
        }

        int partitions = maxFreq-1;
        int empty = partitions*(n-maxCount+1);
        int pending = tasks.size() - (maxCount*maxFreq);
        int idle = max(0, empty-pending);
        return (tasks.size()+idle);
        
    }
};