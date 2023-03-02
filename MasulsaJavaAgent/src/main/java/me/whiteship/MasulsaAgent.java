package me.whiteship;

import net.bytebuddy.agent.builder.AgentBuilder;
import net.bytebuddy.description.type.TypeDescription;
import net.bytebuddy.dynamic.DynamicType;
import net.bytebuddy.implementation.FixedValue;
import net.bytebuddy.matcher.ElementMatchers;
import net.bytebuddy.utility.JavaModule;

import javax.swing.tree.FixedHeightLayoutCache;
import java.lang.instrument.Instrumentation;
import java.security.ProtectionDomain;

import static net.bytebuddy.matcher.ElementMatchers.named;

public class MasulsaAgent {

    public static void premain(String agentArgs, Instrumentation inst) {

        new AgentBuilder.Default()
                .type(ElementMatchers.any())
                .transform(
                        (builder, typeDescription, classLoader, module, protectionDomain)
                                -> builder.method(named("pullOut")).intercept(FixedValue.value("Rabbit3!!")))
                .installOn(inst);
    }
}
