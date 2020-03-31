package com.nightingale.bf.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Deque;
import java.util.List;
import java.util.jar.JarEntry;
import java.util.jar.JarInputStream;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Helper {

//    private static final String INTERPRETER_PACKAGE_NAME = "com.nightingale.bf.interpreter.";
//    private static ObservableList<String> langList;
//    private static ObservableList<String> percList;
//    private static final DecimalFormat PERCENT = new DecimalFormat("#%");

//    static int calculateChances(String code) {
//        int size = langList.size();
//        for (int i = 0; i < size; i++) {
//            try {
//                Interpreter interpreter = (Interpreter) Class.forName(INTERPRETER_PACKAGE_NAME +
//                                                                 langList.get(i)).newInstance();
//                String op = interpreter.getOp();
//
//                double countDistinct = (double)code.chars()
//                                                   .distinct()
//                                                   .count();
//
//                double countOpInCode = (double)code.chars()
//                                                   .distinct()
//                                                   .mapToObj(c -> String.valueOf((char) c))
//                                                   .filter(c -> op.contains(c))
//                                                   .count();
//
//                double k1 = countOpInCode / op.length();
//                double k2 = countOpInCode / countDistinct;
//                String k = PERCENT.format(k1 * k2);
//                percList.set(i,k);
//            } catch (ClassNotFoundException e) {
//                e.printStackTrace();
//            } catch (IllegalAccessException|InstantiationException e) {
//                e.printStackTrace();
//            }
//        }
//        int max = percList.stream()
//                          .mapToInt(s -> Integer.parseInt(s.replaceAll("\\D", "")))
//                          .max()
//                          .getAsInt();
//        if (max == 0) return langList.indexOf("Brainfuck");
//
//        return percList.indexOf(String.valueOf(max) + "%");
//    }
//
//    static void generateLists() {
//        langList = FXCollections.observableArrayList();
//        percList = FXCollections.observableArrayList();
//        String jarPath = Helper.class.getProtectionDomain().getCodeSource()
//                                                            .getLocation().getPath();
//        String interpreterPathName = INTERPRETER_PACKAGE_NAME.replaceAll("\\.","/");
//
//        try (
//            JarInputStream stream = new JarInputStream(new FileInputStream(jarPath));
//        ) {
//            for(;;) {
//                JarEntry entry = stream.getNextJarEntry();
//                if (entry == null) break;
//
//                String name = entry.getName();
//                if (name.contains(interpreterPathName) && !entry.isDirectory()) {
//                    langList.add(name.substring(name.lastIndexOf('/') + 1, name.lastIndexOf('.')));
//                }
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//        langList.sort(Comparator.naturalOrder());
//
//        String init = PERCENT.format(0);
//        int size = langList.size();
//        for (int i = 0; i < size; i++) {
//            percList.add(init);
//        }
//    }
//
//    static String format(String code) {
//        int tab = Interpreter.TAB;
//        int spaces = tab;
//
//        String input = code.replaceAll("\\d+\\s+|\\n", "");
//        int length = input.length();
//
//        StringBuilder sb = new StringBuilder();
//        for (int i = 0; i < length; i++) {
//            char cur = input.charAt(i);
//            switch (cur) {
//                case '[':
//                    sb.append("\n" + spaces(spaces) + "[\n");
//                    spaces += tab;
//                    sb.append(spaces(spaces));
//                    break;
//                case ']':
//                    sb.append("\n");
//                    spaces -= tab;
//                    sb.append(spaces(spaces) + "]");
//                    break;
//                default:
//                    sb.append(cur);
//                    break;
//            }
//        }
//        String[] lines = sb.toString().split("\n");
//        sb.setLength(0);
//        for (int i = 0; i < lines.length; i++) {
//            sb.append((i + 1) + " " + lines[i] + "\n");
//        }
//        return sb.toString();
//    }
//
//    static List<String> check(String code) {
//        List<String> list = new ArrayList<>();
//        // brackets check
//        int length = code.length();
//        int pair = 0;
//        for (int i = 0; i < length; i++) {
//            switch (code.charAt(i)) {
//                case '[':
//                    pair = closingBracket(code, i);
//                    break;
//                case ']':
//                    pair = openingBracket(code, i);
//                    break;
//                default:
//                    break;
//            }
//            if (pair == -1) {
//                list.add("Unclosed bracket found at index " + i + ".");
//            }
//        }
//        // arrows check
//        int forward = (int)code.chars()
//                               .filter(c -> c == (int)'>')
//                               .count();
//        int backward = (int)code.chars()
//                                .filter(c -> c == (int)'<')
//                                .count();
//        if (backward > forward) {
//            int dif = backward - forward;
//            list.add("The number of '<' is bigger than the number of '>'. Please add " +
//                            dif + " '>' to the beginning of the code.");
//        }
//        return list;
//    }

    public static int closingBracket(String code, int index) {
        int length = code.length();
        int count = 0;
        
        for (int i = index + 1; i < length; i++) {
            if (code.charAt(i) == ']') {
                if (count == 0) return i;
                else count--;
            } else if (code.charAt(i) == '[') count++;
        }
        return -1;
    }
	
	public static int openingBracket(String code, int index) {        
        int count = 0;
        
        for (int i = index - 1; i >= 0; i--) {
            if (code.charAt(i) == '[') {
                if (count == 0) return i;
                else count--;
            } else if (code.charAt(i) == ']') count++;
        }
        return -1;
    }
    //TODO: remove
    public static Deque<String> tokenize(String code, String regex) {
        Deque<String> tokens = new ArrayDeque<>();
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(code);
        while (m.find()) {
            tokens.add(m.group());
        }
        return tokens;
    }

    public static String spaces(int s) {
        StringBuilder sb = new StringBuilder(s);
        for (int i = 0; i < s; i++) {
            sb.append(' ');
        }
        return sb.toString();
    }
}