package com.zhipengyang.bunnyc2.data.skills;

public abstract class SkillDecorator implements ISkill {
    protected ISkill decoratedSkill;

    protected int mpCost;
    protected float attackBonus;
    protected float defenseBonus;
    protected int specialAttack;
    protected int specialDefense;
    protected float accuracy;

    public SkillDecorator(int mpCost, float attackBonus, float defenseBonus, int specialAttack, int specialDefense, float accuracy) {
        if (accuracy > 1)
            throw new NumberFormatException();
        this.mpCost = mpCost;
        this.attackBonus = attackBonus;
        this.defenseBonus = defenseBonus;
        this.specialAttack = specialAttack;
        this.specialDefense = specialDefense;
        this.accuracy = accuracy;
    }

    public SkillDecorator(ISkill decoratedSkill) {
        this.decoratedSkill = decoratedSkill;
    }
}
