//Time Complexity: o(n^2)
//Space Complexity: o(1)
//Expln: Sort the array in the form of decending order of height and ascending order of ppl,
//So that as we iterate through the array we keep adding the element to the index as per the no of ppl.
//So all the smaller elements will come to front and array is sorted properly as per the result.
class Solution {
    public int[][] reconstructQueue(int[][] people) {
        int len = people.length;
        if(len == 0) return people;
        
        Arrays.sort(people, new Comparator<int[]>(){
            public int compare(int[] a, int[] b)
            {
                if(a[0] == b[0])
                {
                    return a[1] - b[1];
                }
                else
                {
                    return b[0] - a[0];
                }
            }
        });
        for(int i = 0; i < len; i++)
        {
            int index = people[i][1];
            int[] sw = people[i];
            for(int j =i; j > index; j -- )
            {
                if(j- 1 >=0)
                    people[j ] = people[j - 1];
            }
            people[index] = sw;
        }
        return people;
    }
}