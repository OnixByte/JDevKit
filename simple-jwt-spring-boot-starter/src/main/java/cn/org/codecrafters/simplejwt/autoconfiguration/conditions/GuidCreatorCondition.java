package cn.org.codecrafters.simplejwt.autoconfiguration.conditions;

import cn.org.codecrafters.guid.GuidCreator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

import java.util.Objects;

/**
 * GuidCreatorCondition
 * <p>
 * Created on 28 Aug 2023
 *
 * @author Zihlu Wang
 */
@Slf4j
public class GuidCreatorCondition implements Condition {
    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
        log.debug("[GuidCreatorCondition] --- Detecting bean jtiCreator.");
        final var beanFactory = Objects.requireNonNull(context.getBeanFactory());
        var isContainJtiCreator = beanFactory.containsBean("jtiCreator");
        log.debug("[GuidCreatorCondition] --- Bean jtiCreator {} been created.", isContainJtiCreator ? "has" : "has not");
        if (isContainJtiCreator) {
            var result = !(beanFactory.getBean("jtiCreator") instanceof GuidCreator<?>);
            log.debug("[GuidCreatorCondition] --- Create jtiCreator now? {}.", result ? "yes" : "no");
            return result;
        }
        log.debug("[GuidCreatorCondition] --- Condition passed.");
        return true;
    }
}
