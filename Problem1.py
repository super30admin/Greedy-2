"""
Implemented using the mathematical formula approach discussed in the session. First, I calculated the frequency of each task and identified the maximum frequency (maxFreq). Then, I counted how many tasks have this maximum frequency (maxNum). Using this, I computed the number of partitions (gaps between the most frequent tasks), the available idle slots, and the number of pending tasks that can fill those slots. 
Finally, I calculated the total time as the sum of task count and required idle slots.
Time Compelxity: O(n)
Space Complexity: O(1)
"""
class Solution:
    def leastInterval(self, tasks: List[str], n: int) -> int:
        size = len(tasks)
        freq = Counter(tasks)
        maxFreq = max(freq.values())

        maxNum = 0
        for value in freq.values():
            if value == maxFreq:
                maxNum += 1
        
        partitions = maxFreq - 1
        available = partitions * (n - (maxNum - 1))
        pending  = size - (maxFreq * maxNum)
        idle = max(0, available - pending)

        return size + idle        