package org.lfl;

final class ExceptionUtils {
    /**
     * Construct an {@code IllegalStateException} with appropriate message.
     *
     * @param u 1st value to be accumulated/merged
     * @param v 2nd value to be accumulated/merged
     */
    static IllegalStateException duplicateKeyException(Object u, Object v) {
        return new IllegalStateException(String.format(
                "Duplicate key(attempted merging values %s and %s)",
                u, v));
    }
}
