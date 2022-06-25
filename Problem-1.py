class Solution:
    def leastInterval(self, tasks: List[str], n: int) -> int:
        hashmap={}
        for task in tasks:
            hashmap[task]=hashmap.get(task,0)+1
            
        max_frequency=max(hashmap.values())
        max_count=0
        for value in hashmap.values():
            if value==max_frequency:
                max_count+=1
                
        partitions=max_frequency - 1
        empty= (n - max_count + 1) * partitions
        pending= len(tasks)- (max_frequency*max_count)
        idle=max(0,empty-pending)
        
        return len(tasks)+idle