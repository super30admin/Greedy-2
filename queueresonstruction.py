# // Time Complexity :O(nlogn + n * n)
# // Space Complexity :O(1)
# // Did this code successfully run on Leetcode :yes
# // Any problem you faced while coding this :no
class Solution:
    def reconstructQueue(self, people: List[List[int]]) -> List[List[int]]:
        output=[] 
        people.sort(key=lambda x: (-x[0], x[1]))                
        for a in people:
            output.insert(a[1], a)
        
        return output  