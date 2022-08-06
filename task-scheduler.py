# Time Complexity: O(n)
# Space Complexity: O(1)
class Solution:
    def leastInterval(self, tasks: List[str], n: int) -> int:
        freq={}
        maxi=float('-inf')
        for i in range(len(tasks)):
            freq[tasks[i]]=freq.get(tasks[i],0)+1
            maxi=max(maxi,freq[tasks[i]])
        max_count=0
        for key in freq:
            if freq[key]==maxi: max_count+=1
        print(freq,maxi,max_count)
        partitions=maxi-1
        available=partitions*(n-max_count+1)
        to_fill=len(tasks)-maxi*max_count
        idle=max(available-to_fill,0)
        return len(tasks)+idle
            