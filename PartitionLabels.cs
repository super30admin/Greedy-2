using System;
using System.Collections.Generic;
using System.Text;

namespace GreedyAlgorithm
{
    class PartitionLabelsLC
    {
        //TC: O(n)
        //SC: O(1)
        //Try Greedy for optimization / maximum / minimum
        public List<int> PartitionLabels(string s)
        {
            List<int> result = new List<int>();
            if (s == null || s.Length == 0)
            {
                return result;
            }
            Dictionary<char, int> map = new Dictionary<char, int>();
            for (int i = 0; i < s.Length; i++)
            {
                char c = s[i];
                map.Add(c, i);
            }
            int start = 0, end = 0;
            for (int i = 0; i < s.Length; i++)
            {
                char c = s[i];
                end = Math.Max(end, map[c]);
                if (i == end)
                {
                    result.Add(end - start + 1);
                    start = end + 1;
                }
            }
            return result;
        }
    }
}
