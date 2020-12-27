# Time:- O(n^2)
# Space:- O(1)
# Approach:- Sort the people accroding to the height(descending) first and then according their 
# position(ascending). This is because the person of a greater height can be repositioned in the queue
# So we insert people according the highest height first and then according to their 
# position(how many people are standing in front of them)
class Solution:
    def reconstructQueue(self, people: List[List[int]]) -> List[List[int]]:
        # custom comparator-> sort by height descending and position ascending
        def sort_people(a,b):
            if (a[0]==b[0] and a[1]<b[1]) or a[0]>b[0]:
                return -1
            return 1
        people=sorted(people,key=functools.cmp_to_key(sort_people))
        res=[]
        for i,j in people:
            if j>=len(res):
                res.append([i,j])
            else:
                # insert according to their position
                res.insert(j,[i,j])
        return res