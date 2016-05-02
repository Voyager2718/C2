package com.zhipengyang.bunnyc2.data.characters;

import com.zhipengyang.bunnyc2.data.EventListener;
import com.zhipengyang.bunnyc2.data.skills.ISkill;

import java.util.ArrayList;
import java.util.List;

public abstract class ACharacter implements EventListener {
    protected int hp;
    protected int mp;
    protected int attack;
    protected int defense;
    protected int specialAttack;
    protected int specialDefense;
    protected int speed;
    protected String name;

    //Status
    protected float attackBonus;
    protected float defenseBonus;

    protected List<ISkill> skills = new ArrayList<ISkill>();

    public ACharacter addSkills(List<ISkill> skills) {
        this.skills = skills;
        return this;
    }

    public List<ISkill> getSkills() {
        return this.skills;
    }

    public ACharacter addSkill(ISkill skill) {
        this.skills.add(skill);
        return this;
    }

    public int getHp() {
        return hp;
    }

    public ACharacter setHp(int hp) {
        this.hp = hp;
        return this;
    }

    public int getMp() {
        return mp;
    }

    public ACharacter setMp(int mp) {
        this.mp = mp;
        return this;
    }

    public int getAttack() {
        return attack;
    }

    public ACharacter setAttack(int attack) {
        this.attack = attack;
        return this;
    }

    public int getDefense() {
        return defense;
    }

    public ACharacter setDefense(int defense) {
        this.defense = defense;
        return this;
    }

    public int getSpecialAttack() {
        return specialAttack;
    }

    public ACharacter setSpecialAttack(int specialAttack) {
        this.specialAttack = specialAttack;
        return this;
    }

    public int getSpecialDefense() {
        return specialDefense;
    }

    public ACharacter setSpecialDefense(int specialDefense) {
        this.specialDefense = specialDefense;
        return this;
    }

    public int getSpeed() {
        return speed;
    }

    public ACharacter setSpeed(int speed) {
        this.speed = speed;
        return this;
    }

    public String getName() {
        return name;
    }

    public ACharacter setName(String name) {
        this.name = name;
        return this;
    }
}
