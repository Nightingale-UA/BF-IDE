package com.nightingale.bf.service.execute;

import com.nightingale.bf.model.ExecutionData;
import com.nightingale.bf.model.operation.OperationToken;
import com.nightingale.bf.model.operation.OperationType;

import java.util.Iterator;
import java.util.List;

public abstract class BitExecutor extends BaseExecutor {
    /**
     * Assumed length of bit input.
     */
    protected static final int BITS_NUM = 8;

    @Override
    protected void delegateToChildren(OperationToken token,
                                      List<Integer> tape,
                                      ExecutionData data) {
        if (token.getType() == OperationType.FLIP) {
            tape.set(data.getPointer(), (tape.get(data.getPointer()) ^ 1));
        }
    }

    @Override
    protected void in(Iterator<Integer> input,
                      List<Integer> tape,
                      ExecutionData data) {
        if (data.getNextIn() == -1) {
            data.setNextIn(input.next());
        }
        tape.set(data.getPointer(), data.getNextIn() & 1);
        data.setNextIn(data.getNextIn() >> 1);
        data.setCountIn(data.getCountIn() + 1);
        if (data.getCountIn() == BITS_NUM) {
            data.setCountIn(0);
            data.setNextIn(-1);
        }
    }

    @Override
    protected void out(StringBuilder output,
                       List<Integer> tape,
                       ExecutionData data) {
        var nextOut = data.getNextOut();
        var countOut = data.getCountOut();
        nextOut |= tape.get(data.getPointer()) << countOut;
        if (++countOut == BITS_NUM) {
            output.append((char) nextOut);
            countOut = 0;
            nextOut = 0;
        }
        data.setNextOut(nextOut);
        data.setCountOut(countOut);
    }
}
