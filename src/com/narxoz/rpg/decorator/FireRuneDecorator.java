package com.narxoz.rpg.decorator;

public class FireRuneDecorator extends ActionDecorator {

    public FireRuneDecorator(AttackAction wrappedAction) {
        super(wrappedAction);
    }

    @Override
    public String getActionName() {

        return "Flaming " + getWrappedAction().getActionName();
    }

    @Override
    public int getDamage() {
        return getWrappedAction().getDamage() + 5;
    }

    @Override
    public String getEffectSummary() {

        return getWrappedAction().getEffectSummary() + ", Fire Burn";
    }
}
