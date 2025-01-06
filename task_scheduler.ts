import { Heap } from "../../helpers/heap_helper";

class Task {
  char: string;
  freq: number;
  constructor(char: string, freq: number) {
    this.char = char;
    this.freq = freq;
  }
}
// O(m log n)
function leastInterval_with_heap(tasks: string[], n: number): number {
  let freqMap: Map<string, number> = new Map();
  let heap = new Heap<Task>((a, b) => b.freq - a.freq);

  for (const task of tasks) {
    let freq = (freqMap.get(task) || 0) + 1;
    freqMap.set(task, freq);
  }

  for (const item of freqMap) {
    heap.insert(new Task(item[0], item[1]));
  }

  let path: string = "";
  let taskCount: number = 0;

  while (!heap.isEmpty()) {
    let cycle = n + 1;
    let poppedTask: Task[] = [];
    while (cycle > 0 && !heap.isEmpty()) {
      let popped = heap.poll()!;
      popped.freq -= 1;
      if (popped.freq > 0) {
        poppedTask.push(popped);
      }
      path += popped.char;
      cycle--;
      taskCount++;
    }

    for (const task of poppedTask) {
      heap.insert(task);
    }

    while (cycle > 0 && !heap.isEmpty()) {
      path += "_";
      cycle--;
      taskCount++;
    }
  }
  return taskCount;
}

function leastInterval(tasks: string[], n: number): number {
  let maxFreq = 0;
  let maxCount = 0;
  let freqMap: Map<string, number> = new Map();

  for (const task of tasks) {
    let freq = (freqMap.get(task) || 0) + 1;
    freqMap.set(task, freq);
    maxFreq = Math.max(maxFreq, freq);
  }

  for (const item of freqMap) {
    if (item[1] == maxFreq) maxCount++;
  }

  let partition = maxFreq - 1;
  let availableSlot = partition * (n - (maxCount - 1));
  let pendingTask = tasks.length - maxFreq * maxCount;
  let idle = Math.max(0, availableSlot - pendingTask);
  return tasks.length + idle;
}

describe("621. Task Scheduler", () => {
  it("Happy Path - 01", () => {
    expect(leastInterval(["A", "A", "A", "B", "B", "B"], 2)).toEqual(8);
  });

  it("Happy Path - With Heap Logic", () => {
    expect(leastInterval_with_heap(["A", "A", "A", "B", "B", "B"], 2)).toEqual(
      8
    );
  });

  it("Happy Path - With Heap Logic With N = 3", () => {
    expect(leastInterval_with_heap(["A", "A", "A", "B", "B", "B"], 3)).toEqual(
      10
    );
  });
});
