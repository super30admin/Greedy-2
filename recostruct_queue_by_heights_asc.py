# Time Complexity : O(P*P) where P is number of people in the queue
# Space Complexity : O(1) 
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

class Solution:
    def reconstructQueue(self, people: List[List[int]]) -> List[List[int]]:
        result = [[-1,-1] for _ in range(len(people))]
        people.sort(key= lambda x: (x[0], x[1]))
        
        for p in people:
            count = p[1]
            
            for j in range(len(result)):
                if count == 0 and result[j][0] == -1:
                    result[j] = p
                    break
                else:
                    if result[j][0] == -1 or result[j][0] >= p[0]:
                         count -= 1    
        return result