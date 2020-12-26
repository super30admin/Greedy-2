#time- O(n)
#space-O(1)
#des - calculate the max frequency, max count- with max freq, number of partitions, empty spots and idle to put into.  refer notebook

class Solution:
    def leastInterval(self, tasks: List[str], n: int) -> int:
        from collections import defaultdict
        dic=defaultdict(int)
        for i in tasks:
            dic[i]+=1
        # print(dic)
        maxfreq=max(dic.values())
        maxcount=0
        for i in dic:
            if dic[i]==maxfreq:
                maxcount+=1
        partitions=maxfreq-1
        empty= partitions*(n-maxcount+1)
        pending=len(tasks)-(maxfreq*maxcount)
        idle=max(0,empty-pending)
        return len(tasks)+idle