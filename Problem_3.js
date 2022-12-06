// ## Problem3 Partition Labels (https://leetcode.com/problems/partition-labels/)

// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

/**
 * @param {string} s
 * @return {number[]}
 */
var partitionLabels = function (s) {
    if (s === null || s.length === 0)
        return [];
    let map = new Map();
    let result = [];
    // Map all the char and the last index they have occured
    for (let i = 0; i < s.length; i++) {
        map.set(s[i], i);
    }
    // mark start and end
    let start = 0;
    let end = map.get(s[0]);
    for (let i = 0; i < s.length; i++) {
        let ch = s[i];
        // Update end if the new character comes after the old character in string
        end = Math.max(end, map.get(ch));
        // If i === end, add the length to result
        if (i === end) {
            result.push(end - start + 1);
            start = i + 1;
        }
    }
    return result;
};
