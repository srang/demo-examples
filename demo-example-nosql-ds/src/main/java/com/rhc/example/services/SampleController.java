package com.rhc.example.services;

import com.rhc.example.services.common.model.Person;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

/**
 * Created by srang on 8/14/16.
 */
@RestController
@EnableAutoConfiguration
public class SampleController {
    private static Map<Integer, Person> claimList = new HashMap<>();

    @RequestMapping(value="/insert/{claimid}", method=POST)
    @ResponseBody
    public String insertClaim(@PathVariable("claimid") Integer claimid, @RequestParam(value="claim") Person claim) {
        claimList.put(claimid, claim);
        return "Success";
    }
}
