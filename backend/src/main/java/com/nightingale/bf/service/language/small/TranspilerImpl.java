package com.nightingale.bf.service.language.small;

import com.nightingale.bf.service.operation.Operations;
import com.nightingale.bf.service.optimize.Optimizer;
import com.nightingale.bf.service.Transpiler;
import com.nightingale.bf.utils.Helper;
import org.springframework.stereotype.Service;

@Service("smallTranspiler")
public class TranspilerImpl implements Transpiler {
    private final com.nightingale.bf.service.operation.Operations smallOperations;
    private final Optimizer smallOptimizer;

    public TranspilerImpl(Operations smallOperations, Optimizer smallOptimizer) {
        this.smallOperations = smallOperations;
        this.smallOptimizer = smallOptimizer;
    }
    @Override
    public String toHighLevel(String code) {
        var result = new StringBuilder();
        var spaces = 0;

        for (var tokenData : smallOperations.tokenize(
                                smallOptimizer.optimize(code))) {
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
