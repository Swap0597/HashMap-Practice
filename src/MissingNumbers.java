import java.util.*;
public class MissingNumbers {
    class Solution {
        static void missingNumbers(int n, int arr[], int m, int brr[]) {
            //Write your code here
            Map<Integer, Integer> hm = new TreeMap<>();
            for(int i = 0; i<m; i++){
                int oldVal = hm.getOrDefault(brr[i], 0);
                hm.put(brr[i], oldVal + 1);
            }

            for(int i=0; i<n; i++){
                if(hm.containsKey(arr[i])){
                    int oldVal = hm.getOrDefault(arr[i], 0);
                    hm.put(arr[i], oldVal - 1);
                }
            }
            boolean flag = false;
            for(Integer i : hm.keySet()){
                if(hm.get(i) != 0){
                    System.out.print(i+" ");
                    flag = true;
                }
            }
            if(flag == false){System.out.print("-1");}
        }

    }
}
