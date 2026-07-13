class Solution {
    public int evalRPN(String[] tokens) {
      Stack <String> stack=new Stack<String>();
      String ops="+-*/";
      for(String token:tokens){
        if(!ops.contains(token)){
            stack.push(token);
        }
        else{
            int a=Integer.valueOf(stack.pop());
            int b=Integer.valueOf(stack.pop());
            int index=ops.indexOf(token);
            
            switch(index){
                case 0: // +
                        stack.push(String.valueOf(b + a));
                        break;

                    case 1: // -
                        stack.push(String.valueOf(b - a));
                        break;

                    case 2: // *
                        stack.push(String.valueOf(b * a));
                        break;

                    case 3: // /
                        stack.push(String.valueOf(b / a));
                        break;

           }
            
        }
      }
       return Integer.valueOf(stack.pop()); 
    }
}