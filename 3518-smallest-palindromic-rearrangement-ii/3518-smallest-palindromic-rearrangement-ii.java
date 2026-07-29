import java.math.BigInteger;
class Solution {
    public String smallestPalindrome(String s, int k) {
         int[] counts = new int[26];
        for (char ch : s.toCharArray()) {
            counts[ch - 'a']++;
        }

        int n = s.length();
        int halfLen = n / 2;

        char midChar = '\0';
        int[] halfCounts = new int[26];
        for (int i = 0; i < 26; i++) {
            if (counts[i] % 2 == 1) {
                midChar = (char) ('a' + i); // guaranteed unique since s is palindromic
            }
            halfCounts[i] = counts[i] / 2;
        }

        // total distinct permutations of the half multiset = halfLen! / (c1! * c2! * ... )
        BigInteger total = factorial(halfLen);
        for (int c : halfCounts) {
            if (c > 1) {
                total = total.divide(factorial(c));
            }
        }

        BigInteger K = BigInteger.valueOf(k);
        if (total.compareTo(K) < 0) {
            return "";
        }

        int[] cnts = halfCounts.clone();
        int remaining = halfLen;
        BigInteger remainingTotal = total;
        BigInteger kk = K;
        StringBuilder result = new StringBuilder();

        for (int pos = 0; pos < halfLen; pos++) {
            for (int letter = 0; letter < 26; letter++) {
                if (cnts[letter] == 0) continue;

                // candidate = remainingTotal * cnts[letter] / remaining
                BigInteger candidate = remainingTotal
                        .multiply(BigInteger.valueOf(cnts[letter]))
                        .divide(BigInteger.valueOf(remaining));

                if (candidate.compareTo(kk) >= 0) {
                    result.append((char) ('a' + letter));
                    cnts[letter]--;
                    remaining--;
                    remainingTotal = candidate;
                    break;
                } else {
                    kk = kk.subtract(candidate);
                }
            }
        }

        String halfStr = result.toString();
        StringBuilder answer = new StringBuilder();
        answer.append(halfStr);
        if (midChar != '\0') {
            answer.append(midChar);
        }
        answer.append(new StringBuilder(halfStr).reverse());

        return answer.toString();
    }

    private BigInteger factorial(int x) {
        BigInteger result = BigInteger.ONE;
        for (int i = 2; i <= x; i++) {
            result = result.multiply(BigInteger.valueOf(i));
        }
        return result;
    }
}