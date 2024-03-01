#Time Complexity : O(N^2)
#Space Complexity : O(N)



class Solution:
    def reconstructQueue(self, people):
        def sort_key(p):
            return (-p[0], p[1])
        
        people.sort(key=sort_key)
        output = []
        for p in people:
            output.insert(p[1], p)
        return output
