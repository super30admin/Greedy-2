'''
Time Complexity --> O(nlogn)
Space Complexity --> O(1)
'''
class Solution:
    def reconstructQueue(self, people: List[List[int]]) -> List[List[int]]:
        people = sorted(people, key = lambda x:(x[1]))
        people = sorted(people, key = lambda x:(x[0]), reverse = True)
        print(people)
        q = []
        for i in range(len(people)):
            q.insert(people[i][1], people[i])
            #print(q)
        return q
