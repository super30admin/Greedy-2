#Time Complexity :o(n)
#Space Complexity :o(1)
#Did this code successfully run on Leetcode :yes
#Any problem you faced while coding this :no

class Solution(object):
    def partitionLabels(self, s):
        """
        :type S: str
        :rtype: List[int]
        """
        if(s==None or len(s)==0):
            return []
        
        hmap={}
        
        for i in range(len(s)):
            hmap[s[i]]=i
            
        end=hmap[s[0]]
        res=[]
        sind=0
        for strt in range(len(s)):
            if(end==strt):
                res.append(end-sind+1)
                if(strt+1<len(s)):
                    end=hmap[s[strt+1]]
                    sind=strt+1
    
            elif(hmap[s[strt]] > end ):
                end=hmap[s[strt]]
        return res