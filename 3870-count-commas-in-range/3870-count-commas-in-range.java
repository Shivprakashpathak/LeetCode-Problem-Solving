class Solution {
    public int countCommas(int n) {
        int count = 0;
        if (n >= (int)1e3) count += n - (int)1e3 + 1;
        if (n >= (int)1e6) count += n - (int)1e6 + 1;
        if (n >= (int)1e9) count += n - (int)1e9 + 1;
        return count;
    }
}