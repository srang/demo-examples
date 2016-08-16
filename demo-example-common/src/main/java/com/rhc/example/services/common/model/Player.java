package com.rhc.example.services.common.model;

/**
 * Created by srang on 8/15/16.
 */
public class Player extends Person{

    private Skill skill;
    public Player(String state, String firstName, String lastName, String email) {
        super(state, firstName, lastName, email);
    }

    private enum Skill {
        NEWBIE ("INEXPERIENCED"),
        ALRIGHT ("COMPETITIVE"),
        AWESOME ("ADVANCED");

        private String skill;
        Skill(String skill) {
            this.skill = skill;
        }

        boolean equals(Skill stateObj) {
            return this.skill.equals(stateObj.skill);
        }
    }
}
