package com.tofdragon.todolist.command;

import org.junit.After;
import org.junit.Rule;
import org.junit.contrib.java.lang.system.SystemOutRule;

/**
 * 抽象的命令测试
 *
 * @author sunjing
 */
public abstract class AbstractCommandTest {

    @Rule
    public final SystemOutRule systemOutRule = new SystemOutRule().enableLog();

    @After
    public void after() {
        systemOutRule.clearLog();
    }
}
