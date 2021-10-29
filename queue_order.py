# // Time Complexity :O(n^2)
# // Space Complexity :O(n)
# // Did this code successfully run on Leetcode :yes
# // Any problem you faced while coding this :no


# // Your code here along with comments explaining your approach
class Solution:
    def reconstructQueue(self, people: List[List[int]]) -> List[List[int]]:
        print(people)
        people.sort(key=lambda x: (-x[0],x[1]))
        
        result=[]
        for i in people:
            result.insert(i[1],(i[0],i[1]))
        
        return result