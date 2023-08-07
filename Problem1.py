#Time complexity: O(n)
#Space complexity: O(n)
#No issues faced while coding:
#Code ran successfully on leetcode
class Solution(object):
    def leastInterval(self, tasks, n):
        """
        :type tasks: List[str]
        :type n: int
        :rtype: int
        """
        #Initializing all the required variables
        map={}
        maxFreq=0
        maxCount=0
        #Iterating through the tasks to get the frequencies 
        for c in tasks:
            if(c not in map):
                map[c]=0
            map[c]+=1
            #We will find the maximum frequencies
            maxFreq=max(maxFreq,map[c])
        #Finidng the maximum count of maxFrequencies
        for key,val in map.items():
            if(val==maxFreq):
                maxCount+=1
        #finding the number of partitions
        partitions=maxFreq-1
        #Finiding the number of slots
        available=partitions*(n-(maxCount-1))
        #No of pending slots
        pending=len(tasks)-maxFreq*maxCount
        #units of idle time required to finish all the tasks
        idle=max(0,available-pending)
        #This is the total time reuqired
        return len(tasks)+idle


        
