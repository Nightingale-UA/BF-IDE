package com.nightingale.bf.service.operation;

import com.nightingale.bf.model.operation.OperationToken;
import com.nightingale.bf.model.operation.OperationType;

import java.util.List;
import java.util.Map;
import java.util.regex.MatchResult;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import static com.nightingale.bf.model.RegexConstants.OR;

public abstract class BaseOperations implements Operations {

    @Override
    public List<OperationToken> tokenize(String code) {
        return Pattern.compile(String.join(OR, getOperations().values()))
            .matcher(code).results()
            .map(MatchResult::group)
            .map(this::createToken)
            .collect(Collectors.toList());
    }

    private OperationToken createToken(String value) {
        return new OperationToken(determineType(value), value.length());
    }

    private OperationType determineType(String s) {
        return getOperations().entrySet().stream()
            .filter(entry -> s.matches(entry.getValue()))
            .map(Map.Entry::getKey)
            .findFirst().orElseThrow();
    }

    protected abstract Map<OperationType, String> getOperations();
}
