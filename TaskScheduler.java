import java.util.HashMap;
import java.util.Map;

//Time Complexity : O(n)
//Space Complexity : O(1) as the size of map is max 26
public class TaskScheduler {	
	/**Approach: Greedy**/
	public int leastInterval(char[] tasks, int n) {
        //Find max frequency
        int maxFreq=0;       
        Map<Character, Integer> map = new HashMap<>();
        for(char c: tasks){
            int count= map.getOrDefault(c, 0)+1;
            maxFreq = Math.max(maxFreq, count);
            map.put(c, count);
        }
        
        //Find count of max frequency chars
        int maxCount=0;
        for(char key: map.keySet()){
            if(map.get(key) == maxFreq) maxCount++;
        }
        
        //Fnd time to schedule all the tasks
        int partitions = maxFreq-1;
        int available = partitions * (n- (maxCount-1));
        int pending = tasks.length - (maxFreq * maxCount);
        int idle = Math.max(0, available-pending);
        
        return (idle + tasks.length);
    }
	
	// Driver code to test above
	public static void main (String[] args) {	
		TaskScheduler ob  = new TaskScheduler();		
		char[] tasks = {'A','A','A','B','B','B'};
		int n = 2;
		System.out.println("Min units of time to finish all the given tasks: "+ob.leastInterval(tasks, n));
	}
}
