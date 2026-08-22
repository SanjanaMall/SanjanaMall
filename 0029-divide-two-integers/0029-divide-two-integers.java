class Solution {
    public int divide(int dividend, int divisor) {

        if(dividend == Integer.MIN_VALUE && divisor == -1){
            return Integer.MAX_VALUE;
        }  

        boolean negative = (dividend < 0) ^ (divisor < 0);

        long a = Math.abs((long) dividend);
        long b = Math.abs((long) divisor);

        long quotient = 0;

        for(int i = 31; i >= 0; i--){

            if((b << i) <= a){
                a -= (b << i);
                quotient += (1L << i);
            }
        }

        if(negative){
            quotient = -quotient;
        }
        if(quotient > Integer.MAX_VALUE){
            return Integer.MAX_VALUE;
        }

        if(quotient < Integer.MIN_VALUE){
            return Integer.MIN_VALUE;
        }

        return (int) quotient;
    }
}