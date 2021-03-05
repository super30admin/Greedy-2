class Solution:
    #Solution 1
    def partitionLabels(self, S: str) -> List[int]:
        #Approach: HashMap + Two pointers  //  Greedy
        #Time Complexity: O(n)
        #Space Complexity: O(1)     // max 26 char in hashmap
        #where, n is the length of S
        
        lastIdx = {}
        for i in range(len(S)):
            lastIdx[S[i]] = i
            
        result = []
        start = end = 0
        
        for i in range(len(S)):
            end = max(end, lastIdx[S[i]])
            if i == end:
                result.append(end - start + 1)
                start = end + 1
                
        return result
    
    #Solution 2
    """
    def partitionLabels(self, S: str) -> List[int]:
        #Approach: Two HashMaps  //  Greedy
        #Time Complexity: O(n)
        #Space Complexity: O(1)     // max 26 char in hashmaps
        #where, n is the length of S
    
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
    """