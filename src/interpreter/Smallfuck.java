package bf.cls.interpreter;

import bf.cls.Interpreter;
import java.util.*;
import java.util.stream.Collectors;

public class Smallfuck implements Interpreter {
	private String op = "><*[]";
	
	public String interpret(String code, Deque<Integer> input) {		
		List<Integer> tape = new LinkedList<>();
        tape.add(0);
		int pointer = 0;
        int length = code.length();
        
        for (int i = 0; i < length; i++) {          
            switch (code.charAt(i)) {
                case '>':
                    pointer++;
                    if (pointer == tape.size()) {
                        tape.add(0);
                    }                     
                    break;
                case '<':
                    pointer--;
                    if (pointer == -1) {
                        tape.add(0,0);
                        pointer = 0;
                    }                     
                    break;
                case '*':
                    tape.set(pointer, (tape.get(pointer) == 0) ? 1 : 0);
                    break;                
                case '[':
                    if (tape.get(pointer) == 0) {
                        i = closingBracket(code,i);
                    }      
                    break;
                case ']':
                    if (tape.get(pointer) != 0) {
                        i = openingBracket(code,i);
                    }
                    break;
                default:
                    break;
            }            
        }
		return "Tape:\n" + tape.stream()
							   .map(i -> String.valueOf(i))
							   .collect(Collectors.joining());
	}	
	
	public String getOp() {
		return op;
	}
}