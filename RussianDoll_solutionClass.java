public class Solution {
    public int maxEnvelopes(int[][] envelopes) {

        if (envelopes == null || envelopes.length == 0) {
                return 0;
        }
        
        /* сортируем массив массивов */
        
        Arrays.sort(envelopes, new Comparator<int[]>(){
            public int compare(int[] a, int[] b){
                if (a[0] != b[0]){
                    return a[0] - b[0]; 
                } else{
                    return b[1] - a[1]; 
                }
            }
        });
     
        ArrayList<Integer> list = new ArrayList<Integer>();
     
        for(int i = 0; i < envelopes.length; i++){
     
            
            /* свели задачу к нахождению максимального возрастающего подмассива */
            
            if(list.size() == 0 || list.get(list.size() - 1) < envelopes[i][1]) {
                list.add(envelopes[i][1]);
            }
            
            int l = 0;
            int r = list.size() - 1;
     
            while(l <= r){
                int m = l + (r - l) / 2;
                if(list.get(m) < envelopes[i][1]){
                    l = m + 1;
                }else{
                    r = m - 1;
                }
            }
     
            list.set(l, envelopes[i][1]);
        }
     
        return list.size();
    }
}
