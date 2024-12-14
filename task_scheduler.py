"""
Brute Force: Since we are finding the max element every time, we can use heap.
Heap_approach: use heap
"""


class Solution_brute_force:
    def leastInterval(self, tasks: List[str], n: int) -> int:

        task_dict = {}
        interval = 0

        task_next_interval = {}
        arr = [0 for _ in range(10)]
        # store the frequency of task in dictionary
        for t in tasks:
            if t not in task_dict:
                task_dict[t] = 0
                task_next_interval[t] = 0
            task_dict[t] += 1

        # until there are tasks in the dict to execute
        while task_dict:
            # increment the interval
            interval += 1

            # find the next available_task every time
            max_freq = float("-inf")
            available_task = None
            # find the max frequency task
            for t in task_dict:
                # we can assign task only when an interval has reached.
                # Thus need to comapre the current interval and the needed interval by task
                # when you reach interval 5 do you some task to do?
                # Thus need to verify the interval with the task next interval
                if task_dict[t] > max_freq and task_next_interval[t] <= interval:
                    max_freq = task_dict[t]
                    max_freq_task = t
                    available_task = t

            # decrement frequency
            if available_task:
                task_dict[available_task] -= 1

                if task_dict[available_task] == 0:
                    del task_dict[available_task]
                # update the next time at which the task can run
                task_next_interval[available_task] = interval + n + 1

        return interval
