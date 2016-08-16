package com.rhc.example.services.common.model;

import com.rhc.example.services.common.exception.InvalidStateException;

/**
 * Created by srang on 8/14/16.
 */
public class Person implements Entity {
    private State state;
    private String firstName;
    private String lastName;
    private String email;

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Person(String state, String firstName, String lastName, String email) {
        this.state = State.valueOf(state);
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    @Override
    public String toString() {
        return "Person{" +
                "state=" + state +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                '}';
    }

    /******************
     * State modeling *
     ******************/

    /*
        Logic for state transitions should be limited to looking at current state. Anything beyond that
        should be left to the callers of state transition functions. The purpose here is to enforce the
        state model diagram for a claim.
     */

    public void goTo(String t) throws InvalidStateException {
        State target = State.valueOf(t);
        switch (target) {
            case UNSUBMITTED:
                // can always fall back to here if no other state applies
                this.state = State.UNSUBMITTED;
                break;
            case ENTERED:
                // represents a new claim that has no evaluations and has never been persisted
                if (this.state.equals(State.UNSUBMITTED)) {
                    this.state = State.ENTERED;
                }
                break;
            case PENDING:
                // This state represents when a claim has unpersisted evaluations
                if (this.state.equals(State.ENTERED) || this.state.equals(State.REJECTED) || this.state.equals(State.APPROVED)) {
                    this.state = State.PENDING;
                }
                break;
            case APPROVED:
                if (this.state.equals(State.PENDING)) {
                    this.state = State.APPROVED;
                }
                break;
            case REJECTED:
                if (this.state.equals(State.PENDING)) {
                    this.state = State.REJECTED;
                }
                break;
        }
        if (!this.state.equals(target)) {
            throw new InvalidStateException("Target state, " + target.toString() + ", could not be set from " + this.state.toString() + " on object " + this.toString());
        }
    }

    protected enum State {
        UNSUBMITTED ("UNSUBMITTED"),
        ENTERED ("ENTERED"),
        PENDING ("PENDING"),
        APPROVED ("APPROVED"),
        REJECTED ("REJECTED");

        private String state;
        State(String state) {
            this.state = state;
        }

        boolean equals(State stateObj) {
            return this.state.equals(stateObj.state);
        }
    }

}
