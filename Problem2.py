#Time Complexity : O(N*N)
#Space Complexity : O(N)
class Solution:
    def reconstructQueue(self, people: List[List[int]]) -> List[List[int]]:
        people.sort(key=lambda element:element[1])
        people.sort(key=lambda element:element[0], reverse=True)
        queue = []  
        for i in range(len(people)):
            index = people[i][1]
            queue.insert(index,people[i])
            
        return queue
            
            
        
            