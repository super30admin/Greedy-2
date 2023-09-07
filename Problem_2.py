# Time Complexity: O(n^2)
# Space Complexity: O(n)
# Did this problem run on Leetcode: Yes
# Any issues faced doing this problem: No

class Solution(object):
    def reconstructQueue(self, people):
        """
        :type people: List[List[int]]
        :rtype: List[List[int]]
        """
        output = [] 
        people.sort(key = lambda x: (-x[0], x[1]))                
        for a in people:
            output.insert(a[1], a)
        return output