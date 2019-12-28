'''
406. Queue Reconstruction by Height - https://leetcode.com/problems/queue-reconstruction-by-height/
Time complexity - O(N2) 
space complexity - O(N)

Approach - 1) sort heights in descending order 
           2) insert K in ascending order
'''
class Solution:
    def reconstructQueue(self, people: List[List[int]]) -> List[List[int]]:
        #sorting heights in descending order
        people.sort(key= lambda x: (-x[0],x[1]))
        
        res=[]
        #inserting based on k
        for i in people:
            res.insert(i[1],i)
        return res
            
        
