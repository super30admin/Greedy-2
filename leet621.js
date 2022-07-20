TC - O(N)
SC - O(1)

/**
 * @param {character[]} tasks
 * @param {number} n
 * @return {number}
 */
const leastInterval = function(tasks, n) {
  if (n === 0) return tasks.length; 
  const counts = Array.from(counter(tasks).values());
  
  // sort at most 26 numbers, O(1)
  counts.sort((a, b) => b - a);
  
  const most = counts[0]; 
  let idle = (most - 1) * n;
  
  for (let i = 1; i < counts.length; i += 1) {
    // count range is [1, most]
    
    // idle we can fill at most [most- 1]
    idle -= Math.min(counts[i], most - 1, idle);
    
    // can't be negative
    if (idle === 0) break;
  }
  
  return tasks.length + idle;
};

const counter = (tasks) => {
  const map = new Map();
  
  for (const task of tasks) {
    map.set(task, (map.get(task) || 0) + 1);
  }
  
  return map;
}