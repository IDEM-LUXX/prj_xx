
/* найти среди элементов массива все такие, что i<j<k и a[i]+a[j]+a[k]<target */

class Solution {
    public int threeSumMulti(int[] A, int target) {
        int div = 1000000007;
        int count = 0;
        for (int i=0; i<A.length; i++) {
            int temp = getPairsCount(A.length, target-A[i], A, i+1);
            count = (count+temp)%div;
        }
        return count;
    }
  
/* обходим массив, выбирая первый элемент a[i], задача сводится к поиску двух элементов */
  
    public int getPairsCount(int n, int sum, int[] arr, int start) { 
        Map<Integer, Integer> map = new HashMap<>();
        for (int i=start; i<n; i++) {
            map.put(arr[i], map.getOrDefault(arr[i], 0)+1);
        }

      /* считаем количетво пар */
      
        int count = 0;
        for (int i=start; i<n; i++) {
            if(map.get(sum-arr[i]) != null) {
                count += map.get(sum - arr[i]);
            }
/* если пара с первым элементом же числом икслючаем из подсчета */
            if (sum-arr[i] == arr[i]) {
                count--;
            }
        }
 /* так как считaли без учета порядка делим пополам */
        return count/2;
    }
}
