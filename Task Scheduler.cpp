// Approach:
// Count the frequency of each task and find the task with the maximum frequency (maxi). 
// Then, compute the number of idle slots needed by arranging the most frequent tasks with a cooling period n, and subtracting the space filled by other tasks. 
// Finally, return the total time as the sum of task count and idle slots.

// Time Complexity (TC): O(N) where N is the number of tasks (due to the single pass over the tasks and a fixed 26-letter frequency array).
// Space Complexity (SC): O(1) since the frequency array size is constant (26).

class Solution {
public:
    int leastInterval(vector<char>& tasks, int n) {
        int* arr = new int[26]();

        for (char x : tasks) {
            arr[x - 'A']++;
        }
        int maxi = 0;
        int maxCount = 0;
        for (int i = 0; i < 26; ++i) {
            maxi = max(arr[i], maxi);
        }
        for (int i = 0; i < 26; ++i) {
            if (maxi == arr[i])
                maxCount++;
        }
        int spaces = maxi - 1;
        int empty_slots = spaces * (n - (maxCount - 1));
        int pending = tasks.size() - maxi * maxCount;
        int idle = max(0, empty_slots - pending);

        return tasks.size() + idle;
    }
};
