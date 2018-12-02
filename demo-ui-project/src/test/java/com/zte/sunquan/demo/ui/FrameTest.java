package com.zte.sunquan.demo.ui;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.concurrent.CountDownLatch;

import org.junit.Test;

/**
 * Created by 10184538 on 2018/6/1.
 */
public class FrameTest {
    @Test
    public void creatFrame() throws InterruptedException {
        CountDownLatch latch = new CountDownLatch(1);
        Frame frame = new Frame("abc");
        Button button = new Button("open");
        frame.add(button);
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                super.windowClosing(e);
                frame.dispose();
                latch.countDown();
            }
        });
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println(e.getActionCommand());
                FileDialog fileDialog = new FileDialog(frame, "open", FileDialog.LOAD);
                fileDialog.setFile("*.txt");
                fileDialog.setVisible(true);
            }
        });
        frame.setLocation(500, 500);
        frame.setSize(200, 100);
        frame.setVisible(true);
        latch.await();
    }
}
