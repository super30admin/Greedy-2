# Time Compelxity : O(N) # N is number of elements in dict
# Space Complexity : O(1) # dictionary size = O(26 alphabets)

class Solution:
    def leastInterval(self, tasks: List[str], n: int) -> int:
        dic = dict()
        mF = 0
        mC = 0
        for task in tasks:
            count = dic.get(task, 0)
            count = count + 1
            mF = max(mF, count)
            dic.update({task : count})
            
        for k in dic:
            if dic.get(k) == mF:
                mC = mC + 1
                
        partition = mF - 1
        avail = partition * (n - (mC - 1))
        pending = len(tasks) - (mF * mC)
        idle = max(0, avail - pending)
        
        return len(tasks) + idle
