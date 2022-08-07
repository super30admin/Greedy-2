import java.util.HashMap;


//Time Complexity=O(n)
//Space Complexity=O(n)
public class TaskScheduler {

    public int leastInterval(char[] tasks, int n) {
        HashMap<Character,Integer> map=new HashMap<>();
        int k=tasks.length;

        int maxCount=0;;
        int maxfreq=0;

        for(char task:tasks){
            int count=map.getOrDefault(task,0);
            count++;
            maxfreq=Math.max(maxfreq,count);
            map.put(task,count);
        }


        for(char c:map.keySet()){
            if(map.get(c)==maxfreq){
                maxCount++;
            }

        }
        int partitions=maxfreq-1;
        int available=partitions*(n-(maxCount-1));
        int pending=k-(maxCount*maxfreq);

        int idle=0;
        idle=Math.max(idle,available-pending);

        return k+idle;
    }
}
