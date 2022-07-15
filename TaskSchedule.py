#Time complexity: O(n)
#Space complexity: O(n)
class Solution:
    def leastInterval(self, tasks: List[str], n: int) -> int:
        dict1={}
        maxi=0
        for i in tasks:
            if i not in dict1:
                dict1[i]=0
            dict1[i]+=1
            maxi=max(maxi,dict1[i])
        count=0
        for i in dict1:
            if dict1[i]==maxi:
                count+=1
        partitions= maxi-1
        available= partitions*(n-(count-1))
        pending= len(tasks)-(count*maxi)
        idle= max(0,available-pending)
        return idle+ len(tasks)
        
        