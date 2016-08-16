package com.rhc.example.services.common.model;

import com.rhc.example.services.common.exception.InvalidStateException;

/**
 * Created by srang on 8/14/16.
 * Based on State design pattern https://sourcemaking.com/design_patterns/state
 */
public interface StatefulEntity {
    void goTo(String target) throws InvalidStateException;
}
