package com.zte.sunquan.demo.hello.impl;

import com.zte.sunquan.demo.hello.SeeYouService;
import org.apache.felix.scr.annotations.Component;
import org.apache.felix.scr.annotations.Service;

/**
 * Created by 10184538 on 2017/1/13.
 */
@Component(immediate = true)
@Service
public class SeeYouImpl implements SeeYouService {
    @Override
    public String seeYou(String name) {
        return "see you again."+name;
    }
}
