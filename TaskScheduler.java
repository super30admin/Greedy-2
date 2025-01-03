import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class TaskScheduler {
    public int leastInterval(char[] tasks, int n) {
        int[] count = new int[26];

        for(char task: tasks){
            count[task-'A']++;
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b)-> b-a);
        for( int cnt: count){
            if(cnt >0){
                pq.add(cnt);
            }
        }

        int time=0;
        Queue<int[]> q = new LinkedList<>();
        while(!pq.isEmpty() || !q.isEmpty()){
            time++;

            if(pq.isEmpty()){
                time = q.peek()[1];
            }else{
                int cnt = pq.poll()-1;
                if(cnt>0){
                    q.add(new int[]{cnt, time+n});
                }
            }

            if(!q.isEmpty() && time == q.peek()[1]){
                pq.add(q.poll()[0]);
            }
        }

        return time;

    }
}
