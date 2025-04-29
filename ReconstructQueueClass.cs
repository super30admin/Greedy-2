public class Solution {
    // TC => O(n^2)
    // SC => O(n)
    public class CustomComparer : IComparer<int[]>{
        public int Compare(int[] a, int[] b){
            if(a[0] == b[0]){
                return a[1].CompareTo(b[1]);
            }
            return b[0].CompareTo(a[0]);
        }
    }
    public int[][] ReconstructQueue(int[][] people) {
        if(people == null || people.Length == 0){
            return null;
        }
        List<int[]> result = new List<int[]>();
        IComparer<int[]> cc = new CustomComparer();

        Array.Sort(people, cc);

        foreach(var p in people){
            result.Insert(p[1], p);
        }

        return result.ToArray();
    }
}