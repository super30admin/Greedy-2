class Solution:
    def reconstructQueue(self, people: List[List[int]]) -> List[List[int]]:
        if len(people) == None or people == 0:return[[]]
        # people = sorted(people, key = lambda x: (-x[0], x[1]))
        people = sorted(people, key = lambda x: (-x[0], x[1]))
        print(people)
        result = []
        for p in people:
            result.insert(p[1], p)
        return result
    
# T.C=> O(n * n)
# S.C =>O(n)
# approach => Here we are sorting array in descinding order based on there first index, and if two values are same the sort them based on the second index. Ones you get the array in descinding order just put the elements based on tere index values