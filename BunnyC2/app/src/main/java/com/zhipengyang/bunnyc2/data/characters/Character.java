package com.zhipengyang.bunnyc2.data.characters;

import com.zhipengyang.bunnyc2.data.skills.ISkill;

import java.util.ArrayList;
import java.util.List;

public abstract class Character {
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

    public void addSkills(List<ISkill> skills) {
        this.skills = skills;
    }

    public List<ISkill> getSkills() {
        return this.skills;
    }

    public Character addSkill(ISkill skill) {
        this.skills.add(skill);
        return this;
    }

    public int getHp() {
        return hp;
    }

    public Character setHp(int hp) {
        this.hp = hp;
        return this;
    }

    public int getMp() {
        return mp;
    }

    public Character setMp(int mp) {
        this.mp = mp;
        return this;
    }

    public int getAttack() {
        return attack;
    }

    public Character setAttack(int attack) {
        this.attack = attack;
        return this;
    }

    public int getDefense() {
        return defense;
    }

    public Character setDefense(int defense) {
        this.defense = defense;
        return this;
    }

    public int getSpecialAttack() {
        return specialAttack;
    }

    public Character setSpecialAttack(int specialAttack) {
        this.specialAttack = specialAttack;
        return this;
    }

    public int getSpecialDefense() {
        return specialDefense;
    }

    public Character setSpecialDefense(int specialDefense) {
        this.specialDefense = specialDefense;
        return this;
    }

    public int getSpeed() {
        return speed;
    }

    public Character setSpeed(int speed) {
        this.speed = speed;
        return this;
    }

    public String getName() {
        return name;
    }

    public Character setName(String name) {
        this.name = name;
        return this;
    }
}
