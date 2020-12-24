#Time Complexity : O(n^2)
#Space Complexity : O(1)
#Did this code successfully run on Leetcode : Yes

class Solution:
    def reconstructQueue(self, people: List[List[int]]) -> List[List[int]]:
        #sort input array by height (descending order) and if heights are same then by the number of people (ascending order)
        people.sort(key = lambda x: (-x[0], x[1]))
        result = []

        #insert person into correct position
        for person in people:
            result.insert(person[1], person)

        return result
