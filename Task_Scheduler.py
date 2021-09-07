#TC:O(n)
#SC:O(n)
import heapq
from collections import Counter
class Solution:
    def leastInterval(self, tasks: List[str], n: int) -> int:
        if n == 0:
            return len(tasks)
        #store values in a dictionary
        counter_dict = Counter(tasks)
        
        #creating a heap, max heap , by changing the sign of elements,
        #as there is no max heap in python
        heap = []
        # heap = heapq.heapify(heap)
        for label,count in counter_dict.items():
            heapq.heappush(heap,(-count,label))
        
        #number of units to finish task
        count=0
        #list to store all popped elements
        list_val = []
        total=len(tasks)
        #perform till we have elements left in heap
        while(heap):
            #make sure we perform placement for all elements, and 
            #we have n+1 non recurring time
            list_val = []
            for _ in range(n+1):
                if heap:
                    total-=1
                    list_val.append(heapq.heappop(heap))
                    count+=1
            #if len of list_val is not equal to n, that means we need idle timestamps
            # print(list_val,count)
            if len(list_val)<n+1 and total>0:
                count+=n+1-len(list_val)
            #push all elements who have count greater than 0
            for i in range(len(list_val)):
                if abs(list_val[i][0])>1:
                    heapq.heappush(heap,(-(abs(list_val[i][0])-1),list_val[i][1]))
        return count