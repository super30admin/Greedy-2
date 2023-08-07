#Time complexity is O(n^2)
#Space complexity is O(1)
#No issues faced while coding
#Code ran successfully on leetcode
class Solution(object):
    def reconstructQueue(self, people):
        """
        :type people: List[List[int]]
        :rtype: List[List[int]]
        """
        #Initializing the required array
        result=[]
        #Sorting array in such a way that it will be sorted
        #in the decreasing order of the ist value and increasing order of second value
        people.sort(key=lambda x:(-x[0],x[1]))
        #We will be iterating through the people
        for i in people:
            #We will be inserting into the result array at i[1]th index
            result.insert(i[1],i)
        #Finally return result
        return result

        