///Task Schedular
import java.util.*;
// tc- O(nlogn)
//sc - O(1)
class Problem1{
    public static void main(String[] args){
        Problem1 p = new Problem1();
        char[] tasks = {'A','A','A','B','B','B'};
        System.out.println(p.leastInterval(tasks, 2));

    }
    public int leastInterval(char[] tasks, int n) {
        int result = 0;
        int size = tasks.length;
        // greedy approach , run the most frequent task
        if(n==0)
            return tasks.length;
        int[]arr = new int[26];
        for(char ch : tasks){
            arr[ch-'A'] ++;
        }
        Arrays.sort(arr);
        // for(int i : arr){
        //     System.out.println(i);
        // }
        int chunk = arr[25]-1; //2
       // System.out.println("a"+chunk);
        int emptySpots = chunk * n; //4
        for(int i = 24; i>=0; i--){
            emptySpots -= Math.min(chunk, arr[i]);
            
        }
        return emptySpots < 0 ? tasks.length: emptySpots + tasks.length;
        
       
        
    }
}