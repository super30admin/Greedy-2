//see editorial
//time: O(n)
//space: O(1)
class Solution {
public:
    int leastInterval(vector<char>& tasks, int n) {
        unordered_map<char,int>mp;
        int count = 0;
        for(auto e : tasks)
        {
            mp[e]++;
            count = max(count, mp[e]);
        }
        
        int ans = (count-1)*(n+1);
        for(auto e : mp) if(e.second == count) ans++;
        return max((int)tasks.size(), ans);
    }
};

//editorial sols - all O(n), O(1)

/*
class Solution {
public:
    int leastInterval(vector<char>& tasks, int n) {
        // Create a frequency array to keep track of the count of each task
        vector<int> freq(26);
        for (char task : tasks) {
            freq[task - 'A']++;
        }

        // Sort the frequency array in non-decreasing order
        sort(freq.begin(), freq.end());
        // Calculate the maximum frequency of any task
        int maxFreq = freq[25] - 1;
        // Calculate the number of idle slots that will be required
        int idleSlots = maxFreq * n;

        // Iterate over the frequency array from the second highest frequency to the lowest frequency
        for (int i = 24; i >= 0 && freq[i] > 0; i--) {
            // Subtract the minimum of the maximum frequency and the current frequency from the idle slots
            idleSlots -= min(maxFreq, freq[i]);
        }

        // If there are any idle slots left, add them to the total number of tasks
        return idleSlots > 0 ? idleSlots + tasks.size() : tasks.size();
    }
};
*/

/*
class Solution {
public:
    int leastInterval(vector<char>& tasks, int n) {
        // Counter array to store the frequency of each task
        int counter[26] = {0};
        int maximum = 0;
        int maxCount = 0;
        // Traverse through tasks to calculate task frequencies
        for (char task : tasks) {
            counter[task - 'A']++;
            if (maximum == counter[task - 'A']) {
                maxCount++;
            }
            else if (maximum < counter[task - 'A']) {
                maximum = counter[task - 'A'];
                maxCount = 1;
            }
        }
        
        // Calculate idle slots, available tasks, and idles needed
        int partCount = maximum - 1;
        int partLength = n - (maxCount - 1);
        int emptySlots = partCount * partLength;
        int availableTasks = tasks.size() - maximum * maxCount;
        int idles = max(0, emptySlots - availableTasks);
        
        // Return the total time required
        return tasks.size() + idles;
    }
};
*/

/*
class Solution {
public:
    int leastInterval(vector<char>& tasks, int n) {
        // freq array to store the frequency of each task
        int freq[26] = {0};
        int maxCount = 0;

        // Count the frequency of each task and find the maximum frequency
        for (char task : tasks) {
            freq[task - 'A']++;
            maxCount = max(maxCount, freq[task - 'A']);
        }

        // Calculate the total time needed for execution
        int time = (maxCount - 1) * (n + 1);
        for (int f : freq) {
            if (f == maxCount) {
                time++;
            }
        }

        // Return the maximum of total time needed and the length of the task list
        return max((int)tasks.size(), time);
    }
};
*/