package com.zte.sunquan.demo.junit4;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by 10184538 on 2016/12/23.
 */
public class Junit4Test extends BaseTest{
    @Before
    public void before() {
        System.out.println("@Before");
    }

    @Test
    /**
     *Mark your test cases with @Test annotations.
     *You don’t need to prefix your test cases with “test”.
     *tested class does not need to extend from “TestCase” class.
     * @BeforeClass
     *@Before
     *@Test
     *@After
     *@AfterClass
     */
    public void test() {
        System.out.println("@Test");
        assertEquals(5 + 5, 10);
    }

    /**
     * @Before
     * @Ignore
     * @After
     */
    @Ignore
    @Test
    public void testIgnore() {
        System.out.println("@Ignore");
    }

    /**
     * @BeforeClass
     *@Before
     *@Test(timeout = 50)
     *@After
     *@AfterClass
     */
    @Test(timeout = 50)
    public void testTimeout() {
        System.out.println("@Test(timeout = 50)");
        assertEquals(5 + 5, 10);
    }

    @Test(expected = ArithmeticException.class)
    public void testExpected() {
        System.out.println("@Test(expected = Exception.class)");
        throw new ArithmeticException();
    }

    @After
    public void after() {
        System.out.println("@After");
    }

    @BeforeClass
    public static void beforeClass() {
        System.out.println("@BeforeClass");
    }

    @AfterClass
    public static void afterClass() {
        System.out.println("@AfterClass");
    }
};