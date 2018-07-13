package bf.cls.interpreter;

import java.util.*;
import bf.cls.Interpreter;

public class Brainfuck implements Interpreter {  
    private String op = "><+-,.[]";
	
    public String interpret(String code, Deque<Integer> input) {         
        List<Integer> tape = new LinkedList<>();
        tape.add(0);
        StringBuilder output = new StringBuilder();      
        
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
                case '+':
                    int temp = (tape.get(pointer) + 1) % 256;
                    tape.set(pointer,temp);
                    break;
                case '-':
                    temp = tape.get(pointer) - 1;
                    tape.set(pointer,(temp < 0) ? 255 : temp);
                    break;
                case ',':                    
                    tape.set(pointer,input.removeFirst());                    
                    break;
                case '.':
                    output.append((char)tape.get(pointer).intValue());
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
        return output.toString();
    } 
	
	public String getOp() {
		return op;
	}
}
