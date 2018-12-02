package com.zte.sunquan.demo.pla;

/**
 * Created by 10184538 on 2017/6/14.
 */
public class PLATest {
    public static double alpha=0.2;
    public static int compute(double input[], double weight[]) {
        double sum = 0.0;
        for (int i = 0; i < input.length; i++) {
            sum += input[i] * weight[i];
        }
        if (sum > 0.0)
            return 1;
        else
            return -1;
    }

    public static void main(String[] args) {
        double data[][] = {
                {-1.0, -1.0},
                {-1.0, 1.0},
                {1.0, -1.0},
                {1.0, 1.0}
        };
        double[] result = {-1.0, 1.0, 1.0, 1.0};
        double weight[] = {0.0, 0.0};
        for (int i = 0; i < 4; i++) {
            int temp = compute(data[i], weight);
            if (temp != result[i]) {
                for (int j=0;j<2;j++){
                    weight[j]+=0.2;
                }
            }
        }


    }
}
