package bf.cls.interpreter;

import java.util.*;
import bf.cls.Interpreter;
import java.util.stream.Collectors;

public class Boolfuck implements Interpreter {	
	private String op = "><+,;[]";
			
	public String interpret(String code, Deque<Integer> input) {
		StringBuilder output = new StringBuilder();
		List<Integer> tape = new LinkedList<>();		
        tape.add(0);
		
		Deque<Integer> inputBits = new ArrayDeque<>();
		input.forEach(i -> fillByte(Integer.toBinaryString(i))
					  				.chars().forEach(c -> inputBits.add(c - 48)));
		
		Deque<Integer> outputBits = new ArrayDeque<>();
		
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
                    tape.set(pointer, (tape.get(pointer) == 0) ? 1 : 0);
                    break;                
                case ',':                    
                    tape.set(pointer, inputBits.remove());                 
                    break;
                case ';':
                    outputBits.addFirst(tape.get(pointer));
					if (outputBits.size() == 8) {
						output.append((char)Integer.parseInt(outputBits.stream()
														 		   .map(n -> String.valueOf(n))
														  		   .collect(Collectors.joining()),2));
						outputBits.clear();
					}
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