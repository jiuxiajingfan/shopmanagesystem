package com.li.shopsystem;

import com.li.shopsystem.utils.Jwtutils;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
class ShopsystemApplicationTests {

    @Test
    void contextLoads() {
        Jwtutils jwtutils = new Jwtutils();
        String jwtToken = jwtutils.getJwtToken("admin", "superadmin");
        System.out.println(jwtToken);
        jwtutils.parse(jwtToken);


    }

}
