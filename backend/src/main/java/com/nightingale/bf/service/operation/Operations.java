package com.nightingale.bf.service.operation;

import com.nightingale.bf.model.operation.OperationToken;

import java.util.Collection;

public interface Operations {
    Collection<OperationToken> tokenize(String code);
}
