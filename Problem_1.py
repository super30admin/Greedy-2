'''
621 Task Scheduler
https://leetcode.com/problems/task-scheduler/description/

You are given an array of CPU tasks, each labeled with a letter from A to Z, and a number n. Each CPU interval can be idle or allow the completion of one task. Tasks can be completed in any order, but there's a constraint: there has to be a gap of at least n intervals between two tasks with the same label.
Return the minimum number of CPU intervals required to complete all tasks.

Example 1:
Input: tasks = ["A","A","A","B","B","B"], n = 2
Output: 8
Explanation: A possible sequence is: A -> B -> idle -> A -> B -> idle -> A -> B.

After completing task A, you must wait two intervals before doing A again. The same applies to task B. In the 3rd interval, neither A nor B can be done, so you idle. By the 4th interval, you can do A again as 2 intervals have passed.

Example 2:
Input: tasks = ["A","C","A","B","D","B"], n = 1
Output: 6
Explanation: A possible sequence is: A -> B -> C -> D -> A -> B.
With a cooling interval of 1, you can repeat a task after just one other task.

Example 3:
Input: tasks = ["A","A","A", "B","B","B"], n = 3
Output: 10
Explanation: A possible sequence is: A -> B -> idle -> idle -> A -> B -> idle -> idle -> A -> B.

There are only two types of tasks, A and B, which need to be separated by 3 intervals. This leads to idling twice between repetitions of these tasks.

Constraints:
1 <= tasks.length <= 104
tasks[i] is an uppercase English letter.
0 <= n <= 100

empty = partitions * (n -(maxCount-1))

Solutions:
1. Brute Force
Generate all possible permutations of the sequence of tasks. Then prune some of those permutations based on task scheduling rules.
Time: (exponential), Space: O(N)

2. Greedy approach
Step 1: Get partitions and empty spaces
Pick the task with the max frequency.
(Why max freq? If we pick the task with a lower freq, then we will end up creating more partitions to accommodate higher freq tasks.
Eg AAAABBBCC, n = 2
Pick B. B _ _ B _ _ B -> B A C B A C B A _ _ A -> total time = 11
Pick A. A _ _ A _ _ A _ _ A -> A B C A B C A B _ A -> total time = 10
https://youtu.be/6oieC_S17dc?t=2351
)

Insert n spaces between the instances of tax with max frequency. Then,
partitions = max freq - 1
Eg. AAAABBBCC, n = 2
A = 4, B = 3, C = 2. Thus, A has the max freq = 4.

Inserting n=2 spaces betwwen A's, we can create max freq - 1 = 3 paritions.
A _ _ A _ _ A _ _ A
(num empty spaces) empty = partitions*n = 3*2 = 6

Step 2: Compute pending tasks and idle slots
pending = tasks.len - max freq = 9 - 4 = 5
idle slots = empty + max freq - tasks.len
           = empty - pending
           = 6 + 4 - 9 = 1

Step 3: Compute total time taken
total = tasks.len + idle
      = 9 + 1
      = 10

Hence, the sequence of formulae are:
partitions = maxFreq - 1
empty = partitions*n
pending = tasks.len - max freq
idle = empty - pending
total time = tasks.len + idle

Some modifications reqd.
Let maxCount = no. of tasks with max frequency
partitions = maxFreq - 1
empty = partitions*(n - (maxCount - 1))
pending = tasks.len - maxFreq*maxCount
idle = max(0, empty - pending)
total time = tasks.len + idle

https://youtu.be/6oieC_S17dc?t=343
Time: (N), Space: O(1), N = len of tasks

'''
from typing import List
from collections import defaultdict

def leastInterval(tasks: List[str], n: int) -> int:
    if not tasks:
        return 0
    N = len(tasks)
    h = defaultdict(int)
    max_freq, max_count = 0, 0
    for c in tasks:
        h[c] += 1
        max_freq = max(max_freq, h[c])
    #max_freq_task = None
    for k in h:
        if h[k] == max_freq:
           #max_freq_task = k
           max_count += 1

    partitions = max_freq - 1
    empty = partitions*(n - (max_count - 1))
    pending = N - max_freq*max_count
    idle = max(0, empty - pending)
    total = N + idle
    return total

def run_leastInterval():
    tests = [(["A","A","A","B","B","B"],2,8),
             (["A","A","A","B","B","B","C","C"],2,8),
             (["A","A","A","A","B","B","B","B","C","C"],2,11),
             (["A","C","A","B","D","B"],1,6),
             (["A","A","A", "B","B","B"],3,10),
             (["A","A","A", "B","B","B"],0,6),
    ]
    for test in tests:
        tasks, n, ans = test[0], test[1], test[2]
        result = leastInterval(tasks, n)
        print(f"\ntasks = {tasks}")
        print(f"result = {result}")
        success = (ans == result)
        print(f"Pass: {success}")
        if not success:
            print("Failed")
            return

run_leastInterval()
