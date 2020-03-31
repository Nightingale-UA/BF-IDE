package com.nightingale.bf.service.language.swap;

import com.nightingale.bf.service.operation.Operations;
import com.nightingale.bf.service.optimize.Optimizer;
import com.nightingale.bf.service.Transpiler;
import com.nightingale.bf.utils.Helper;
import org.springframework.stereotype.Service;

@Service("swapTranspiler")
public class TranspilerImpl implements Transpiler {
    private final Operations swapOperations;
    private final Optimizer swapOptimizer;

    public TranspilerImpl(Operations swapOperations, Optimizer swapOptimizer) {
        this.swapOperations = swapOperations;
        this.swapOptimizer = swapOptimizer;
    }

    @Override
    public String toHighLevel(String code) {
        var result = new StringBuilder();
        var spaces = 0;
        var swap = false;

        for (var tokenData : swapOperations.tokenize(
                                swapOptimizer.optimize(code))) {
            result.append(Helper.spaces(spaces));

            switch (tokenData.getType()) {
                case SWAP:
                    if (swap) {
                        result.append(CELL).append(GET_STORED_BIT);
                    } else {
                        result.append(STORE_BIT)
                            .append(CELL)
                            .append(CLOSING_BRACKET);
                    }
                    swap = !swap;
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
