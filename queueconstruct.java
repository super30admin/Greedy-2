//Time complexity:O(n^2)
//Space complexity:O(n)
class Solution {
    public int[][] reconstructQueue(int[][] people) {
        int[][] result=new int[people.length][2];
        if(people==null || people.length==0){
            return result;
        }
        Arrays.sort(people,(a,b) -> {
            if(a[0]==b[0]){
                return a[1]-b[1];
            }else{
                return b[0]-a[0];
            }
        });
        List<int[]> li=new ArrayList();
        for(int[] i:people){
            li.add(i[1],i);
        }
        return li.toArray(new int[0][]);
    }
}