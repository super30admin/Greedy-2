TC - O(N)
SC - O(1)
 
/**
 * @param {string} s
 * @return {number[]}
 */
var partitionLabels = function(s) {
    var partition=[];
    var anchor=0,max= -Infinity;
    var ar=[];
    for(var i=0;i<s.length;i++)
    {
        ar[s[i]]=i;
    }
    for(var k=0;k<s.length;k++)
    {
        max = Math.max(max,ar[s[k]]);
        if(max===k)
        {
            partition.push(max-anchor+1);
            anchor = k+1;
        }
    }
    return partition;
};