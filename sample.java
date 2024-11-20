// Time Complexity : O(T+C) where T is number of tasks and C is number of unique tasts as task frequency computation takes O(T) ad iterating through HashMap takes O(C).
// Space Complexity : O(C) as we are storing the frequencies of unique tasks and so space is proportional to the number of distinct tasks. As there are only 26 alphabets we can consider space as O(1).
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : followed code tutorial


// Your code here along with comments explaining your approach
// The solution uses a greedy algorithm to determine the minimum time required to complete all tasks while adhering to the cooldown period n. First, it 
// calculates the frequency of each task using a HashMap and identifies the task with the highest frequency. Tasks with this frequency define the framework for 
// "partitions," with gaps between them determined by n. The solution calculates the total number of idle slots required and determines how many of these slots 
// can be filled with other tasks. If some idle slots remain, they are added to the total execution time. Otherwise, the total time is just the length of the tasks.

class Solution {
    public int leastInterval(char[] tasks, int n) {
        HashMap<Character, Integer> map = new HashMap<>();
        int maxFreq = 0;

        for(int i = 0; i < tasks.length; i++) {
            char task = tasks[i];
            map.put(task, map.getOrDefault(task, 0) + 1);
            maxFreq = Math.max(maxFreq, map.get(task));
        }

        int maxCount = 0;
        
        for(char task: map.keySet()) {
            if(map.get(task) == maxFreq) {
                maxCount++;
            }
        }

        int partitions = maxFreq - 1;
        int available = partitions * (n - (maxCount - 1));
        int pending = tasks.length - (maxFreq * maxCount);
        int idle = Math.max(0, available - pending);
        return tasks.length + idle;
    }
}



// Time Complexity : O(n^2) as sorting takes O(nlogn) and inserting each person into the list can take O(n) and in the worst case overall complexity will be O(n^2).
// Space Complexity : O(n) as we are using a list to build a queue.
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : followed code tutorial


// Your code here along with comments explaining your approach
// The problem is solved using a greedy algorithm. The people array is first sorted by height in descending order; if two people have the same height, they 
// are sorted by the number of people in front (k) in ascending order. Then, the sorted array is processed one by one, and each person is inserted into a list 
// at the index equal to their k value. This ensures that the position of each person in the queue satisfies the given constraints. Finally, the list is 
// converted back to a 2D array for the result.

class Solution {
    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, (a, b) -> {
            if(a[0] == b[0]) {
                return a[1] - b[1];
            }
            return b[0] - a[0];
        });

        List<int[]> li = new ArrayList<>();
        for(int[] person: people) {
            li.add(person[1], person);
        }

        int[][] result = new int[people.length][2];

        for(int i = 0; i < li.size(); i++) {
            result[i] = li.get(i);
        }

        return result;
    }
}



// Time Complexity : O(n) as we are going to parse the array twice as n is length of the string s
// Space Complexity : O(1) as hashmap will have at most 26 elements
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : followed tutorial from class


// Your code here along with comments explaining your approach
// In this solution we will scan the string to record the last occurrence of each character using a HashMap. Then we will iterate through the string keeping track
// of the current partitions end by updating it to the farthest last occurrence of any character in the current position. When current index will match the end of
// the partition then size of the partition is added to the result list and new partition begins from the next element.

class Solution {
    public List<Integer> partitionLabels(String s) {
        
        int n = s.length();

        HashMap<Character, Integer> map = new HashMap<>();
        List<Integer> result = new ArrayList<>();

        for(int i = 0; i < n; i++) {
            char c = s.charAt(i);
            map.put(c, i);
        }

        int start = 0;
        int end = 0;

        for(int i = 0; i < n; i++) {
            char c = s.charAt(i);

            end = Math.max(end, map.get(c));

            if(i == end) {
                result.add(end - start + 1);
                start = end + 1;
                end = 0;
            }
        }

        return result;

    }
}



