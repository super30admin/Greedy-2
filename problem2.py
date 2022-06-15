
# Queue Reconstruction by Height
# // Time Complexity : O(N^2)
# // Space Complexity :O(1)
# // Did this code successfully run on Leetcode :yes
# // Any problem you faced while coding this :no



class Solution:
    def reconstructQueue(self, people: List[List[int]]) -> List[List[int]]:
        
        people.sort(key = lambda x:(-x[0],x[1]) )
        res=[]
        for i in people:
            res.insert(i[1],i)
        return res
            
            
        