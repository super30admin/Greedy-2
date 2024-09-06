# Greedy-2

## Problem1 Task Scheduler (https://leetcode.com/problems/task-scheduler/)

class Solution:
    def leastInterval(self, tasks: List[str], n: int) -> int:
        task_counts = Counter(tasks)
        max_freq = max(task_counts.values())
        max_freq_tasks_count = sum(freq == max_freq for freq in task_counts.values())
        idle_time = (max_freq - 1) * (n + 1)
        min_length = idle_time + max_freq_tasks_count
        return max(len(tasks), min_length)
#TC = O(t) ; SC= O(=u) where t = total number of tasks & u = number of unique tasks

## Problem2 Queue Reconstruction by Height (https://leetcode.com/problems/queue-reconstruction-by-height/)

from typing import List

class Solution:
    def reconstructQueue(self, people: List[List[int]]) -> List[List[int]]:
        # Sort the 'people' array in descending order of height (h), 
        # and in the case of a tie, in ascending order of the number of people in front (k).
        people.sort(key=lambda person: (-person[0], person[1]))
      
        # Initialize an empty list to hold the final queue reconstruction
        queue = []
      
        # Iterate over the sorted 'people' list
        for person in people:
            # Insert each person into the queue. The index for insertion is the k-value,
            # which represents the number of people in front of them with equal or greater height.
            queue.insert(person[1], person)
      
        # Return the reconstructed queue
        return queue
#TC = O(n^2) ; SC= O(n)

## Problem3 Partition Labels (https://leetcode.com/problems/partition-labels/)
class Solution:
    def partitionLabels(self, S: str) -> List[int]:
        # Create a dictionary to store the last occurrence of each character.
        last_occurrence = {char: index for index, char in enumerate(S)}
      
        # Initialize variables.
        # `max_last` represents the farthest index any character in the current partition has been seen.
        # `partition_start` represents the start of the current partition.
        max_last = partition_start = 0
      
        # This list will hold the sizes of the partitions.
        partition_sizes = []
      
        # Iterate through the characters of the string along with their indices.
        for index, char in enumerate(S):
            # Update `max_last` to be the max of itself and the last occurrence of the current character.
            max_last = max(max_last, last_occurrence[char])
          
            # If the current index is the last occurrence of all characters seen so far in this partition,
            # that means we can end the partition here.
            if max_last == index:
                # Append the size of the current partition to the list (`index - partition_start + 1`).
                partition_sizes.append(index - partition_start + 1)
              
                # Update `partition_start` to the next index to start a new partition.
                partition_start = index + 1
      
        # Return the list of partition sizes.
        return partition_sizes
#TC = O(n) ; SC= O(n)

