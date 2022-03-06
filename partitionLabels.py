class Solution:
    def partitionLabels(self, s: str) -> List[int]:
        '''
        T = O(N)
        S = O(N)
        '''
        result = []
        if not s : return result 
        hash_ = {}
        for i in range(len(s)):
            c = s[i]
            hash_[c] = i 
        start , end = 0 ,0 
        for i in range(len(s)):
            c = s[i]
            end = max(end, hash_[c] )
            if i == end:
                result.append( end - start + 1)
                start = end + 1
        return result  
