package vgalaxy.echoserver.limiter;

import com.alibaba.csp.sentinel.slots.block.RuleConstant;
import com.alibaba.csp.sentinel.slots.block.flow.FlowRule;
import com.alibaba.csp.sentinel.slots.block.flow.FlowRuleManager;

import java.util.ArrayList;
import java.util.List;

public class FlowRules {
    public static void initFlowRules() {
        List<FlowRule> rules = new ArrayList<>();
        FlowRule rule = new FlowRule();
        rule.setResource("echo");
        rule.setGrade(RuleConstant.FLOW_GRADE_QPS);
        // Set limit QPS to 3.
        rule.setCount(3);
        rules.add(rule);
        FlowRuleManager.loadRules(rules);
    }
}
