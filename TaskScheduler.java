
//TC: O(n)
//SC: O(1)
class TaskScheduler {
    public int leastInterval(char[] tasks, int n) {
        int len=tasks.length;
        int[] arr=new int[26];
        int maxcharcnt=0;
        int numofmaxchar=0;
        for(char c:tasks){
            arr[c-'A']++;
            if(arr[c-'A']>maxcharcnt){
                maxcharcnt=arr[c-'A'];
                numofmaxchar=1;
            }else if(arr[c-'A']==maxcharcnt){
                numofmaxchar++;
            }
        }
        int ans=(n+1)*(maxcharcnt-1)+numofmaxchar;
        ans=Math.max(ans,len);
        return ans;
    }
}




// int[] arr=new int[26];
//         int numofcharwithmaxfreq=0;
//         int maxfreq=0;
//         for(char c:tasks){
//             arr[c-'A']++;
//             if(arr[c-'A']>maxfreq){
//                 maxfreq=arr[c-'A'];
//                 numofcharwithmaxfreq=1;
//             }else if(arr[c-'A']==maxfreq){
//                 numofcharwithmaxfreq++;
//             }
//         }
//         int remtasks=tasks.length-maxfreq*numofcharwithmaxfreq;
//         int slots = (maxfreq-1)*(n-(numofcharwithmaxfreq-1));
//         int time=slots+maxfreq*numofcharwithmaxfreq+Math.max(0,remtasks-slots);
//         return time;