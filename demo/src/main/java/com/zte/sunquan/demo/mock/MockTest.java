package com.zte.sunquan.demo.mock;

import java.io.File;
import java.lang.reflect.Field;
import java.util.Set;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Matchers;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import org.powermock.reflect.Whitebox;

/**
 * Created by sunquan on 2017/12/6.
 */
@RunWith(PowerMockRunner.class)
@PrepareForTest({UserUtils.class})
public class MockTest {
    @Test
    public void testMock1() {
        //静态方法
        PowerMockito.mockStatic(UserUtils.class);
        PowerMockito.when(UserUtils.getOutput()).thenReturn("boy");
        System.out.println(UserUtils.getOutput());
        UserUtils mock = PowerMockito.mock(UserUtils.class);
        PowerMockito.when(mock.getName()).thenReturn("girl");
        System.out.println(mock.getName());
    }

    @Test
    public void testMock2() {
        //普通方法
        UserUtils mock = PowerMockito.mock(UserUtils.class);
        PowerMockito.when(mock.getName()).thenReturn("girl");
        System.out.println(mock.getName());
    }

    @Test
    public void testMock3() {
        //方法参数1
        UserUtils utils = new UserUtils();
        File mock = PowerMockito.mock(File.class);
        PowerMockito.when(mock.exists()).thenReturn(false);
        System.out.println(utils.isExit(mock));
    }

    @Test
    public void testMock4() {
        //方法参数2
        UserUtils utils = new UserUtils();
        File mock = PowerMockito.mock(File.class);
        PowerMockito.when(mock.exists()).thenReturn(true);
        System.out.println(utils.copyFile(mock));
    }

    @Test
    public void testMock5() throws Exception {
        //有参数的方法1
        UserUtils mock = PowerMockito.mock(UserUtils.class);
        PowerMockito.when(mock, "isExit", Matchers.any(File.class)).thenReturn(true);
        PowerMockito.when(mock.copyFile(Matchers.any(File.class))).thenCallRealMethod();
        System.out.println(mock.copyFile(Matchers.any(File.class)));
    }

    @Test
    public void testMock6() throws Exception {
        //有参数的方法2
        UserUtils mock = PowerMockito.mock(UserUtils.class);
        PowerMockito.whenNew(UserUtils.class).withArguments("sunquan").thenReturn(mock);
        PowerMockito.when(mock.getName()).thenReturn("wang");
        System.out.println(new UserUtils("sunquan").getName());
    }

    @Test
    public void testMock7() throws Exception {
        //设置参数
        UserUtils utils = new UserUtils();
        Whitebox.setInternalState(utils, "name", "sunquan");
        System.out.println(utils.getName());
    }

    @Test
    public void testMock8() throws Exception {
        //设置静态参数
        Set<Field> staticFields = Whitebox.getAllStaticFields(UserUtils.class);
        staticFields.stream().forEach(p -> {
            p.setAccessible(true);
            try {
                p.set(null, "sunquan");
                System.out.println(p.get(null));
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        });
        System.out.println(UserUtils.LINE);//注意这里返回的是仍是初始值
    }

    @Test
    public void testMock9() throws Exception {
        //定制返回值
        int i = 0;
        UserUtils mock = PowerMockito.mock(UserUtils.class);
        PowerMockito.whenNew(UserUtils.class).withArguments("sunquan").thenReturn(mock);
        PowerMockito.when(mock.getName()).thenAnswer(p -> {
//            String name = (String) p.getArguments()[0];
//            System.out.println(name);
//            if (name.equals("sunquan"))
//                return "sunquan1";
//            else
//                return null;
            if (i == 0)
                return "sunquan+0";
            String result = (String) p.callRealMethod();
            return result;

        });
        System.out.println(new UserUtils("sunquan").getName());
    }
}
