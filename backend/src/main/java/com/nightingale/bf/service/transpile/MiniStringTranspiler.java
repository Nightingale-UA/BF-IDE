package com.nightingale.bf.service.transpile;

import com.nightingale.bf.service.MiniStringService;

public class MiniStringTranspiler extends MiniStringService implements Transpiler {
    @Override
    public String toHighLevel(String code) {
        var result = new StringBuilder();

        for (var tokenData : tokenize(optimize(code))) {
            switch (tokenData.getToken().getType()) {
                case INCR:
                    result.append(CELL)
                        .append(ADD)
                        .append(tokenData.getLength());
                    break;
                case OUT:
                    result.append(PRINT_CHAR)
                        .append(CELL)
                        .append(CLOSING_BRACKET);
                    break;
            }

            result.append(END_LINE);
        }

        return result.toString();
    }

    @Override
    public String fromHighLevel(String highLevelCode) {
        return "Not implemented yet";
    }
}
