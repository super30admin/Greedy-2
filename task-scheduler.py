# Time Complexity: O(n) - to construct the map
# Space Complexity: O(n)
class Solution:
    def leastInterval(self, tasks: List[str], n: int) -> int:
        if not tasks:
            return 0

        d = Counter(tasks)
        maxFreq = max(d.values())

        count = 0
        for k, v in d.items():
            if v == maxFreq:
                count +=1

        partitions = maxFreq -1
        empty = (n-(count-1))*partitions
        pending = len(tasks) - maxFreq*count
        idle = max(0, empty-pending)
        return idle+len(tasks) 