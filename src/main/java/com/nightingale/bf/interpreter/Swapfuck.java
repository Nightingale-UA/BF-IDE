package com.nightingale.bf.interpreter;

import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

import com.nightingale.bf.Interpreter;
import com.nightingale.bf.ctrl.Helper;

public class Swapfuck implements Interpreter {
	private static final String OP = "@><[].";
	
	private static final String SWAP = "@";
	private static final String REGEX = SWAP + "|" + RIGHT + "|" + LEFT + "|" + 
								OUT + "|" + LOOP_START + "|" + LOOP_END;

	public String interpret(String code, Deque<Integer> input) {
		StringBuilder output = new StringBuilder();
		int size = input.size() * BITS_NUM;
		List<Integer> tape = new ArrayList<>(size);
		
		int count = 0;
		int next = 0;
		for (int i = 0; i < size; i++) {
			if (count == 0) next = input.poll();						
			tape.set(i,next & 1);
			next >>= 1;
			count++;
			if (count == BITS_NUM) {
				count = 0;
				next = 0;
			}
		}

		String opt = optimize(code);
		int swapReg = -1;
		int pointer = 0;
        int length = opt.length();
		
		for (int i = 0; i < length; i++) {
			switch (opt.charAt(i)) {
				case '@':
					if (swapReg == -1) swapReg = pointer;
					else {
						int temp = tape.get(swapReg);
						tape.set(swapReg, tape.get(pointer));
						tape.set(pointer, temp);
						swapReg = -1;
					}
					break;
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
                case '.':
					next >>= 1;					
					next ^= (2 ^ tape.get(pointer)) << (BITS_NUM - 1);					
					next ^= 1 << BITS_NUM;								
					count++;				
					if (count == BITS_NUM) {						
						output.append((char)next);
						count = 0;
						next = 0;
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
		
		String temp = "temp";
		String swapReg = "swapReg";
		while (next != null) {
			int length = next.length();
            
			if (next.matches(LOOP_END)) spaces -= TAB; 
			          
            String s = Helper.spaces(spaces);
            result.append(s);
                
            if (next.matches(SWAP)) {
				String s1 = Helper.spaces(spaces + TAB);
				result.append("if (" + swapReg + " == -1) {\n" + 
							s1 + swapReg + " = " + POINTER + END_LINE + 
							s + "} else {\n" + 
							s1 + temp + " = *" + swapReg + END_LINE + 
							s1 + "*" + swapReg + " = " + CELL + END_LINE + 
							s1 + CELL + " = " + temp + END_LINE +
							s1 + swapReg + " = -1" + END_LINE + 
							s + "}\n");
            } else if (next.matches(RIGHT)) {
                result.append(POINTER + " += " + length + END_LINE);
            } else if (next.matches(LEFT)) {
                result.append(POINTER + " -= " + length + END_LINE);
            } else if (next.matches(OUT)) {
                result.append("outputBit(" + CELL + ")" + END_LINE);
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
		String useless = "(@@@)@*|<>|><|\\[\\]";
		while (result.matches(".*(" + useless + ").*"))	{
			result = result.replaceAll(useless, "");
		}	
		return result;
	}
}