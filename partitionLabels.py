class Solution:
    
    def partitionLabels(self, S: str) -> List[int]:
        
        """
        Description: find lengths of largest possible strings with unique characters
        
        Time Complexity: O(n)
        Space Complexity: O(n)

        Approach: 
        - Use a dictionary to identify frequency of each item
        - for each largest possible string, we can utilize the dictionary to see if the character's maximum index is going beyond a certain point
        - if the index remains under a limit defined by another character at start index, we can identify that as a longest string 
        - update start index to next character in the string and search to find end again and keep appending the resulting list until every character is looked at
        """
        
        from collections import defaultdict
        char_map = defaultdict(int); result = []
        
        for i, char in enumerate(S):
            char_map[char] = i
           
        start = 0; end = 0
        for i, char in enumerate(S):
            end = max(end, char_map[char])
            if i == end:
                result.append(end - start + 1)
                start = i + 1
                
        return result
