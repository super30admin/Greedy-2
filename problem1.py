#time O(N)
#space O(N)
class Solution(object):
    def leastInterval(self, tasks, n):
        """
        :type tasks: List[str]
        :type n: int
        :rtype: int
        """
        tlist = []
        
        for t in range(26):
            tlist += 0,
        
        for t in tasks:
            
            tlist[ord(t)-ord('A')] += 1
        
        tlist.sort(reverse=True)
        i = 0
        time = 0
        print(tlist)
        while tlist[0] > 0:
            
            j = 0
            while j<=n and tlist[0] != 0:
                
                if j<26 and tlist[j] >0:
                    tlist[j] -= 1
                time += 1
                j += 1
                
            tlist.sort(reverse=True)
            # print(tlist,"--",time)
        return time        