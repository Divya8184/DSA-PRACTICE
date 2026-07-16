class Solution {
    public long maxSubarraySum(int[] nums, int k) {
        return Math.max(calc(nums, k, true), calc(nums, k, false));
    }

    private long calc(int[] nums, int k, boolean mul) {
        long INF = Long.MIN_VALUE / 2;

        long before = INF;
        long during = INF;
        long after = INF;
        long ans = INF;

        for (int x : nums) {

            long y = mul ? 1L * x * k : (x >= 0 ? x / k : -((-x) / k));

            long nbefore = Math.max(before + x, (long)x);
            long nduring = Math.max(Math.max(during + y, before + y), y);
            long nafter = Math.max(after + x, during + x);

            before = nbefore;
            during = nduring;
            after = nafter;

            ans = Math.max(ans, Math.max(during, after));
        }

        return ans;
    }
}