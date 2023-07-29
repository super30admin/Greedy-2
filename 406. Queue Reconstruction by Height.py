#Time Complexity:O(nlogn)
#Space Complexity:O(1)

class Solution(object):
    def reconstructQueue(self, people):
        """
        :type people: List[List[int]]
        :rtype: List[List[int]]
        """
        result=[]
        if len(people)==0:
            return[[]]
        people.sort(key=lambda x: (-x[0], x[1]))   
        for pep in people:
            result.insert(pep[1],pep)
        return result
