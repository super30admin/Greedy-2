# Time Complexity : O(n)
# Space Complexity : O(1)

class Solution:
    def leastInterval(self, tasks: List[str], n: int) -> int:
        hashmap = defaultdict(int)
        max_freq = 0
        max_count = 0
        for task in tasks:
            hashmap[task] += 1
            max_freq = max(max_freq, hashmap[task])

        for key, val in hashmap.items():
            if val == max_freq:
                max_count += 1

        partitions = max_freq - 1
        available = partitions * (n - (max_count - 1))
        pending = len(tasks) - (max_freq*max_count)
        idle = max(0, available - pending)
        return len(tasks) + idle
