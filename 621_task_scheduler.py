"""

## Problem 621: Task Scheduler

## Author: Neha Doiphode
## Date:   11-05-2022

## Description:
    Given a characters array tasks, representing the tasks a CPU needs to do,
    where each letter represents a different task. Tasks could be done in any order.
    Each task is done in one unit of time.
    For each unit of time, the CPU could complete either one task or just be idle.

    However, there is a non-negative integer n that represents the cooldown period between two same tasks
    (the same letter in the array), that is that there must be at least n units of time between any two same tasks.

    Return the least number of units of times that the CPU will take to finish all the given tasks.

## Examples:
    Example 1:
        Input: tasks = ["A","A","A","B","B","B"], n = 2
        Output: 8
        Explanation:
            A -> B -> idle -> A -> B -> idle -> A -> B
            There is at least 2 units of time between any two same tasks.

    Example 2:
        Input: tasks = ["A","A","A","B","B","B"], n = 0
        Output: 6
        Explanation: On this case any permutation of size 6 would work since n = 0.
                    ["A","A","A","B","B","B"]
                    ["A","B","A","B","A","B"]
                    ["B","B","B","A","A","A"]...and so on.

    Example 3:
        Input: tasks = ["A","A","A","A","A","A","B","C","D","E","F","G"], n = 2
        Output: 16
        Explanation:
        One possible solution is
            A -> B -> C -> A -> D -> E -> A -> F -> G -> A -> idle -> idle -> A -> idle -> idle -> A

## Constraints:
    1 <= task.length <= 104
    tasks[i] is upper-case English letter.
    The integer n is in the range [0, 100].


## Time complexity: O(N * n), where N is the number of tasks to execute.
                              and n is the cooldown period between two same tasks.
                              Also, O(N) time is needed to iterate over the input array tasks
                              and compute the array frequencies.
                              Array frequencies contains 26 elements, and hence all operations with it takes constant time.
                              Removing constant terms, the total time complexity would be O(N * n).

## Space complexity: O(1), to keep the array frequencies of 26 elements.
                     We create heap from the array of frequencies but the size of heap will never exceed more than 26.

"""

from typing import List, Optional
import heapq
from collections import Counter

def get_input():
    print("Enter the list of tasks as array of characters(with spaces): ", end = "")
    inp_list = input()
    inp_list = [value for value in inp_list.split()]
    print("Enter the cooldown period between two same tasks(integer): ", end = "")
    n = int(input())
    return inp_list, n


class Solution:
    def inverse(self, value):
        return -1 * value

    def leastInterval(self, tasks: List[str], n: int) -> int:
        # Step 1: Counter number of CPU units required for each task
        task_counter = Counter(tasks)

        # Step 2: Initialize empty list to store the heap
        heap = []

        # Step 3: Push all units on to the heap
        #         Here, we deliberately push -1 * counter value on to the heap
        #         as we are create a min heap but we want the most frequent task to be scheduled first
        #         by negating the frequency of such task we are putting it at the top of min heap(at the root)
        for key, value in task_counter.items():
            heapq.heappush(heap, (self.inverse(value), key))


        # Step 4: Once the min-heap is created we need to start popping tasks one by one and schedule them
        #         while scheduling them we have to take into account the cool off period
        #         and we have to count number of CPU units utilized.
        min_units_utilized = 0

        # Start looping over the min-heap
        while heap:
            empty_slots, temp = 0, []
            # we count units and tasks that can be allocated in the empty slots
            # starting with maximum frequency task
            while empty_slots <= n:
                # every time we increment units utilized by 1
                min_units_utilized += 1
                if heap:
                    # Pop max frequency task from the heap and
                    # reduce its unit by one and append it to the temp list
                    # here we are adding 1 because to build the min heap we have "negated" the actual task units earlier
                    current_units, current_task = heapq.heappop(heap)
                    if current_units != -1:
                        temp.append((current_units + 1, current_task))

                if not heap and not temp:
                    break

                empty_slots += 1

            # Push items in temp(tasks with 1 less unit) on to the heap again and
            # continue the process until all units are allocated and the heap is empty
            for item in temp:
                heapq.heappush(heap, item)

        return min_units_utilized


# Driver code
solution = Solution()
inp_list, n = get_input()
print(f"Input task list: {inp_list}")
print(f"Input cooldown period between two same tasks: {n}")
print(f"Using heap sort: Minimum units that CPU will need to finish all the given tasks are: {solution.leastInterval(inp_list, n)}")
