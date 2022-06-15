using System;
using System.Collections.Generic;
using System.Text;

namespace Array
{
    public class TaskScheduler
    {
        /*
         * T.C: O(n) where n is no of tasks
         * S.C: O(1) as only 26 chars in the map
         * 
         */
        public int LeastInterval(char[] tasks, int n)
        {

            if (tasks == null || tasks.Length == 0) return 0;

            Dictionary<char, int> map = new Dictionary<char, int>();
            int maxFreq = 0;
            int maxCount = 0;

            for (int i = 0; i < tasks.Length; i++)
            {
                if (!map.ContainsKey(tasks[i]))
                {
                    map.Add(tasks[i], 1);
                }
                else
                {
                    map[tasks[i]]++;
                    maxFreq = Math.Max(maxFreq, map[tasks[i]]);
                }
            }

            foreach (char key in map.Keys)
            {
                if (map[key] == maxFreq)
                {
                    maxCount++;
                }
            }

            int Patitions = maxFreq - 1;
            int emptySlot = Patitions * (n - (maxCount - 1));
            int PendTasks = tasks.Length - (maxFreq * maxCount);
            int idleSlot = Math.Max(0, emptySlot - PendTasks);

            return tasks.Length + idleSlot;

        }
    }
}
