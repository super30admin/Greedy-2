class Solution:
    def reconstructQueue(self, people: List[List[int]]) -> List[List[int]]:
        """Greedy approach
        Time complexity-O(n^2) as we are inserting elements at required index for each element
        Space complexity-O(1)"""
        people=sorted(people, key=lambda x: (x[0],-x[1]), reverse=True)
        arr=[]
        for i in range(len(people)):
            arr.insert(people[i][1], people[i])
        return arr            
