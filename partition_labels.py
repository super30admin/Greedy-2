#Time => O(n)
#Space => O(1)

class Solution:
    def partitionLabels(self, s: str) -> List[int]:
        
        lastIndex={}
        #Keeping the track of last occurance of the letters
        for i,c in enumerate(s):
            lastIndex[c]=i
         
        #Storing the result and having size and end variables
        res=[]
        size,end=0,0
        
        #Looping and increasing the size accordingly
        for i,c in enumerate(s):
            size+=1
            #If the index occurance is greater than the end then we update the end               #variable
            if lastIndex[c]>end:
                end=lastIndex[c]
            
            #When we reach the end then we append the size to res and reset it to 0
            if i==end:
                res.append(size)
                size=0
                
        return res