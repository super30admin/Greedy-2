# Time Complexity: O(n) where n is the number of task
# Space Complexity: O(1)
class Solution:
    def leastInterval(self, tasks: List[str], n: int) -> int:
        if not tasks:
            return 0

        freq = Counter(tasks)
        max_freq = max(freq.values())
        max_count = sum(1 for val in freq.values() if val == max_freq)

        partitions = max_freq - 1
        available_slots = partitions * (n - (max_count - 1))
        pending_tasks = len(tasks) - (max_freq * max_count)
        idle = max(0, available_slots - pending_tasks)

        return len(tasks) + idle