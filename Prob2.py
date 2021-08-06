class Solution(object):
    def reconstructQueue(self, people):
        """
        :type people: List[List[int]]
        :rtype: List[List[int]]
        """

        people.sort(key = lambda x:(x[0],-1*x[1]),reverse = True)
        result = []
        for person in people:
            result.insert(person[1],person)
        
        return result
        
