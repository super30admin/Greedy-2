# // Time Complexity :O(n)
# // Space Complexity :O(1)
# // Did this code successfully run on Leetcode :Yes
# // Any problem you faced while coding this :No

# we first sort them based on height in descending order - then we take each element one by one add them as their index in resut
class Solution(object):
    def reconstructQueue(self, people):
        """
        :type people: List[List[int]]
        :rtype: List[List[int]]
        """
        
        people.sort(key=lambda person: (-person[0], person[1]))
        ans = []
        for person in people:
            ans.insert(person[1], person)
        return ans

        