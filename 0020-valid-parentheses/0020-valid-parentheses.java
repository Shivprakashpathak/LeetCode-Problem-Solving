class Solution {
    public boolean isValid(String s) {
        if(s.length()%2!=0){
            return false;
        }
        Stack<Character>Shiv=new Stack<>(); 
         for(char c: s.toCharArray()){
            if(c == '{'){
                Shiv.push('}');
            }
            else if(c=='['){
                Shiv.push(']');
            }
            else if (c=='('){
                Shiv.push(')');
            }

            else{
                if(Shiv.isEmpty()||Shiv.pop()!=c ){
                    return false;
                }
            }
         }

         return Shiv.isEmpty();

    }
}