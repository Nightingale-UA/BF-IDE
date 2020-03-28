package com.nightingale.bf.interpreter;


import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

import com.nightingale.bf.Interpreter;
import com.nightingale.bf.ctrl.Helper;

public class Boolfuck implements Interpreter {	
	private static final String OP = "><+,;[]";

	private static final String OUT = ";";
	private static final String FLIP = "\\+";
	private static final String REGEX = FLIP + "|" + RIGHT + "|" + LEFT + "|" + IN + "|" + 
									OUT + "|" + LOOP_START + "|" + LOOP_END;

	public String interpret(String code, Deque<Integer> input) {
		StringBuilder output = new StringBuilder();
		List<Integer> tape = new LinkedList<>();		
		tape.add(0);
		String opt = optimize(code);

		int countIn = 0;
		int nextIn = input.poll();
		int countOut = 0;		
		int nextOut = 0;		

		int pointer = 0;
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
                case '+':
                    tape.set(pointer, (tape.get(pointer) ^ 1));
                    break;                
				case ',':										
					tape.set(pointer, nextIn & 1);					
					nextIn >>= 1;
					countIn++;
					if (countIn == BITS_NUM) {
						countIn = 0;						
						nextIn = input.poll();
					}
                    break;
				case ';':
					nextOut >>= 1;					
					nextOut ^= (2 ^ tape.get(pointer)) << (BITS_NUM - 1);					
					nextOut ^= 1 << BITS_NUM;								
					countOut++;				
                    if (countOut == BITS_NUM) {						
						output.append((char)nextOut);
						countOut = 0;
						nextOut = 0;
					}
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
		return output.toString();
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
            } else if (next.matches(OUT)) {
                result.append("outputBit(" + CELL + ")" + END_LINE);
            } else if (next.matches(IN)) {
                result.append(CELL + " = inputBit()" + END_LINE);
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
		return "Unimplemented yet";
	}

	public String optimize(String code) {
		String result = code;	
		String useless = "(\\+\\+)+|<>|><|\\[\\]";
		while (result.matches(".*(" + useless + ").*"))	{
			result = result.replaceAll(useless, "");
		}	
		return result;
	}
	
	public String getOp() {
		return OP;
	}
}