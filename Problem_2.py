"""
Problem : 2

Time Complexity : O(n^2)
Space Complexity : O(n)

Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No

First sort the input in Descending order of the heights, as its easy to
place the person with max height, if height of 2 people are same, then place
the one with lower people in front of it than the other person. 
"""

# Queue Reconstruction by Height

class Solution(object):
    def reconstructQueue(self, people):
        """
        :type people: List[List[int]]
        :rtype: List[List[int]]
        """
        people=sorted(people,key=self.customSort)
        li=[]
        for person in people:
            li.insert(person[1],person)
        # result=[[0,0] for _ in range(len(people))]
        # for i in range(len(li)):
        #     result[i]=li[i]
        return li    
    def customSort(self,slist):
        return (-slist[0],slist[1])