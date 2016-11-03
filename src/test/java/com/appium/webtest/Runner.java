package com.appium.webtest;

import com.appium.manager.ParallelThread;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * 申请进件 → 确认贷款 → 卡卷支付 → 提前还清
 * @author john
 * @data 2016年10月10日
 */
public class Runner {
    @Test public static void testApp() throws Exception {

        ParallelThread parallelThread = new ParallelThread();
        List<String> tests = new ArrayList<>();
//        tests.add("InformationTest");
//        tests.add("CopyOfFlowOtherTest");
        tests.add("FlowOtherTest");
        parallelThread.runner("com.appium.webtest", tests);
    }
}

