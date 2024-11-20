# Greedy-2

## Problem1 Task Scheduler (https://leetcode.com/problems/task-scheduler/)

The solution uses a greedy algorithm to determine the minimum time required to complete all tasks while adhering to the cooldown period n. First, it calculates the frequency of each task using a HashMap and identifies the task with the highest frequency. Tasks with this frequency define the framework for "partitions," with gaps between them determined by n. The solution calculates the total number of idle slots required and determines how many of these slots can be filled with other tasks. If some idle slots remain, they are added to the total execution time. Otherwise, the total time is just the length of the tasks.



## Problem2 Queue Reconstruction by Height (https://leetcode.com/problems/queue-reconstruction-by-height/)

The problem is solved using a greedy algorithm. The people array is first sorted by height in descending order; if two people have the same height, they are sorted by the number of people in front (k) in ascending order. Then, the sorted array is processed one by one, and each person is inserted into a list at the index equal to their k value. This ensures that the position of each person in the queue satisfies the given constraints. Finally, the list is converted back to a 2D array for the result.



## Problem3 Partition Labels (https://leetcode.com/problems/partition-labels/)

In this solution we will scan the string to record the last occurrence of each character using a HashMap. Then we will iterate through the string keeping track of the current partitions end by updating it to the farthest last occurrence of any character in the current position. When current index will match the end of the partition then size of the partition is added to the result list and new partition begins from the next element.


