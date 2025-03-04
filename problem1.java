import java.util.HashMap;

// Time complexity: O(n)
// Space Complexity : O(n)
public class problem1 {
    public int leastInterval(char[] tasks, int n) {
        HashMap<Character, Integer> map= new HashMap<>();
        int maxFreq=0;
        for (char c: tasks)
        {
            map.put(c, map.getOrDefault(c,0)+1);
            maxFreq= Math.max(maxFreq , map.get(c));
        }
        int maxCount=0;
        for (char c: map.keySet())
        {
            if (map.get(c)== maxFreq)
            {
                maxCount++;
            }
        }
        int partition = maxFreq-1;
        int availableSlots= partition*(n-(maxCount-1));
        int pending= tasks.length -(maxFreq*maxCount);
        int idle= Math.max(0, availableSlots-pending);

        return tasks.length+idle;

    }
}
