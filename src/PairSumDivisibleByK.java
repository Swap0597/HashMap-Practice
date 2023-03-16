import java.util.*;
public class PairSumDivisibleByK {
    public static long countKdivPairs(int arr[], int n, int k)
    {
        //code here
        Map<Integer, Integer> hm = new HashMap<>();

        long ans = 0;
        for(int i=0; i<n; i++){
            int rem = arr[i] % k;
            if(rem<0){rem = rem+ k;}
            if(rem == 0 && hm.containsKey(rem)){
                ans += hm.get(rem);
            }
            else if(hm.containsKey(k - rem)){
                ans += hm.get(k - rem);
            }
            int oldVal = hm.getOrDefault(rem, 0);
            hm.put(rem, oldVal+1);
        }
        return ans;
    }
}
