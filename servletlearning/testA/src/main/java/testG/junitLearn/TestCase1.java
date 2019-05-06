package testG.junitLearn;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import junit.framework.Assert;

public class TestCase1 {

    @Before
    public void before() {
        System.out.println("测试前的准备工作，比如链接数据库等等");
    }
    @After
    public void after() {
        System.out.println("测试结束后的工作，比如关闭链接等等");
    }

    @Test
    public void testSum1() {
        int result = SumUtil.sum1(1, 2);
        Assert.assertEquals(result, 3);
    }

}