# TimeComplexity:O(nlogn)
# SpaceComplexity:O(1) ,answer is not considered
# Appraoch:
# Each people[i] = [hi, ki] represents the ith person of height hi with exactly ki other people in front who have a height greater than or equal to hi.
# sort people basedon  ki here our bottleneck wouldbe samller guys cause order might chnage
# so fix larger guys first then insert samller guys in between 
# we have [7,0],[7,1] and we are  at [6,1]
# we can directly inser [6,1] at 1st idx such that it  our main condition wont fail and there are exacly one person with greater height than 6 and [7,1] has exactl;y oneperson with greater or 
# equal height so no matter which height<7 you put in betweeen [7,0] and [7,1] ,main conditionwont fail







class Solution:
    def reconstructQueue(self, people: List[List[int]]) -> List[List[int]]:

        # eg: Input : [[7,0],[4,4],[7,1],[5,0],[6,1],[5,2]]
        # after sorting: [[7,0],[7,1],[6,1],[5,0],[5,2],[4,4]]
        people.sort(key=lambda x: (-x[0], x[1]))
        ans=[]
        for pep in people:
            #idx,num
            ans.insert(pep[1],pep)
            # print(ans,pep[0])
        return ans


        
