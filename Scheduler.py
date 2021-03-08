#Time Complexity: O(N)
#Space Complexity: O(1)
#Run on Leetcode: Yes
#Any Issues: No

class Solution:
    def leastInterval(self, tasks: List[str], n: int) -> int:
        char_freq = collections.Counter(tasks)
        char_freq = sorted(list(char_freq.items()), key = lambda x: x[1])
        
        max_freq = char_freq.pop()[1]
        
        idle_slots = (max_freq -1)*n
        while char_freq and idle_slots > 0:
            idle_slots -= min(max_freq-1, char_freq.pop()[1])
            
        idle_slots = max(0, idle_slots)
        
        return idle_slots + len(tasks)