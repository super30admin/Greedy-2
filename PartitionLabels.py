'''
Time Complexity --> O(n)
Space Complexity -->O(n)
'''
class Solution:
    def partitionLabels(self, s: str) -> List[int]:
        res = []
        start = 0
        last = -1
        last_occur = {}
        for i in range(len(s)):
            last_occur[s[i]] = i
        #print(last_occur)
        
        start = 0
        
        res = []
        while start<len(s):

            end = last_occur[s[start]]
            #print(end)
            i = start+1 
            while i<end+1:
            #for i in range(start+1, end+1):
                #print(s[i],end=' ')
                if last_occur[s[i]]>=end:
                    
                    end = last_occur[s[i]]
                    #print(end)
                i+=1
            res.append(end-start+1)
            start = end+1
            #print(start)
        return(res)

            
            
            

        
                

