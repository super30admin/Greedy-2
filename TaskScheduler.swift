//
//  TaskScheduler.swift
//  DSA-Practice
//
//  Created by Paridhi Malviya on 3/8/26.
//


class TaskScheduler {
    
    
    init() {
        let leastNoOfIntervals = leastInterval(tasks: ["A", "A", "A", "B", "B", "B"], n: 2)
        print("least no of intervals *** \(leastNoOfIntervals)")
    }
    /*
     time complexity - O(n)
     space compelxity - O(1) because maximum 26 characters
     */
    func leastInterval(tasks: [Character], n: Int) -> Int {
        //time complexity - O(n), space - O(1) - maximum 26 characters in hash map
        var charFreqMap = Dictionary<Character, Int>()

        //in first pass, track the frequency of all characters
        var maxFrequency = 0
        for i in 0..<tasks.count { //time - O(n)
            charFreqMap[tasks[i], default: 0] += 1
            maxFrequency = max(maxFrequency, charFreqMap[tasks[i]]!)
        }

        var noOfMaxFrequencyTask = 0
        for key in charFreqMap.keys { //time - O(1)
            if (charFreqMap[key] == maxFrequency) {
                noOfMaxFrequencyTask += 1
            }
        }

        //whatever is the most frequent one, add those with n gap in between
        let partitions = maxFrequency - 1
        let available = partitions * (n - (noOfMaxFrequencyTask - 1))

        let pending = tasks.count - (noOfMaxFrequencyTask * maxFrequency)
        let empty = max(0, available - pending)

        return empty + tasks.count
    }
}
