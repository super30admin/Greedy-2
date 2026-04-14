//
//  PartitionLabels.swift
//  DSA-Practice
//
//  Created by Paridhi Malviya on 3/9/26.
//

class Parititionlabels {
    
    init() {
        
    }
    
    /*
     time complexity - O(n)
     space complexity - O(1)
     */
    func partitionLabels(_ s: String) -> [Int] {
        var lastIndexMap = [Character: Int]()
        for (index, char) in s.enumerated() {
            lastIndexMap[char] = index
        }
        var result = [Int]()
        var maxReach = 0
        var startIndex = 0
        for (index, char) in s.enumerated() {
            let lastOccOfChar = lastIndexMap[char]!
            maxReach = max(maxReach, lastOccOfChar)
            if (index == maxReach) {
                result.append(index - startIndex + 1)
                startIndex = index + 1
                maxReach = index + 1
            }
        }
        return result
    }
}
