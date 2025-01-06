//
//  TaskScheduler.swift
//  TheS30-SwiftTests
//
//  Created by Malav Soni on 05/01/25.
//

import Testing

// MARK: - Task Scheduler Logic
class Task {
    var char: String
    var freq: Int

    init(char: String, freq: Int) {
        self.char = char
        self.freq = freq
    }
}

func leastIntervalWithHeap(_ tasks: [String], _ n: Int) -> Int {
    var freqMap: [String: Int] = [:]
    let heap = Heap<Task>(comparator: { $0.freq > $1.freq })

    for task in tasks {
        freqMap[task, default: 0] += 1
    }

    for (char, freq) in freqMap {
        heap.insert(Task(char: char, freq: freq))
    }

    var taskCount = 0

    while !heap.isEmpty {
        var cycle = n + 1
        var poppedTasks: [Task] = []

        while cycle > 0, let task = heap.poll() {
            task.freq -= 1
            if task.freq > 0 {
                poppedTasks.append(task)
            }
            taskCount += 1
            cycle -= 1
        }

        for task in poppedTasks {
            heap.insert(task)
        }

        if !heap.isEmpty {
            taskCount += cycle
        }
    }

    return taskCount
}

func leastInterval(_ tasks: [String], _ n: Int) -> Int {
    var freqMap: [String: Int] = [:]
    var maxFreq = 0
    var maxCount = 0

    for task in tasks {
        let freq = (freqMap[task] ?? 0) + 1
        freqMap[task] = freq
        maxFreq = max(maxFreq, freq)
    }

    for freq in freqMap.values where freq == maxFreq {
        maxCount += 1
    }

    let partitions = maxFreq - 1
    let availableSlots = partitions * (n - (maxCount - 1))
    let pendingTasks = tasks.count - maxFreq * maxCount
    let idleSlots = max(0, availableSlots - pendingTasks)

    return tasks.count + idleSlots
}

struct TaskSchedulerTests {
    
    struct TestCase {
        let intervals: [String]
        let n: Int
        let expected: Int
    }
    
    static let testCases: [TestCase] = [
        TestCase(intervals: ["A", "A", "A", "B", "B", "B"], n: 2, expected: 8),
        TestCase(intervals: ["A", "A", "A", "B", "B", "B"], n: 3, expected: 10)
    ]

    @Test("Greedy Logic", arguments: testCases)
    func greedyLogicTest(arguments: TestCase) {
        let leastIntervalResult = leastInterval(arguments.intervals, arguments.n)
        #expect(leastIntervalResult == arguments.expected)
    }
    
    @Test("Heap Logic", arguments: testCases)
    func heapLogic(arguments: TestCase) {
        let leastIntervalResult = leastIntervalWithHeap(arguments.intervals, arguments.n)
        #expect(leastIntervalResult == arguments.expected)
    }
}
