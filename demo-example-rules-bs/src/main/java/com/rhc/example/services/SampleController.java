package com.rhc.example.services;

import com.rhc.example.services.common.model.Person;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

/**
 * Created by srang on 8/14/16.
 */
@RestController
@EnableAutoConfiguration
public class SampleController {
    private static Map<Integer, Person> claimList = new HashMap<>();

    @RequestMapping("/")
    @ResponseBody
    public String home() {
        return "Hello World";
    }

    @RequestMapping(value="/claim/{claimid}/{name}", method=POST)
    @ResponseBody
    public String newClaim(@PathVariable("claimid") Integer claimId, @PathVariable("name") String name) {
        if(SampleController.claimList.get(claimId) != null) {
            return "Person exists with that id";
        }
        Person c = new Person(claimId, name);
        SampleController.claimList.put(claimId, c);
        return c.toString();
    }

    @RequestMapping(value="/claims", method=GET)
    @ResponseBody
    public String listClaims() {
        return SampleController.claimList.toString();
    }

}
