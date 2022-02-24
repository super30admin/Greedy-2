class Solution:
    def partitionLabels(self, s: str) -> List[int]:
        if s == None or len(s) == 0: return []
        result = []
        map = {}
        for i in range(0, len(s)):
            map[s[i]] = i
        print(map)
        start = 0
        end = 0
        for j in range(0, len(s)):
            end = max(end, map.get(s[j]))
            if j == end:
                result.append(end - start + 1)
                start = end + 1
        return result
    
# T.C => O(N)
# S.C =>(1) 
# Approach => Here we have taken all the ending index of a particular character and just iterating through string and fing the partion till end. Ones the end is found start from next index and find next partions