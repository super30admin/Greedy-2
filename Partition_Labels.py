class Solution:
    def partitionLabels(self, s: str) -> List[int]:
        
        if not s :
            return []
        
        result = [] 
        last_char = {c:i for i,c in enumerate(s) }
        print(last_char)
        
        start = 0
        end = 0
        
        for idx,char in enumerate(s):
            end  = max(end,last_char[char])
            if end == idx:
                result.append(end- start +1)
                start = end +1
        return result
            
            
            
        
        
        
