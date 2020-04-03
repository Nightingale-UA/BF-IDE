package com.nightingale.bf.service.execute;

import com.nightingale.bf.model.ExecutionData;
import com.nightingale.bf.model.operation.OperationToken;

import java.util.Iterator;
import java.util.List;

public abstract class ByteExecutor extends BaseExecutor {
    /**
     * Length of the value on the tape in bits.
     */
    private static final int BYTE = 0x100;

    @Override
    protected void delegateToChildren(OperationToken token,
                                      List<Integer> tape,
                                      ExecutionData data) {
        switch (token.getType()) {
            case INCR:
                tape.set(data.getPointer(),
                    (tape.get(data.getPointer()) + token.getLength())
                        % BYTE);
                break;
            case DECR:
                var temp = tape.get(data.getPointer()) - token.getLength();
                tape.set(data.getPointer(), (temp < 0) ? BYTE + temp : temp);
                break;
        }
    }

    @Override
    protected void in(Iterator<Integer> input, List<Integer> tape, ExecutionData data) {
        tape.set(data.getPointer(), input.next());
    }

    @Override
    protected void out(StringBuilder output, List<Integer> tape, ExecutionData data) {
        output.append((char) tape.get(data.getPointer()).intValue());
    }
}
