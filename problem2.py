#Time O(n*2), space O(1)
class Solution:
    def reconstructQueue(self, people: List[List[int]]) -> List[List[int]]:
        #Sort the array in reverse order and if same sort with respect to frequency
        people.sort(key=lambda x:(-x[0],x[1]))
        res=[]
        print(people)
        #Traversing through the list and putting the values according to their frequencies
        for i in range(len(people)):
            res.insert(people[i][1],people[i])
            print(people[i][1],people[i])
        return res
