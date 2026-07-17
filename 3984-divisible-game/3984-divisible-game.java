class Solution {
    public int divisibleGame(int[] nums) {

        long MOD = 1000000007L;

        // Store all possible values of k
        HashSet<Integer> possibleK = new HashSet<>();

        int maxValue = 0;

        // Find all divisors (>1) of every number
        for (int num : nums) {
            maxValue = Math.max(maxValue, num);

            for (int d = 1; d * d <= num; d++) {
                if (num % d == 0) {

                    if (d > 1) {
                        possibleK.add(d);
                    }

                    int other = num / d;
                    if (other > 1) {
                        possibleK.add(other);
                    }
                }
            }
        }

        // One extra k where no element is divisible
        possibleK.add(maxValue + 1);

        long bestScore = Long.MIN_VALUE;
        int bestK = Integer.MAX_VALUE;

        // Try every possible k
        for (int k : possibleK) {

            long currentSum = 0;
            long maxSum = Long.MIN_VALUE;

            // Kadane's Algorithm
            for (int num : nums) {

                long value;

                if (num % k == 0) {
                    value = num;
                } else {
                    value = -num;
                }

                currentSum = Math.max(value, currentSum + value);
                maxSum = Math.max(maxSum, currentSum);
            }

            if (maxSum > bestScore) {
                bestScore = maxSum;
                bestK = k;
            } else if (maxSum == bestScore && k < bestK) {
                bestK = k;
            }
        }

        long answer = ((bestScore % MOD + MOD) % MOD);
        answer = (answer * bestK) % MOD;

        return (int) answer;
    }
}