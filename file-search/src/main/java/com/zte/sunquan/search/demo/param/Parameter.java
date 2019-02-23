package com.zte.sunquan.search.demo.param;

import java.io.File;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import net.sourceforge.argparse4j.annotation.Arg;

/**
 * Parameter class
 *
 * @author 10184538
 * @date 2019/2/23
 */
@Getter
@Setter
@ToString
public class Parameter {
    @Arg(dest = "name")
    private String name;
    @Arg(dest = "operation")
    private String operation;
    @Arg(dest = "dir")
    private File directory;
}
