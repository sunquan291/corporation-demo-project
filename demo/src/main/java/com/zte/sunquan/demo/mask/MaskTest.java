package com.zte.sunquan.demo.mask;

/**
 * Created by 10184538 on 2017/3/6.
 */
public class MaskTest {

    private int sendPlace = 0;

    private static int goNanJing = 1;
    private static int goShangHai = 1 << 1;
    private static int goBeiJing = 1 << 4;


    public void addPlace(int place) {
        this.sendPlace = this.sendPlace | place;
    }

    public void removePlace(int place) {
        this.sendPlace = this.sendPlace & ~place;
    }

    public void print() {
        System.out.println("-------------------");
        if ((sendPlace & goNanJing) != 0) {
            System.out.println("goNanjing");
        }
        if ((sendPlace & goShangHai) != 0) {
            System.out.println("goShangHai");
        }
        if ((sendPlace & goBeiJing) != 0) {
            System.out.println("goBeiJing");
        }
    }

    public static void main(String[] args) {
        MaskTest maskTest = new MaskTest();
        maskTest.addPlace(goNanJing);
        maskTest.print();
        maskTest.addPlace(goShangHai);
        maskTest.addPlace(goBeiJing);
        maskTest.print();
        maskTest.removePlace(goBeiJing);
        maskTest.print();
    }
}
