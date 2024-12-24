class Solution:
    def leastInterval(self, tasks: List[str], n: int) -> int:
        count_tasks = Counter(tasks)
        max_freq = max(count_tasks.values())
        max_count = sum(1 for count in count_tasks.values() if count == max_freq)

        partitions = max_freq - 1
        available_slots = partitions * (n - (max_count - 1))
        pending = len(tasks) - (max_freq * max_count)
        idle = max(0, available_slots - pending)

        return len(tasks) + idle

    # time complexity is O(n)
    # space complexity is O(1)
