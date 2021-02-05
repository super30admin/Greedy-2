class Solution(object):
    def reconstructQueue(self, people):
        """
        :type people: List[List[int]]
        :rtype: List[List[int]]
        """
        #O(n2)> iteratively use insert operation
        #O(1)
        if not people:
            return [[]]
        #arrange elements in reverse order of h and if same h> then inc order of k
        def sort(a,b):
            if a[0]==b[0]:
                return a[1]-b[1]
            return b[0]-a[0]
        people=sorted(people,cmp=sort)
     
        #people = sorted(people, key = lambda x: (-x[0], x[1]))
        res = []
        for p in people:
            res.insert(p[1], p)
        return res
    
        
        """"
        I think the author said it's greedy in the sense that short people will not disturb/affect the relative order of taller people so we can start from tallest guy(s), figure out their relative order and and repeat this procedure on shorter guy(s).

Maybe try to comprehend this sentence now from the solution: "shorter guys are 'invisible' to guys people', so we can process guy(s) at height k without worrying about guy(s) at < k height. Then it is a very natural idea to process guy(s) in the descending order of their heights.

This might help, in understanding the solution.
First sort the input array people in such a way that, persons are sorted in descending order of their height, and if multiple persons have same height, then they will be sorted in ascending order of index k. So input array [[7,0], [4,4], [7,1], [5,0], [6,1], [5,2]] will become [[7,0], [7,1], [6,1], [5,0], [5,2], [4,4]]

Next iterate over the sorted array people and add the person people[i] at index people[i][1] of the list result, this solves the problem automagically.

Lets see an e.g.

Input array : [[7,0], [4,4], [7,1], [5,0], [6,1], [5,2]]
After sorting : [[7,0], [7,1], [6,1], [5,0], [5,2], [4,4]]

Next lets iterate over sorted array and add people[i] at index people[i][1] of list result
result => [[7,0]]
result => [[7,0], [7,1]]
result => [[7,0], [6,1], [7,1]]
result => [[5,0], [7,0], [6,1], [7,1]]
result => [[5,0], [7,0], [5,2], [6,1], [7,1]]
result => [[5,0], [7,0], [5,2], [6,1], [4,4], [7,1]]


 It became instantly obvious that persons with the same height should be sorted by the second value: if they have the same height, then they have the same selection criteria for counting, and therefore the one with more selected persons in front of them should be behind.

Then I thought about height. Suppose I take only the tallest persons, all having the same maximum height. Their second values must be 0, 1, 2, 3... with no gaps at all, because they only count each other. Therefore, if there were no other persons at all, their second value must be their final index. What about the persons with second maximum height then? Suppose there are only tallest persons and just one more person who has slightly smaller height. What would be his position? Well, since he obviously only count tallest persons, his position would still be his second value. The next person of the same height counts only the previous person and all the tallest ones, but since they are all already in the queue, his second value would also be his index.

"""""
    