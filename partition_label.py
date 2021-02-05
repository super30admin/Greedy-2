class Solution(object):
    def partitionLabels(self, S):
        """
        :type S: str
        :rtype: List[int]
        """
        #O(2n)
        #O(26)
        if not S:
            return []
        mp={}
        #store last position of each char in string
        for i in range(len(S)):
            c=S[i]
            mp[c]=i
        start=0
        end=0
        res=[]
        #update end location for each character if it doesnt fall under current partition> thus increasing partition
        for i in range(len(S)):
            c=S[i]
            end=max(end,mp[c])
            #when pointer reaches end of current partition that means chars are good
            if i==end:
                res.append(end-start+1)
                #start from one char next to current partition end
                start=i+1
        return res
        