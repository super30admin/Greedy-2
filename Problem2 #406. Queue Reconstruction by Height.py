# Time Complexity : O(N ** 2)
# Space Complexity : O(N)

class Solution:
    def reconstructQueue(self, people: List[List[int]]) -> List[List[int]]:
        #sort according to h(i)
        people = sorted(people, key = lambda x: (-x[0], x[1])) #n log(n)
    
        result = list()    
        #re-arrange according to k(i)
        for i in range(0, len(people)):
            hi, ki = people[i]
            print(hi, ki)
            result.insert(ki, people[i])
            
        return result
