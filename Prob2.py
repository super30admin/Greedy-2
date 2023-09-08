class Solution:
    def reconstructQueue(self, people: List[List[int]]) -> List[List[int]]:

        #TC - intial sort - O(nlogn), insert operation -O(n^2)
        #TC-O(n^2), SC-O(1)

        #logic is intially sort based on height in descindg and then within same hieght in ascedning based on K value.
        #So, that we know where to place the tall elements first, we are only worried about elements of same hieght and taller before us, so sort out the tall ones first. 
        #p[1] is the number of people in front of the current person p who have a height greater than or equal to p's height. In other words, it indicates how many people should be in front of this person in the reconstructed queue. 
        #Placing any number of shorter people before taller people doesn't affect anything so blindly place things at p[1]

        people.sort(key=lambda x: (-x[0],x[1])) #order poeple array in descedning based on hieght and then within saem height based on k value in ascending.

        #before
        #people=[[7,0],[4,4],[7,1],[5,0],[6,1],[5,2]]
        #after
        #people=[[7,0],[7,1][6,1],[5,0],[5,2],[4,4]]
        output=[]
        for p in people:
            output.insert(p[1],p)
            
            #now, blindly place p at index p[1]. 

            #going through each element below,
            #Iteration through the sorted list:
            # Start with [7, 0], insert it at index 0 in output. 
            #output= [[7,0]].
            # Move to [7, 1], insert it at index 1 in output.     
            #output= [[7,0],[7,1]].
            # Move to [6, 1], insert it at index 1 in output. 
            #output=  [[7,0],[6,1],[7,1]].
            # Move to [5, 0], insert it at index 0 in output. 
            #output=  [[5,0],[7,0],[6,1],[7,1]].
            # Move to [5, 2], insert it at index 2 in output. 
            #output=[[5,0],[7,0],[5,2],[6,1],[7,1]].
            # Move to [4, 4], insert it at index 4 in output. 
            #output= [[5,0],[7,0],[5,2],[6,1],[4,4],[7,1]]
        return output
