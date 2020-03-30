package com.nightingale.bf.interpreter;

import java.util.Deque;

public interface Interpreter {
    
    public static final int BITS_NUM = 8;
    public static final int TAB = 4;

    public static final String END_LINE = ";\n";
    public static final String CELL = "*p";
    public static final String POINTER = "p";

    public static final String INCR = "\\++";
    public static final String DECR = "\\-+";
    public static final String RIGHT = ">+";
    public static final String LEFT = "<+";
    public static final String OUT = "\\.";
    public static final String IN = ",";
    public static final String LOOP_START = "\\[";
    public static final String LOOP_END = "\\]"; 
    
    String interpret(String code, Deque<Integer> input);
    String fromString(String target);    
    String toC(String code);    
    String fromHighLevel(String highLevelCode);
    String optimize(String code);
    String getOp();		
	
}