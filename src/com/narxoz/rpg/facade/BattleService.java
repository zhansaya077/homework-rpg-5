package com.narxoz.rpg.facade;

import com.narxoz.rpg.decorator.AttackAction;
import com.narxoz.rpg.enemy.BossEnemy;
import com.narxoz.rpg.hero.HeroProfile;
import java.util.Random;

public class BattleService {
    private Random random = new Random(1L);

    public BattleService setRandomSeed(long seed) {
        this.random = new Random(seed);
        return this;
    }

    public AdventureResult battle(HeroProfile hero, BossEnemy boss, AttackAction action) {
        AdventureResult result = new AdventureResult();
        int rounds = 0;
        int maxRounds = 10;

        result.addLine("Battle starts! Hero: " + hero.getName() + " vs Boss: " + boss.getName());
        result.addLine("Hero is using: " + action.getActionName() + " (" + action.getEffectSummary() + ")");

        while (hero.getHealth() > 0 && boss.getHealth() > 0 && rounds < maxRounds) {
            rounds++;
            result.addLine("--- Round " + rounds + " ---");

            int heroDamage = action.getDamage();
            
            if (random.nextInt(5) == 0) { 
                heroDamage += 5;
                result.addLine("Lucky strike! Hero deals bonus +5 damage.");
            }
            
            boss.takeDamage(heroDamage);
            result.addLine(hero.getName() + " deals " + heroDamage + " damage. Boss HP: " + boss.getHealth());

            if (boss.getHealth() <= 0) {
                result.setWinner(hero.getName());
                result.addLine("The Boss has been defeated!");
                break;
            }

            int bossDamage = boss.getAttackPower();
            hero.takeDamage(bossDamage);
            result.addLine(boss.getName() + " strikes back for " + bossDamage + " damage. Hero HP: " + hero.getHealth());

            if (hero.getHealth() <= 0) {
                result.setWinner(boss.getName());
                result.addLine(hero.getName() + " has fallen in battle...");
                break;
            }
        }

        result.setRounds(rounds);
        
        if (result.getWinner() == null || result.getWinner().equals("TODO")) {
            if (hero.getHealth() > boss.getHealth()) {
                result.setWinner(hero.getName());
            } else {
                result.setWinner(boss.getName());
            }
        }

        return result;
    }
}
