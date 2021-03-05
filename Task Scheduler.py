class Solution:
    def leastInterval(self, tasks: List[str], n: int) -> int:
        #Approach: Maths  //  Greedy
        #Time Complexity: O(m)
        #Space Complexity: O(1)
        #where, m is the length of tasks
        
        counts = [0 for _ in range(26)]
        for task in tasks:
            counts[ord(task) - ord('A')] += 1
        
        max_freq = max(counts)
        n_maxFreq = counts.count(max_freq)
        
        return max(len(tasks), (max_freq - 1) * (n + 1) + n_maxFreq)