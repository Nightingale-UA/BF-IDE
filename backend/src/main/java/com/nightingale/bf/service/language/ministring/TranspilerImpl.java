package com.nightingale.bf.service.language.ministring;

import com.nightingale.bf.service.operation.Operations;
import com.nightingale.bf.service.optimize.Optimizer;
import com.nightingale.bf.service.Transpiler;
import org.springframework.stereotype.Service;

@Service("miniStringTranspiler")
public class TranspilerImpl implements Transpiler {
    private final Operations miniStringOperations;
    private final Optimizer miniStringOptimizer;

    public TranspilerImpl(Operations miniStringOperations, Optimizer miniStringOptimizer) {
        this.miniStringOperations = miniStringOperations;
        this.miniStringOptimizer = miniStringOptimizer;
    }

    @Override
    public String toHighLevel(String code) {
        var result = new StringBuilder();

        for (var tokenData : miniStringOperations.tokenize(
                                miniStringOptimizer.optimize(code))) {
            switch (tokenData.getType()) {
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
