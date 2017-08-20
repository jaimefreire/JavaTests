package com.example.thread.livelock.codewars;
import org.junit.runners.JUnit4;

import static org.junit.Assert.assertEquals;

public class Fighters {

    public static void main(String[] args) {

        assertEquals("Lew", Fighters.declareWinner(new Fighter("Lew", 10, 2),new Fighter("Harry", 5, 4), "Lew"));
        assertEquals("Harry", Fighters.declareWinner(new Fighter("Lew", 10, 2),new Fighter("Harry", 5, 4), "Harry"));
        assertEquals("Harald", Fighters.declareWinner(new Fighter("Harald", 20, 5), new Fighter("Harry", 5, 4), "Harry"));
        assertEquals("Harald", Fighters.declareWinner(new Fighter("Harald", 20, 5), new Fighter("Harry", 5, 4), "Harald"));
        assertEquals("Harald", Fighters.declareWinner(new Fighter("Jerry", 30, 3), new Fighter("Harald", 20, 5), "Jerry"));
        assertEquals("Harald", Fighters.declareWinner(new Fighter("Jerry", 30, 3), new Fighter("Harald", 20, 5), "Harald"));    }

    public static String declareWinner(Fighter fighter1, Fighter fighter2, String firstAttacker) {

        String winner = "";
        if (fighter2.name.equals(firstAttacker)) {
            Fighter tempFighter = fighter1;
            fighter1 = fighter2;
            fighter2 = tempFighter;
        }

        while (fighter1.health > 0 && fighter2.health > 0) {
            //Turn
            fighter2.health -= fighter1.damagePerAttack;
            fighter1.health -= fighter2.damagePerAttack;
            //Assess
            if (fighter2.health <= 0) {
                winner = fighter1.name;
            } else if (fighter1.health <= 0) {
                winner = fighter2.name;
            }
        }
        return winner;
    }


    static class Fighter {
        String name;
        int health, damagePerAttack;

        public Fighter(String name, int health, int damagePerAttack) {
            this.name = name;
            this.health = health;
            this.damagePerAttack = damagePerAttack;
        }
    }
}
