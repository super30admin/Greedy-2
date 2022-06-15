using System;
using System.Collections.Generic;
using System.Text;

namespace Array1
{
    class ReconstuctionByHeight
    {
        /*
         * T.C: O(n2) because inserting the array in the list on perticular index cause other elements to move from its original poistion
         * S.C: O(1)
         */
        public int[][] ReconstructQueue(int[][] people)
        {
            List<int[]> result = new List<int[]>();
            Array.Sort(people, (x, y) => {
                if (x[0] == y[0])
                    return x[1] - y[1];
                else
                    return y[0] - x[0];
            });

            foreach (int[] p in people)
            {
                result.Insert(p[1], p);
            }

            return result.ToArray();
        }
    }
}
