#621. Task Scheduler
"""
Time Compelxity : O(n) #just for iterating over dict
Space Complexity : O(1) #dictionary size = O(26 alphabets)
"""
class Solution:
    def leastInterval(self, tasks: List[str], n: int) -> int:
        d = dict()
        mF = 0
        mC = 0
        for t in tasks:
            count = d.get(t, 0)
            count = count + 1
            mF = max(mF, count)
            d.update({t : count})
            
        for k in d:
            if d.get(k) == mF:
                mC = mC + 1
                
        partition = mF - 1
        available = partition * (n - (mC - 1))
        pending = len(tasks) - (mF * mC)
        idle = max(0, available - pending)
        
        return len(tasks) + idle
