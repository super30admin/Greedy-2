import java.util.HashMap;
/*
Time Complexity: O(N), length of tasks array
Space Complexity: O(26), which is constant as HashMap would maximum can have size 26
Any difficulties: no
Run on leetcode: yes

Approach:
1. I am making frequency map of each tasks inorder to assign slots to the tasks,
2. I will choose tasks with the maximum frequency as my first task to assigned slot, now coolong period could have another
tasks running
3. Maximum number of slots could be calculated based on the formula (maxFreuqency-1)*(n+1)+number of tasks that have maximum
frequency
 */
public class TaskScheduler  {
    public static int taskScheduler(char[] tasks, int n){
        HashMap<Character, Integer> map = new HashMap<>();

        for(char task: tasks){
            map.put(task, map.getOrDefault(task,0)+1);
        }

        int maxFrequency = 0;
        for(char key: map.keySet()){
            if(map.get(key)>0){
                maxFrequency = Math.max(maxFrequency, map.get(key));
            }
        }

        int mostFrequentTasks = 0;

        for(char key: map.keySet()){
            if(map.get(key) == maxFrequency){
                mostFrequentTasks++;
            }
        }

        return Math.max(tasks.length, (maxFrequency-1)*(n+1)+mostFrequentTasks);
    }

    public static void main(String[] args){
        char[] tasks = {'A','A','A','B','B','B'};
        System.out.println("Task Scheduler: "+ taskScheduler(tasks, 2));
    }
}
