public class Solution {

    // TC => O(n)
    // SC => O(1)
    public IList<int> PartitionLabels(string s) {
        if(s == null || s.Length == 0){
            return new List<int>();
        }

        IList<int> result = new List<int>();
        Dictionary<char, int> lookup = new Dictionary<char, int>();

        for(int i = 0; i< s.Length;i++){
            lookup.TryAdd(s[i], 0);
            lookup[s[i]] = i;
        }

        int start = 0, end = 0;
        for(int i = 0; i< s.Length;i++){
            if(lookup[s[i]] > end){
                end = lookup[s[i]];
            }
            if(i == end){
                result.Add(end - start + 1);
                start = i + 1;
            }
        }
        return result;
    }
}