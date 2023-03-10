class Solution:
    def reconstructQueue(self, people: List[List[int]]) -> List[List[int]]:
        # T.C. = O(nlogn + n^2) insert method has a TC of n^2 since we might have to
        # move all the elements in each iteration
        # S.C. = O(n)
        if people is None or len(people)==0:
            return []

        # We sort the array on basis of height(descending order)
        # if there is a tie-breaker in height, we use the people allowed/k
        # to sort within the same height
        people.sort(key = lambda x: (-x[0],x[1]))

        result = list()

        for person in people:
            # we insert the current person at the index specified at it's 2nd index
            # it will push the element at the present index to the next index
            result.insert(person[1],person)

        return result