#include<iostream>
#include<bits/stdc++.h>
#include<vector>
using namespace std;
/*
We find the task(s) that occur the most and figure out how many such max-frequency tasks exist.
Then we calculate the number of idle slots required between these high-frequency tasks.
If other tasks can fill those slots, we do, otherwise, we add idle time to the total.
*/
class Solution{
public:
    int leastInterval(vector<char>& tasks, int n){
        unordered_map<char, int> map;
        int maxFreq = 0;
        int maxCount = 0;

        for(char c : tasks){
            map[c]++;
            maxFreq = max(maxFreq, map[c]);
        }

        for(auto& entry : map){
            if(entry.second == maxFreq){
                maxCount++;
            }
        }

        int partitions = maxFreq - 1;
        int availableSlots = partitions * (n -(maxCount - 1));
        int pending = tasks.size() - (maxFreq - pending);
        int idle = max(0, availableSlots - pending);
        
        return tasks.size() + idle;
    } 
};
