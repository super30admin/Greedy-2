"""
Count the frequency of each task — the most frequent task determines layout
Build (max_freq - 1) full cycles of size (n + 1) and then add the last batch of max frequency tasks
The minimum time is either this calculated frame size or the actual task count (whichever is larger)
"""
"""
Time Complexity : O(N) - One Pass
Space Complexity : O(1) - No extra space
"""
from collections import Counter

class taskScheduler:
    def leastInterval(self, tasks: list[str], n: int) -> int:
        freq = Counter(tasks)
        max_freq = max(freq.values())
        max_count = sum(1 for v in freq.values() if v == max_freq)

        part_count = max_freq - 1
        part_length = n + 1
        empty_slots = part_count * part_length + max_count

        return max(len(tasks), empty_slots)

if __name__ == "__main__":
    obj = taskScheduler()
    print(obj.leastInterval(["A", "A", "A", "B", "B", "B"], 2)) 
    print(obj.leastInterval(["A", "A", "A", "B", "B", "B"], 0))
    print(obj.leastInterval(["A", "A", "A", "A", "B", "C", "D", "E", "F", "G"], 2))

