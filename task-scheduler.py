#Time Complexity : O(N)
#Space Complexity : O(1) : constrained by finite number of alphabets


class Solution:
    def leastInterval(self, tasks: List[str], n: int) -> int:
        
        task_freq = {}
        for task in tasks:
            if task in task_freq:
                task_freq[task] += 1
            else:
                task_freq[task] = 1

        max_freq = max(task_freq.values())
        tasks_with_max_freq = sum(freq == max_freq for freq in task_freq.values())

        partitions = max_freq - 1
        available_slots = partitions * (n - (tasks_with_max_freq - 1))
        pending_tasks = len(tasks) - (max_freq * tasks_with_max_freq)
        idle_slots = max(0, available_slots - pending_tasks)

        return len(tasks) + idle_slots
