"""
SOrt the array in desccending order based on heights , if heights are equal sort based on number of people in front.
 Iterate through the sorted list and insert based on numbe of people in front
TC: O(nlogn) + O(n^2) to sort the array and insert
SP: O(n)
"""
class Solution:
    def reconstructQueue(self, people: List[List[int]]) -> List[List[int]]:
        people.sort(key=lambda x: (-x[0], x[1]))
        res = []
        for i, p in enumerate(people):
            res.insert(p[1], p)
        return res
