#Time complexity: O(N^2)
#Space Complexity: O(N)
class Solution(object):
    def reconstructQueue(self, people):
        """
        :type people: List[List[int]]
        :rtype: List[List[int]]
        """
        # Step 1: Sort by height(desc), k(asc)
        people.sort(key=lambda x: (-x[0], x[1]))
        print(people)
        queue = []
        # Step 2: Greedily insert at index k
        for person in people:
            queue.insert(person[1], person) # insert at current index by shifting the existing elemnet to the right
        return queue
    