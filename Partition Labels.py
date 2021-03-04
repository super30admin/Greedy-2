class Solution:
    def partitionLabels(self, S: str) -> List[int]:
        #Approach: HashMap
        #Time Complexity: O(n)
        #Space Complexity: O(1)     // max 26 char in hashmaps
    
        countMap = {}
        for char in S:
            countMap[char] = countMap.get(char, 0) + 1
            
        result = []
        currMap, parsed = {}, 0
        for i in range(len(S)):
            char = S[i]
            currMap[char] = currMap.get(char, 0) + 1
            
            if currMap[char] == countMap[char]:
                del currMap[char]
                if not currMap:
                    result.append(i - parsed + 1)
                    parsed = i + 1
                    
        return result