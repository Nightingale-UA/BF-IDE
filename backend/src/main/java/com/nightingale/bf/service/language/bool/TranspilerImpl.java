package com.nightingale.bf.service.language.bool;

import com.nightingale.bf.service.operation.Operations;
import com.nightingale.bf.service.optimize.Optimizer;
import com.nightingale.bf.service.Transpiler;
import com.nightingale.bf.utils.Helper;
import org.springframework.stereotype.Service;

@Service("boolTranspiler")
public class TranspilerImpl implements Transpiler {
    private final Operations boolOperations;
    private final Optimizer boolOptimizer;

    public TranspilerImpl(Operations boolOperations, Optimizer boolOptimizer) {
        this.boolOperations = boolOperations;
        this.boolOptimizer = boolOptimizer;
    }

    @Override
    public String toHighLevel(String code) {
        var result = new StringBuilder();
        var spaces = 0;

        for (var tokenData : boolOperations.tokenize(
                                boolOptimizer.optimize(code))) {
            result.append(Helper.spaces(spaces));

            switch (tokenData.getType()) {
                case FLIP:
                    result.append(CELL).append(FLIP);
                    break;
                case RIGHT:
                    result.append(POINTER)
                        .append(ADD)
                        .append(tokenData.getLength());
                    break;
                case LEFT:
                    result.append(POINTER)
                        .append(SUBTRACT)
                        .append(tokenData.getLength());
                    break;
                case OUT:
                    result.append(PRINT_BIT)
                        .append(CELL)
                        .append(CLOSING_BRACKET);
                    break;
                case IN:
                    result.append(CELL)
                        .append(READ_BIT);
                    break;
                case START:
                    result.append(WHILE)
                        .append(CELL)
                        .append(CLOSING_BRACKET)
                        .append(OPENING_CURVY_BRACKET);
                    spaces += TAB;
                    break;
                case END:
                    result.delete(result.length() - TAB, result.length())
                        .append(CLOSING_CURVY_BRACKET);
                    spaces -= TAB;
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
