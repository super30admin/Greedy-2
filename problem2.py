class Solution:
    def reconstructQueue(self, people: List[List[int]]) -> List[List[int]]:
        people.sort(key = lambda x:(x[0],-x[1]), reverse = True)
        res = [None for i in range(len(people))]
        
        for i in people:
            if(res[i[1]]==None):
                res[i[1]]= i
            else:
                res.insert(i[1],i)
        return res[:len(people)]