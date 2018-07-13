package bf.cls;

import java.util.Deque;

public interface Interpreter {    
    String interpret(String code, Deque<Integer> input);    
    String getOp();
	
    default int closingBracket(String code, int index) {
        int length = code.length();
        int count = 0;
        
        for (int i = index + 1; i < length; i++) {
            if (code.charAt(i) == ']') {
                if (count == 0) return i;
                else count--;
            } else if (code.charAt(i) == '[') count++;
        }
        return index;
    }
	
    default int openingBracket(String code, int index) {        
        int count = 0;
        
        for (int i = index - 1; i >= 0; i--) {
            if (code.charAt(i) == '[') {
                if (count == 0) return i;
                else count--;
            } else if (code.charAt(i) == ']') count++;
        }
        return index;
    }
    
    default String fillByte(String s) {
		StringBuilder sb = new StringBuilder(s).reverse();
		while (sb.length() < 8) {
			sb.append(0);
		}
		return sb.toString();
    }
}
