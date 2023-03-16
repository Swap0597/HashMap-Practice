import java.util.*;
public class LargestSubarrayWithSum0 {
    int maxLen(int arr[], int n)
    {
        // Your code here
        Map<Integer, Integer> hm = new HashMap<>();
        hm.put(0, -1);
        int sum = 0;
        int ans = 0;

        for(int i=0; i<n; i++){
            sum += arr[i];

            if(hm.containsKey(sum)){
                ans = Math.max(ans, Math.max(ans, i - hm.get(sum)));
            }
            else{
                hm.put(sum, i);
            }
        }
        return ans;
    }
}
