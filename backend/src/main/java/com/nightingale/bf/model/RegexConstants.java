package com.nightingale.bf.model;

public final class RegexConstants {
    public static final String OR = "|";

    public static final class Optimization {
        public static final String BOOL = "(\\+\\+)+|<>|><|\\[]";
        public static final String BRAIN = "-\\+|\\+-|<>|><|\\[]";
        public static final String MINI_STRING = "Not optimizable";
        public static final String SMALL = "(\\*\\*)+|<>|><|\\[]";
        public static final String SWAP = "(?<=@)(@@)+|<>|><|\\[]";
    }

    public static final class Operation {
        public static final class Brain {
            public static final String INCR = "\\++";
            public static final String DECR = "\\-+";
            public static final String IN = ",";
            public static final String OUT = "\\.";
            public static final String RIGHT = ">+";
            public static final String LEFT = "<+";
            public static final String START = "\\[";
            public static final String END = "\\]";
        }

        public static final class Bool {
            public static final String FLIP = "\\+";
            public static final String OUT = ";";
        }

        public static final class Small {
            public static final String FLIP = "\\*";
        }

        public static final class Swap {
            public static final String SWAP = "@";
        }
    }

    private RegexConstants() {}
}
