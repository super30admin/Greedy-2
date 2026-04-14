//
//  QueueReconstruction.swift
//  DSA-Practice
//
//  Created by Paridhi Malviya on 3/9/26.
//

class QueueReconstruction {
    
    
    init() {
        
    }
    
        //time complexity - O(n log n)
        //insertion, shifting - O(n) worst case per insertion
        //So, O(n^2)
        //Space - O(n)
    /*
     Why greedy - greedily, we are placing the taller cases first. Then smaller people were getting adjusted around it.
     Bruteforce - calculate all permutations in a exponential manner.
     */
        func reconstructQueue(_ people: [[Int]]) -> [[Int]] {
            //first sort by decreasing order by their heights. and if multiple entries has same height, sort by decreasing order
            var sortedPeople = people.sorted(by: {(a, b) in
                if (a[0] == b[0]) {
                    return a[1] < b[1]
                }
                return a[0] > b[0]
            })

            var result = [[Int]]()
            for person in sortedPeople {
                result.insert(person, at: person[1])
            }

            return result
        }
}
