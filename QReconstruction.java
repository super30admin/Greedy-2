class Solution {
    public int[][] reconstructQueue(int[][] people) {
     ArrayList<int[]> list = new ArrayList<>();
        int n=people.length;
        Arrays.sort(people,(a,b)->{
            if(a[0]!=b[0])
                return b[0]-a[0];//sorting in decreasign order
            return a[1]-b[1];//or in increasing order of k if a[0]==b[0]
        });
           int[][] res = new int[n][2];
         int i=0;
        for(int[] a:people){
            list.add(a[1],a);//adding based on index
            //1st 7 is added at 0th position
            //then after some time 5 is encountered with same a[1] value
            //so it is pplaced in 0th position
            // System.out.println(a[1]+" "+a[0]+""+a[1]);
          
        }
      
       
        for(int[] a: list){ 
            res[i]=a;
         //   System.out.println(list.get(a[1])[0]+""+list.get(a[1])[1]);
            i++;
                     
        }
        
        return res;
        
    }
}
