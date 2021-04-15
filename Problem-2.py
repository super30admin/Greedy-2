#Time Complexity :o(nlogn)
#Space Complexity :o(1)
#Did this code successfully run on Leetcode :yes
#Any problem you faced while coding this :no

class Solution(object):
    def reconstructQueue(self, people):
        """
        :type people: List[List[int]]
        :rtype: List[List[int]]
        """
        if(people==None or len(people)==0):
            return [[]]

        people.sort(key=lambda a:(-a[0],a[1]))

        ans=[]
        for i in people:
            ans.insert(i[1],i)
        return ans