using System;
using System.Collections.Generic;
using System.Text;

namespace Strings
{
    public class PartitionLabel
    {
        /*
         * T.C: O(N) : since we are traversing through all the chars in string
         * S.C: O(1) : as only lower alphabets are stored in the dictionary which is 26 constant
         * 
         */

        public IList<int> PartitionLabels(string s)
        {

            if (s == null || s.Length == 0) return new List<int>();

            Dictionary<char, int> map = new Dictionary<char, int>();
            int start = 0;
            int end = 0;
            List<int> result = new List<int>();

            for (int i = 0; i < s.Length; i++)
            {
                char c = s[i];
                if (!map.ContainsKey(c))
                {
                    map.Add(c, i);
                }
                map[c] = i;
            }


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
