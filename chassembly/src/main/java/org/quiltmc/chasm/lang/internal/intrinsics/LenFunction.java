package org.quiltmc.chasm.lang.internal.intrinsics;

import org.quiltmc.chasm.lang.api.ast.IntegerNode;
import org.quiltmc.chasm.lang.api.ast.ListNode;
import org.quiltmc.chasm.lang.api.ast.Node;
import org.quiltmc.chasm.lang.api.eval.Evaluator;
import org.quiltmc.chasm.lang.api.exception.EvaluationException;

public class LenFunction extends IntrinsicFunction {
    @Override
    public Node apply(Evaluator evaluator, Node arg) {
        if (!(arg instanceof ListNode)) {
            throw new EvaluationException("Built-in function \"len\" can only be applied to lists but found " + arg);
        }
        return new IntegerNode(((ListNode) arg).getEntries().size());
    }

    @Override
    String getName() {
        return "len";
    }
}
