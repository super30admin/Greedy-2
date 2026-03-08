/**
 * @param {string} s
 * @return {number[]}
Intuition:
First record the last index of every character in the string so we know how far a character forces a partition to extend.
Starting from a position 'i', expand the partition’s 'endIdx' to the furthest last occurrence of any character inside the current segment.
When all characters in the segment end within this boundary, we cut the partition and record its length, ensuring each character appears in only one partition.
T.C: O(n)
S.C: O(1)
*/
var partitionLabels = function (s) {
    let n = s.length;
    let endIdxMap = new Map();
    for (let i = 0; i < n; i++) {
        let currChar = s[i];
        endIdxMap.set(currChar, i);
    }
    let result = [];
    for (let i = 0; i < n; i++) {
        let currChar = s[i];
        let endIdx = endIdxMap.get(currChar);
        for (let j = i + 1; j <= endIdx; j++) {
            let char = s[j];
            let charEndIdx = endIdxMap.get(char);
            endIdx = Math.max(endIdx, charEndIdx);
        }
        result.push(endIdx - i + 1);
        i = endIdx;
    }
    return result;
};