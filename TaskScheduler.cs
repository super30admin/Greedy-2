using System;
using System.Collections.Generic;
using System.Text;

namespace GreedyAlgorithm
{
    //TC: O(n)
    //SC: O(1)
    class TaskSchedulerLC
    {
        public int LeastInterval(char[] tasks, int n)
        {
            if (tasks == null || tasks.Length == 0) return 0;
            Dictionary<char, int> map = new Dictionary<char, int>();
            int max = 0, maxCount = 0;
            for (int i = 0; i < tasks.Length; i++)
            {
                map.Add(tasks[i], map.GetValueOrDefault(tasks[i], 0) + 1);
                max = Math.Max(max, map[tasks[i]]);
            }
            foreach (char key in map.Keys)
            {
                if (max == map[key])
                {
                    maxCount++;
                }
            }
            int partitions = max - 1;
            int available = partitions * (n - maxCount + 1);
            int pending = tasks.Length - (max * maxCount);
            int idle = Math.Max(0, available - pending);
            return tasks.Length + idle;
        }
    }
}
