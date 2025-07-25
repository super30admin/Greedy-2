# TimeComplexity:O(n)
# SpaceComplexity:O(1)
# Approach: 
# we for sure know min intervals would be size of tasks we should  figure out  if there are any idle in between 
# To find idle in between first we need to calclualte available and pending there might be many differnt wats to get order
# but we first try to fix our bottleneck that would be tasks with max freq we put them with n places apart (if therew are more than 1 with same maxFreq we club them togather)
# number of partitions would be maxfreq-1
# A_  _ A _ _ A 
# Lets say we club tasks of same max freq  pending would be len(tasks)-m*maxnum




class Solution:
    def leastInterval(self, tasks: List[str], n: int) -> int:
        d=defaultdict(int)
        m=0
        for i in tasks:
            d[i]+=1
            m=max(m,d[i])
        maxnum=0
        for i in d:
            if d[i]==m:maxnum+=1
        
        # n=len(d.keys())
        parttions=m-1
        avail= parttions*(n-maxnum+1)
        pending=len(tasks)-m*maxnum
        idle=max(0,avail-pending)
        return len(tasks)+idle
