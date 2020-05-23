package com.resource;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class ResourceServerController {

    @RequestMapping(value="/hello",method=RequestMethod.GET, produces={"application/JSON"})
    public String getHello() {
        return "Hello";
    }
}
