package com.nightingale.bf.service.operation;

import com.nightingale.bf.model.operation.OperationToken;

import java.util.List;

public interface Operations {
    List<OperationToken> tokenize(String code);
}
