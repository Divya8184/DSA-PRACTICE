class Solution {
    public int maxDigitRange(int[] nums) {
        int maxRange = -1;
        int sum = 0;

        for (int num : nums){
            int temp = num;
            int minDigit = 9;
            int maxDigit = 0;

            if (temp == 0){
                minDigit = 0;
                maxDigit = 0;
            }

            while (temp > 0) {
                int digit = temp % 10;
                minDigit = Math.min(minDigit, digit);
                maxDigit = Math.max(maxDigit , digit);
                temp /= 10;
            }

            int range = maxDigit - minDigit;
            if (range > maxRange){
                maxRange = range;
                sum = num;
                
            } else if (range == maxRange){
                sum += num;
            }
        }
        return sum;
        
    }
}