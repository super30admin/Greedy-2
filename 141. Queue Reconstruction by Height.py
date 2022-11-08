class Solution:
    def reconstructQueue(self, people: List[List[int]]) -> List[List[int]]:
        q = list()
        people.sort(key=lambda x: (-x[0], x[1]))

        # sort the array in descending order of height
        # within the same height group, you would sort it in increasing order of k
        # eg: Input : [[7,0],[4,4],[7,1],[5,0],[6,1],[5,2]]
        # after sorting: [[7,0],[7,1],[6,1],[5,0],[5,2],[4,4]]

        # For greedy we'll take maximum height person first so that the further
        # placing of the person won't affect the order

        for i in range(len(people)):
            # we insert people in the queue based on the k
            # k will be the position of the person in the queue
            person = people[i]
            q.insert(person[1], person)

        return q

# Greedy
# Time Complexity: O(n^2)
# Space Complexity: O(1)
# Did this code successfully run on Leetcode : No, Time Limit Exceeded
# Any problem you faced while coding this : No
