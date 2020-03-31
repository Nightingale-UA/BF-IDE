package com.nightingale.bf.service.language.brain;

import com.nightingale.bf.service.operation.Operations;
import com.nightingale.bf.service.optimize.Optimizer;
import com.nightingale.bf.service.Transpiler;
import com.nightingale.bf.utils.Helper;
import org.springframework.stereotype.Service;

@Service("brainTranspiler")
public class TranspilerImpl implements Transpiler {
    private final Operations brainOperations;
    private final Optimizer brainOptimizer;

    public TranspilerImpl(Operations brainOperations, Optimizer brainOptimizer) {
        this.brainOperations = brainOperations;
        this.brainOptimizer = brainOptimizer;
    }

    @Override
    public String toHighLevel(String code) {
        var result = new StringBuilder();
        var spaces = 0;

        for (var tokenData : brainOperations.tokenize(
                                brainOptimizer.optimize(code))) {
            result.append(Helper.spaces(spaces));

            switch (tokenData.getType()) {
                case INCR:
                    result.append(CELL)
                        .append(ADD)
                        .append(tokenData.getLength());
                    break;
                case DECR:
                    result.append(CELL)
                        .append(SUBTRACT)
                        .append(tokenData.getLength());
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
                    result.append(PRINT_CHAR)
                        .append(CELL)
                        .append(CLOSING_BRACKET);
                    break;
                case IN:
                    result.append(CELL)
                        .append(READ_CHAR);
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
