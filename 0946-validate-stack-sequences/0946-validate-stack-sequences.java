class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> st = new Stack<>();
        int idx = 0;

        for(int x : pushed) {
            st.push(x);

            while(!st.isEmpty() && st.peek() == popped[idx]) {
                st.pop();
                idx++;
            }
        }

        return st.isEmpty();
    }
}