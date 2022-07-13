'''
Time Complexity: O(n)
Space Complexity: 0(n)
Run on leetCode: Yes
'''
class Solution:
    def partitionLabels(self, s: str) -> List[int]:
        # define a dictionary that stores the last index of alphabet occurance
        alphaDict = {}
        for i in range(0,len(s)):

            alpha = s[i]

            if alpha not in alphaDict:
                alphaDict[alpha] = i
                continue
            # else --- update the value to latest occuring index
            alphaDict[alpha] = i
        
        # now iterate the list and define the partitions
        start = 0
        itr = 0
        end = alphaDict[s[0]]
        
        # partition List
        partitionList = []
        
        while itr < len(s):
            # get alphabet
            alpha = s[itr]
            
            if itr < end and alphaDict[alpha] > end:
                # update the end 
                end = alphaDict[alpha]
            
            elif itr == end and alphaDict[alpha] > end:
                # update the end 
                end = alphaDict[alpha]
            
            elif itr == end:
                # itr == end
                count = end-start+1
                partitionList.append(count)
                start = itr+1
                end = itr+1
            
            # update the itr 
            itr += 1
        '''end of while loop'''
        
        # print(partitionList)
        return partitionList  
                