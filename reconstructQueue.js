/**
 * @param {number[][]} people
 * @return {number[][]}
Intuition:
Sort people by height in descending order, and if heights are equal, by 'k' in ascending order so taller people are placed first.
Insert each person at index 'k' in the result array, ensuring exactly k taller (or equal height) people appear before them.
Since taller people are already fixed in the queue, inserting shorter ones later won’t disturb the taller people's constraints, producing the correct reconstruction.
T.C: O(n^2)
S.C: O(1)
*/
var reconstructQueue = function (people) {
    // sort the array
    people.sort((a, b) => {
        if (a[0] === b[0]) return a[1] - b[1];
        else return b[0] - a[0];
    });
    let result = [];
    // rearrange the queue
    for (let p of people) {
        result.splice(p[1], 0, p);
    }
    return result;
};