# Time: O(n*n)
# Space: O(1)
class Solution(object):
    def reconstructQueue(self, people):
        """
        :type people: List[List[int]]
        :rtype: List[List[int]]
        """
        def compare(item1, item2):
            if item1[0] == item2[0]:
                return item1[1] - item2[1]
            return item2[0] - item1[0]
                

        # Calling
        people = sorted(people, cmp=compare)
        #print(people)
        result = []
        for i in range(len(people)):
            #print(people[i][1], people[i])
            result.insert(people[i][1], people[i])
        return result
        
