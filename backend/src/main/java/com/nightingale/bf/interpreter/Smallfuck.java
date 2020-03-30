package com.nightingale.bf.interpreter;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

import com.nightingale.bf.utils.Helper;

public class Smallfuck implements Interpreter {
	private static final String OP = "><*[]";
    
    private static final String FLIP = "\\*";
    private static final String REGEX = RIGHT + "|" + LEFT + "|" + FLIP + "|"
                                + LOOP_START + "|" + LOOP_END;

	public String interpret(String code, Deque<Integer> input) {		
		List<Integer> tape = new LinkedList<>();
        tape.add(0);
        int pointer = 0;
        String opt = optimize(code);

        int length = opt.length();
        
        for (int i = 0; i < length; i++) {          
            switch (opt.charAt(i)) {
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
                    tape.set(pointer, (tape.get(pointer) ^ 1));
                    break;                
                case '[':
                    if (tape.get(pointer) == 0) {
                        i = Helper.closingBracket(opt,i);
                    }      
                    break;
                case ']':
                    if (tape.get(pointer) != 0) {
                        i = Helper.openingBracket(opt,i);
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
	
	public String fromString(String target) {
		//TODO: implement from String
		return "Not implemented yet";
	}
	public String toC(String code) {
        String opt = optimize(code);        
		Deque<String> tokens = Helper.tokenize(opt, REGEX);
        
        StringBuilder result = new StringBuilder();
               
        int spaces = TAB;
        
        String next = tokens.poll();
        while (next != null) {           
            int length = next.length();
            
            if (next.matches(LOOP_END)) spaces -= TAB;           
            
            result.append(Helper.spaces(spaces));
                
            if (next.matches(FLIP)) {
                result.append(CELL + " ^= 1" + END_LINE);
            } else if (next.matches(RIGHT)) {
                result.append(POINTER + " += " + length + END_LINE);
            } else if (next.matches(LEFT)) {
                result.append(POINTER + " -= " + length + END_LINE);
            } else if (next.matches(LOOP_START)) {
                result.append("while (" + CELL + ") {\n");
                spaces += TAB;
            } else if (next.matches(LOOP_END)) {
                result.append("}\n");
            }

            next = tokens.poll();
        }
        
        return result.toString();
	}
	public String fromHighLevel(String highLevelCode) {
		//TODO: implement from High level
		return "Not implemented yet";
	}	
	
	public String getOp() {
		return OP;
	}

	@Override
	public String optimize(String code) {
		String result = code;	
		String useless = "(\\*\\*)+|<>|><|\\[\\]";
		while (result.matches(".*(" + useless + ").*"))	{
			result = result.replaceAll(useless, "");
		}	
		return result;
	}
}