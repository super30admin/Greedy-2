public class TashScheduler {
    public int leastInterval(char[] tasks, int n) {
        int[] freq = new int[26];
        int maxfreq=0; int difftasks=0; int maxfreqCount=0;
        for (char ch : tasks) {
            freq[ch - 'A']++;
            maxfreq=Math.max(maxfreq,freq[ch-'A']);
        }
        //differnt letter count
        for(int i=0;i<26;i++){
            if(freq[i]!=0)
                difftasks++;
            if(freq[i]==maxfreq)
                maxfreqCount++   ;
        }

        int partCount = maxfreq - 1;
        int partLength = n - (maxfreqCount - 1);

        int emptySlots = partCount * partLength;

        int availableTasks = tasks.length - maxfreq * maxfreqCount;
        int idles = Math.max(0, emptySlots - availableTasks);

        return tasks.length + idles;

    }
}
