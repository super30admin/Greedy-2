Time Complexity (TC): O(n + k log k), where n is the length of the tasks array and k is the size of the frequency array (26 for English letters), as we count the tasks and then sort the frequency array.
Space Complexity (SC): O(1), since the frequency array size is constant (26), regardless of input size.

class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] freqArr = new int[26];
        for (char c : tasks) {
            freqArr[c - 'A']++;
        }

        Arrays.sort(freqArr);
        int partitions=freqArr[25]-1;
        int idleSlots=partitions*n;

        for(int i=24;i>=0; i--){
            idleSlots-=Math.min(partitions,freqArr[i]);
        }
         return idleSlots <= 0 ?  tasks.length:tasks.length + idleSlots;
        // return idleSlots==0?n:idleSlots+n;

    }
}
