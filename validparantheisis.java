public class validparantheisis {
    class Solution {
    public boolean isValid(String s) {
        while(s.contains("()") || s.contains("[]") || s.contains("{}")){
            s=s.replace("{}","");
            s=s.replace("[]","");
            s=s.replace("()","");
        }
        if(s.isEmpty()){
            return true;
        }
        else{
            return false;
        }
    }
}

// this is o(n2) approaxh 

// ampther approach too
import java.util.Stack;

class Solution {
    public boolean isValid(String s) {
        Stack<Character> stacker = new Stack<>();
        
        for (char ew : s.toCharArray()) {
            if (ew == '[') {
                stacker.push(']');
            } else if (ew == '{') {
                stacker.push('}');
            } else if (ew == '(') {
                stacker.push(')');
            } else {
                if (stacker.isEmpty() || stacker.pop() != ew) {
                    return false;
                }
            }
        }
        
        return stacker.isEmpty();
    }
    // approach two
}
 // using stack
}
