// ## Problem1 Task Scheduler (https://leetcode.com/problems/task-scheduler/)

// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

/**
 * @param {character[]} tasks
 * @param {number} n
 * @return {number}
 */
var leastInterval = function (tasks, n) {
    if (tasks === null || tasks.length === 0)
        return 0;

    let len = tasks.length;
    let map = new Map();
    let maxFreq = 0;
    // Map character and their frequency.
    // Maintain maxFreq encountered
    for (let i = 0; i < len; i++) {
        let ch = tasks[i]
        if (!map.has(ch)) {
            map.set(ch, 0);
        }
        let count = map.get(ch);
        count += 1;
        map.set(ch, count)
        maxFreq = Math.max(maxFreq, count);
    }

    // Count number of distinct chars with maxFreq
    let maxFreqCount = 0;
    map.forEach((val) => {
        if (val === maxFreq)
            maxFreqCount++;
    });
    // Tatal partitions available
    let partitions = maxFreq - 1;
    // We put chars with max freq together and then calculate remaining empty spaces
    let empty = partitions * (n - (maxFreqCount - 1));
    // Number of characters remaining to put
    let remaining = len - (maxFreq * maxFreqCount);
    // Number of Idle spaces left, these will be added to tatoal tasks to get the result
    let idle = Math.max(0, empty - remaining);

    return len + idle;
};