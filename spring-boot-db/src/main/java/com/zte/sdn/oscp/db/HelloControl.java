package com.zte.sdn.oscp.db;

import com.zte.sdn.oscp.mdb.client.MySqlClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: Livio
 * @Date: 2020/10/9 23:20
 */
@RestController
public class HelloControl {
    @Autowired
    private MySqlClient mySqlClient;

    @GetMapping("/show")
    public String showName() {
        return mySqlClient.getUrl();
    }
}
