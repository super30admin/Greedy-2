#Leetcode : Pass
# TC - O(n^2) , SC-O(1)
# 1) Sort the people array in descending order of h, if heights are same then asc order of k
# 2) insert each person according to the index value
class Solution:
    def reconstructQueue(self, people: List[List[int]]) -> List[List[int]]:
        #1
        people.sort(key= lambda x: (-x[0],x[1]))
        #for i in range(len(people)-1):
         #   for j in range(i+1,len(people)):
          #      if people[i][0]< people[j][0]:
           #         people[i], people[j]= people[j],people[i]
            #    if people[i][0] == people[j][0]:
             #       if people[i][1]> people[j][1]:
              #          people[i], people[j]= people[j],people[i]
        output=[]
        #2
        for person in people:
            output.insert(person[1],person)
        return output
