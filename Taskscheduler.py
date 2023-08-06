# // Time Complexity :O(n)
# // Space Complexity :O(n)
# // Did this code successfully run on Leetcode :yes
# // Any problem you faced while coding this :no
class Solution:
    def leastInterval(self, tasks: List[str], n: int) -> int:
        freq = collections.Counter(tasks).values()
        maxFreq = max(freq)
        maxFreqCount = freq.count(maxFreq)
            
        ans = (maxFreq - 1) * (n+1) + maxFreqCount
        
        return max(ans, len(tasks))
        