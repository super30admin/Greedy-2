class Solution {
    public int[][] reconstructQueue(int[][] people) {
        List<int []> result = new ArrayList<>();
        Arrays.sort(people, (a, b) -> {
            if(a[0] == b[0]){
                return a[1] - b[1];
            }
            return b[0] - a[0];
        });
        for(int[] person : people){
            result.add(person[1], person);
        }
        int[][] re = new int[people.length][2];
        for(int i = 0; i < re.length; i++){
            re[i] = result.get(i);
        }
        return re;
    }
}
