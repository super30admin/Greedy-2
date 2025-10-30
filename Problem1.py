"""
TC: O(N) {We traverse the list of tasks once to count their frequencies using a Counter, 
           and then once more to determine the number of tasks with the maximum frequency. 
           Each operation within these loops is constant time, resulting in an overall linear 
           time complexity with respect to the number of tasks.}
SC: O(1) {We use a fixed-size Counter to store at most 26 task types (A–Z), along with 
           a few integer variables. Since the alphabet size is constant, the auxiliary 
           space usage is constant.}

Approach:
We are tasked with scheduling CPU tasks with a cooldown period `n` between two same tasks 
to minimize the total time required to execute all tasks. The goal is to compute the 
least number of time units (including idle times) required.

We start by counting the frequency of each task using a `Counter`. The task(s) with the 
highest frequency determine the base structure of our schedule since they need the 
largest number of cooldown gaps.

Let:
    - `maxFreq` be the maximum frequency among tasks.
    - `numOfMaxFreqTasks` be the number of tasks that appear `maxFreq` times.

We conceptualize the schedule as being divided into `(maxFreq - 1)` partitions, 
each representing a block between occurrences of the most frequent tasks.  
The size of each partition (i.e., available idle slots) depends on the cooldown `n` 
and how many high-frequency tasks exist.

We then calculate:
    - `available`: total available idle slots between the most frequent tasks.
    - `pending`: remaining tasks after placing all max-frequency tasks.
    - `idle`: required idle slots to fill gaps, ensuring cooldown constraints are met.

Finally, the total time is the sum of all tasks plus any required idle slots:
`len(tasks) + idle`.

This greedy mathematical approach avoids explicit simulation, ensuring efficiency 
and correctness.

This problem ran successfully on Leetcode.
"""

class Solution:
    def leastInterval(self, tasks: List[str], n: int) -> int:
        numOfMaxFreqTasks = 0
        counter = Counter(tasks)
        maxFreq = max(counter.values())

        for key, val in counter.items():
            if val == maxFreq:
                numOfMaxFreqTasks += 1
        

        numPartitions = maxFreq - 1
        available = numPartitions * (n - (numOfMaxFreqTasks - 1))
        pending = len(tasks) - (maxFreq * numOfMaxFreqTasks)
        idle = max(0, available - pending)

        return len(tasks) + idle
