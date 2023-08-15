import java.util.Scanner;
import java.util.HashMap;

public class TaskSchedulerCooldown {

        // Greedy - Time O(T) and Space O(1)

        public int leastInterval(char[] tasks, int n) {

            HashMap<Character, Integer> freqMap = new HashMap<>();   // O(1) space

            int maxFreq = 0;

            // find maximum frequency by iterating over tasks array
            for(char task: tasks) {

                freqMap.put(task, freqMap.getOrDefault(task, 0) + 1);

                maxFreq = Math.max(maxFreq, freqMap.get(task));
            }

            int maxFreqCharCount = 0;

            // find number of character elements with maximum frequency by iterating over key character set of frequency map
            for(char task: freqMap.keySet()) {

                if(freqMap.get(task) == maxFreq) {

                    maxFreqCharCount++;
                }
            }

            // max frequency is the bottleneck for number of partitions required to satisfy cooldown
            int parts = maxFreq - 1;

            // available spots in partitions is difference of cooldown and number of characters with maximum frequency apart from the first as such multiplied by number of partitions
            int freeInParts = parts * (n - (maxFreqCharCount - 1));

            // tasks left will be the difference of total number of tasks and number of characters with maximum frequency multiplied by maximum frequency
            int leftTasks = tasks.length - maxFreq * maxFreqCharCount;

            // idle is a non-negative difference of free spots in partitions and tasks left to be finished
            int idle = Math.max(0, (freeInParts - leftTasks));

            //
            return tasks.length + idle;
        }

        public static void main(String[] args) {

            TaskSchedulerCooldown obj = new TaskSchedulerCooldown();

            Scanner scanner = new Scanner(System.in);

            System.out.println("cooldown: ");
            int n = scanner.nextInt();

            System.out.println("number of tasks: ");
            int t = scanner.nextInt();

            char[] tasks = new char[t];
            System.out.println("tasks: ");
            for(int i = 0; i < t; i++) {

                tasks[i] = scanner.next().charAt(0);
            }

            int answer = obj.leastInterval(tasks, n);
            System.out.println("the least number of units of times that the CPU will take " +
                    "to finish all the given tasks: " + answer);

        }
}

/*
TIME COMPLEXITY = O(T)

T = number of tasks

SPACE COMPLEXITY = O(1)
*/