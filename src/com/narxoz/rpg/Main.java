package com.narxoz.rpg;

import com.narxoz.rpg.decorator.*;
import com.narxoz.rpg.enemy.BossEnemy;
import com.narxoz.rpg.facade.AdventureResult;
import com.narxoz.rpg.facade.DungeonFacade;
import com.narxoz.rpg.hero.HeroProfile;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== Homework 5 Demo: Decorator + Facade ===\n");

        HeroProfile hero = new HeroProfile("Aragorn", 100);
        BossEnemy boss = new BossEnemy("Sauron", 150, 15);

        AttackAction basic = new BasicAttack("Sword Strike", 10);
        
        AttackAction fireSlash = new FireRuneDecorator(basic);
        
        AttackAction ultimateAttack = new CriticalFocusDecorator(
                                        new PoisonCoatingDecorator(
                                            new FireRuneDecorator(basic)));

        System.out.println("--- Decorator Stacking Proof ---");
        System.out.println("1. Base: " + basic.getActionName() + " | Damage: " + basic.getDamage());
        System.out.println("2. Fire Only: " + fireSlash.getActionName() + " | Damage: " + fireSlash.getDamage());
        System.out.println("3. Ultimate: " + ultimateAttack.getActionName());
        System.out.println("   Total Damage: " + ultimateAttack.getDamage());
        System.out.println("   All Effects: " + ultimateAttack.getEffectSummary());

        System.out.println("\n--- Facade Adventure Start ---");
        DungeonFacade facade = new DungeonFacade().setRandomSeed(42L);
        AdventureResult result = facade.runAdventure(hero, boss, ultimateAttack);

        System.out.println("\n=== ADVENTURE LOG ===");
        for (String line : result.getLog()) {
            System.out.println(line);
        }

        System.out.println("\n=== FINAL SUMMARY ===");
        System.out.println("Winner: " + result.getWinner());
        System.out.println("Rounds played: " + result.getRounds());
        System.out.println("Final Loot: " + result.getReward());

        System.out.println("\n=== Demo Complete ===");
    }
}
