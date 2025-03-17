#space: O(1)- since tasks are uppercase english letter which is 26 
# time: O(n)
# approach , we will compute the partitions, empty slots, pending or remaining slot and finally idle slots
from collections import Counter
class Solution:
    def leastInterval(self, tasks: List[str], n: int) -> int:
        tasks_count=dict(Counter(tasks))
        max_freq= max(tasks_count.values())
        max_count= sum(1 for count in tasks_count.values() if count== max_freq)
        partitions= max_freq -1
        empty= partitions*(n - (max_count-1))
        pending= len(tasks) - (max_count* max_freq)
        idle= max(0, empty-pending)

        return len(tasks) + idle
