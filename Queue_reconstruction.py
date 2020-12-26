# TIme - O(n)
# space - O(1)
class Solution:
    def reconstructQueue(self, people: List[List[int]]) -> List[List[int]]:
        people.sort(key=lambda x: (-x[0], x[1]))  # sort the height in desc and num of people before a person in asc
        output = []  # new list because if we insert in the same list then i would be TLE- iterate through the same lsit again and again
        for i in people:
            output.insert(i[1], i)  # insert(index,value) in a new list according to the num of people before a person

        return output