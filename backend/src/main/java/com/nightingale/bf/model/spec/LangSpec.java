package com.nightingale.bf.model.spec;

import com.nightingale.bf.model.operation.OperationType;

import java.util.Map;

/**
 * Interface for getting common language details.
 */
public interface LangSpec {
    /**
     * Get language key, recognized by system.
     * @return String key
     */
    String getKey();

    /**
     * Get valid set of operations for the language.
     * @return String with operations
     */
    Map<OperationType, String> getOperations();

    /**
     * Get pattern of useless operation combinations in language.
     * @return String pattern
     */
    String getOptimizationPattern();
}
