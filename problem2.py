#Time complexity: O(nlogn)
#space complexity: O(n)
#ran on leetcode: Yes
#sort  the array in decreasing order of 1st element and when there is a tie, increasing order of 2nd element. Loop through the sorted list and insert the elements in position of ki
class Solution:
    def reconstructQueue(self, people: List[List[int]]) -> List[List[int]]:
        people=sorted(people,key=lambda x:(-x[0],x[1]))
        print(people)
        L=[people[0]]
        for i in range(1,len(people)):
            L.insert(people[i][1],people[i])
        return L
