Time Complexity = O(n*n)
Space Complexity = O(n)

class Solution {
    public int[][] reconstructQueue(int[][] people) {
        if(people == null || people.length == 0)return new int[0][0];
        
        Comparator<int[]> customComparator = new Comparator<>(){
            @Override
            public int compare(int[] a, int[] b){
                if(a[0] == b[0]){
                    return a[1] - b[1];
                }else{
                    return b[0] - a[0];
                }
            }
        };
        
        Arrays.sort(people, customComparator);
        
        List<int[]> result = new LinkedList<>();
        
        for(int[] person : people){
            result.add(person[1],person);
        }
        return result.toArray(new int[2][0]);
        
    }
}