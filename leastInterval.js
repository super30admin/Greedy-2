/**
 * @param {character[]} tasks
 * @param {number} n
 * @return {number}
 * https://leetcode.com/problems/task-scheduler/
 Interval:
 Place the most frequent task first because it determines the minimum spacing needed.
 Arrange them as '(maxFreq - 1)' partitions, each needing 'n' cooldown slots between identical tasks.
 Fill those slots with other tasks; if they run out, idles remain, so the answer is `tasks.length + remaining idle slots.
 T.C: O(n)
 S.C: O(1)
 */
var leastInterval = function(tasks, n) {
    let length = tasks.length;
    let freqObj = {};
    let maxFreq = -Infinity;
    let maxFreqEle = 0;
    for(let i = 0; i<tasks.length; i++){
      let task = tasks[i];
      if(task in freqObj){
        freqObj[task]++;
      }else{
        freqObj[task] = 1;
      }
      maxFreq = Math.max(maxFreq, freqObj[task]);
    }

    for(let val of Object.values(freqObj)){
        if(val === maxFreq) maxFreqEle++;
    }

    let partitions = maxFreq - 1;
    let avlSlots = partitions * (n - (maxFreqEle - 1));
    let pendingTasks = length - (maxFreq * maxFreqEle);
    let emptySlots = Math.max(0, avlSlots - pendingTasks);
    return length + emptySlots;
};