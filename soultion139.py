#Time Complexity:O(n)
#Space Complexity:O(n)
class Solution:
    def leastInterval(self, tasks: List[str], n: int) -> int:
        if len(tasks)==0:
            return 0
        dict={}                                             #Declare a hash map to hold a counter of each task
        for elem in tasks:
            if elem not in dict:
                dict[elem]=0
            dict[elem]+=1
        maxFreq=max(dict.values())                          #obtain the task with max frequency
        maxCount=sum(x==maxFreq for x in dict.values())     #check the number of tasks with same max freq
        partition=maxFreq-1                                 #the number of partitions possible in the interval
        empty=(n-(maxCount-1))*partitions                   #calculate the number of empty slots using the previously calculated variables
        available=len(tasks)-maxFreq*maxCount               #check the vacant spaces left that can be schedules with tasks 
        idle=max(0,empty-available)                         #check how many of the tasks are idle and has to be schedules later
        result=len(tasks)+idle                              #return result which is the sum of tasks and idle tasks
        return result