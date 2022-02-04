class Solution:
    # Time Complexity - O(n)
    # Space Complexity - O(1) as number of alphabets is constant
    def leastInterval(self, tasks, n: int) -> int:
        if tasks is None or len(tasks) == 0: return 0
        d = {}
        max_freq = 0
        max_count = 0
        for i in range(len(tasks)):
            if tasks[i] in d:
                d[tasks[i]] += 1
            else:
                d[tasks[i]] = 1
            max_freq = max(max_freq, d[tasks[i]])

        for k, v in d.items():
            if max_freq == v:
                max_count += 1

        partitions = max_freq - 1
        empty = partitions * (n - (max_count - 1))
        pending = len(tasks) - (max_freq * max_count)
        idle = max(0, empty - pending)

        return len(tasks) + idle