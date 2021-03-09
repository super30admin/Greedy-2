# Time Complexity : O(n*n)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Three line explanation of solution in plain english
# I first sort the input based on height of the people in descending order and ascending order of number of peaple in front of them.
# Then I go from first to last element and insert it into the result based on the number of people in front

class Solution:
    def reconstructQueue(self, people: List[List[int]]) -> List[List[int]]:
        height_sorted = sorted(people, key=lambda x: (-x[0],x[1]))
        result = []
        for person in height_sorted:
            result.insert(person[1], person)
            
        return result
