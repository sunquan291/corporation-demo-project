package com.zte.sunquan.spring;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * ReadingListController class
 *
 * @author 10184538
 * @date 2019/6/18
 */
@Controller
    @RequestMapping("/readingList")
public class ReadingListController {
    @RequestMapping(value = "ab",method = RequestMethod.GET)
    public String readersBooks() {
        System.out.println("aaaaaaaaa");
        return "error";
    }
}
