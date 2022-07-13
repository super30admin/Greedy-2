'''
Time Complexity: O(n)
Space Complexity: 0(n)
Run on leetCode: Yes
'''
class Solution:
    def leastInterval(self, tasks: List[str], n: int) -> int:
        
        
        # 1. initialize a dictionary and store the count of chars in the dictionary
        maxFreq = 0
        charsDict = {}
        for char in tasks:
            if char not in charsDict:
                charsDict[char] = 1
                maxFreq = max(maxFreq,charsDict[char])
                continue
            else:
                charsDict[char] += 1
                maxFreq = max(maxFreq,charsDict[char])
                continue
        # print("maxFreq:\t",maxFreq)
        # 2. get the maxCount of chars in the dict
        maxCount = 0
        for char in charsDict:
            if charsDict[char] == maxFreq:
                maxCount += 1
        # print("maxCount:\t",maxCount)
        # 3. perform the following chks on the basis of visualisation
        '''
        
        A     (B_)  _        A       (B_)  _      A(B)
             partition              partition
        
        partition =  maxFreq-1                              # 2
        availableSlots = partition * (n-(maxCount-1))       # 2
        pendingTasks = len(tasks)-(maxFreq*maxCount)        # 0
        idleSlots = max(0,availableSlots - pendingTasks)    # 2
        '''
        partition = maxFreq-1
        availableSlots = partition * (n-(maxCount-1))
        pendingTasks = len(tasks)-(maxFreq*maxCount)
        idleSlots = max(0,availableSlots - pendingTasks)
        
        '''
        print("partition:\t",partition)
        print("availableSlots:\t",availableSlots)
        print("pendingTasks:\t",pendingTasks)
        print("idleSlots:\t",idleSlots)
        '''
        return len(tasks)+idleSlots
        