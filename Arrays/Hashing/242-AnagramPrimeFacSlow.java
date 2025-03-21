import java.math.BigInteger;

class Solution {

    public final int[] primes = new int[] { 1, 2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67,
            71, 73, 79, 83, 89, 97, 101 };

    public boolean isAnagram(String s, String t) {

        if (s.length() != t.length()) {
            return false;
        }

        BigInteger sKey = BigInteger.ONE;
        BigInteger tKey = BigInteger.ONE;

        for (char c : s.toCharArray()) {
            sKey = sKey.multiply(BigInteger.valueOf(primes[c - 'a']));
        }
        for (char c : t.toCharArray()) {
            tKey = tKey.multiply(BigInteger.valueOf(primes[c - 'a']));
        }
        return sKey.equals(tKey);

    }
}