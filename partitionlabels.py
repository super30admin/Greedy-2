# brute force solution
# from every character split the string and check whether the characters from every other partition is present in the previous partitions.
# Time complexity - O(n^n)
# Space complexity - O(n) # recursive stack
# Did this code run on leetcode? - No (TLE)
class Solution:
    def partitionLabels(self, S: str) -> List[int]:
        
        def rec(prevstrings, S):
            # print(prevstrings, S)
            n = len(S)
            if n==0:
                counts = []
                for prevstr in prevstrings:
                    counts.append(len(prevstr))
                return counts
            for i in range(1,n+1):
                prevstrings1=prevstrings.copy()
                repeat = False
                for ch in S[:i]:
                    for prevstr in prevstrings1:
                        if ch in prevstr:
                            repeat = True
                if not repeat:
                    prevstrings1.append(S[:i])
                    counts = rec(prevstrings1, S[i:])
                    if counts:
                        return counts
            return False
                    
        return rec([], S)


# Time complexity - O(n)
# Space complexity - O(n) # recursive stack
# Did this code run on leetcode? - No (TLE)
# STEPS:
# Two pointers solution -
# Store the last position of every character in a hash map.
# Keep a start pointer at index 0 (beginning of a new unique character string)
# place end pointer at the end location of that character on index 0.
# keep moving the window end location if the end location of any characters between start and end is greater than the previous end.
# when the new ptr reaches the end, note the length of the string and add it to the result.
# Reset the start pointer to the index: start = end + 1. 
# Reset end pointer to the location of last position of the character at the new start location.
class Solution:
    def partitionLabels(self, S: str) -> List[int]:
        # last position of every character in the string.
        shash = dict()
        for i,ch in enumerate(S):
            if ch not in shash:
                shash[ch] = i
            shash[ch] = i
        
        n = len(S)
        start = 0
        answer = []
        while start<n:
            end = shash[S[start]]
            ptr1 = start
            while ptr1<end:
                ch = S[ptr1]
                if shash[ch] > end:
                    end = shash[ch]
                ptr1+=1
            
            answer.append(end-start+1)
            start = end+1
        return answer
        