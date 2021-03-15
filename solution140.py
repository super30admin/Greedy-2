#Time Complexity:O(n^2)
#Space Complexity:O(1)
#Approach:The people array is first sorted in descending order according to the 2nd element of sublists and then sorted according to the first 
#element of the sublist.The sorted aray is then parsed and elements are inserted into the result array based on the position defined in the
#second position of the sublist.
class Solution:
    def reconstructQueue(self, people: List[List[int]]) -> List[List[int]]:
        people.sort(key= lambda x: (x[0],-x[1]),reverse=True)
        result=[]
        for person in people:
            result.insert(person[1],person)
        return result