class Solution:
    def leastInterval(self, tasks: List[str], n: int) -> int:
        """Greedy approach, using formulas to calculate the idle time using highest freq character
        Time complexity-O(n)
        Space complexity-O(1)"""
        idle=0
        hashmap={}
        maxfreq=0
        for i in range(len(tasks)):
            if tasks[i] not in hashmap:
                hashmap[tasks[i]]=0
            hashmap[tasks[i]]+=1
            maxfreq=max(maxfreq, hashmap[tasks[i]])
        maxcount=0
        for i in hashmap.keys():
            if hashmap[i]==maxfreq:
                maxcount+=1
        partitions=maxfreq-1
        available=partitions*(n-(maxcount-1))
        remaining=len(tasks)-(maxfreq*maxcount)
        idle=max(0,available-remaining)
        
        return len(tasks)+idle