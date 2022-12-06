// ## Problem2 Queue Reconstruction by Height (https://leetcode.com/problems/queue-reconstruction-by-height/)

// Time Complexity :O(n*nlogn)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

/**
 * @param {number[][]} people
 * @return {number[][]}
 */
var reconstructQueue = function (people) {
    if (people === null || people.length === 0)
        return people;

    // Sort in descending order of height
    people.sort((a, b) => {
        if (a[0] === b[0]) {
            return a[1] - b[1];
        }
        return b[0] - a[0];
    })
    let result = [];
    // Place people at index same as number of people that should be ahead of them
    for (let i = 0; i < people.length; i++) {
        let person = people[i];
        result.splice(person[1], 0, person)
    }
    return result
};