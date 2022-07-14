'''
time complexity: O(n)
space complexity: O(1)
'''
class Solution:
    def leastInterval(self, tasks: List[str], n: int) -> int:
        countD = {}
        maxFreq=0
        for i in range(len(tasks)):
            freq = countD.get(tasks[i],0)
            freq+=1
            maxFreq = max(maxFreq,freq)
            countD[tasks[i]] = freq
        print(countD)
        maxFreqCount = 0
        for key,value in countD.items():
            if(value == maxFreq):
                maxFreqCount+=1
        totalPart = maxFreq - 1
        print(totalPart)
        totalEmpty = totalPart * (n-(maxFreqCount-1))
        print(totalEmpty)
        available = len(tasks) - (maxFreq*maxFreqCount)
        print(available)
        idle = max(0, totalEmpty - available )
        print(idle)
        return (len(tasks) + idle)
        