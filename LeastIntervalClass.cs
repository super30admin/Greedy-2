// TC => O(n)
// SC => O(1)
public class Solution {
    public int LeastInterval(char[] tasks, int n) {
        if(tasks == null || tasks.Length == 0){
            return 0;
        }

        Dictionary<char, int> hashmap = new Dictionary<char, int>();
        int maxFreq = 0;

        foreach(var c in tasks){
            hashmap.TryAdd(c,0);
            hashmap[c]++;
            maxFreq = Math.Max(maxFreq, hashmap[c]);
        }
        int maxCount = 0;

        foreach(var kv in hashmap){
            if(kv.Value == maxFreq){
                maxCount++;
            }
        }
        int partition = maxFreq - 1;
        int empty = partition * (n - (maxCount - 1));
        int pending  = tasks.Length - (maxFreq * maxCount);
        int idle = Math.Max(0, empty - pending);

        return tasks.Length + idle;
    }
}