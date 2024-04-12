// t-c: n
// s-c: 1
class Solution {
public:
    int leastInterval(vector<char>& tasks, int n) {
        vector<int> freq(26, 0);
        vector<int> temp(tasks.size(), 0);
        for(int i = 0; i < tasks.size(); i++){
            freq[tasks[i] - 'A']++;
        }
        sort(freq.begin(), freq.end(), greater<int>());
        for(int i = 0; i < freq.size(); i++){
            if(freq[i] == 0){
                break;
            }
            int j = i;
            while(freq[i] > 0){
                while(j > temp.size()-1){
                    temp.push_back(0);
                }
                temp[j] = 1;
                j += (n + 1);
                freq[i]--;
            }
        }
        return temp.size();   
    }
};
