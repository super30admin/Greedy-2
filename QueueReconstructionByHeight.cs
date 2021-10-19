using System;
using System.Collections.Generic;
using System.Text;

namespace GreedyAlgorithm
{
    class QueueReconstructionLC
    {
        //TC: O(nlogn + n^2)
        //SC: O(n)
        public int[][] ReconstructQueue(int[][] people)
        {
            if (people == null || people.Length == 0) return new int[0][];
            List<int[]> q = new List<int[]>();
            Array.Sort(people, (a, b)=> {
                if (a[0] == b[0])
                {
                    return a[1] - b[1];
                }
                return b[0] - a[0];
            });
            foreach (int[] person in people)
            {
                q[person[1]] =  person;
            }
            return q.ToArray();
        }
    }
}
