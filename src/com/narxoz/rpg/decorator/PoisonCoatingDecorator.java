package com.narxoz.rpg.decorator;

public class PoisonCoatingDecorator extends ActionDecorator {

    public PoisonCoatingDecorator(AttackAction wrappedAction) {
        super(wrappedAction);
    }

    @Override
    public String getActionName() {
    
        return "Venomous " + getWrappedAction().getActionName();
    }

    @Override
    public int getDamage() {
        
        return getWrappedAction().getDamage() + 3;
    }

    @Override
    public String getEffectSummary() {
       
        return getWrappedAction().getEffectSummary() + ", Poison Over Time";
    }
}
