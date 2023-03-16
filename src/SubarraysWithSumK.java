import java.util.*;
public class SubarraysWithSumK {

    static int findSubArraySum(int arr[], int n, int k)
    {
        // code here
        int sum = 0;
        int ans = 0;
        Map<Integer, Integer> hm = new HashMap<>();
        hm.put(0, 1);
        for(int i=0; i<n; i++){
            sum += arr[i];
            if(hm.containsKey(sum - k)){
                ans += hm.get(sum-k);
            }
            int oldVal = hm.getOrDefault(sum, 0);
            hm.put(sum, oldVal+1);
        }
        return ans;
    }
}
