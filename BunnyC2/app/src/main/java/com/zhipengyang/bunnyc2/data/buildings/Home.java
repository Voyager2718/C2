package com.zhipengyang.bunnyc2.data.buildings;

import com.zhipengyang.bunnyc2.data.characters.ACharacter;
import com.zhipengyang.bunnyc2.data.equipments.IEquipment;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Home implements IBuilding {
    private static volatile Home INSTANCE = null;

    List<IEquipment> equipments = new LinkedList<>();

    List<ACharacter> characters = new ArrayList<ACharacter>();

    public static Home getInstance() {
        if (INSTANCE == null)
            synchronized (Home.class) {
                if (INSTANCE == null)
                    INSTANCE = new Home();
            }
        return INSTANCE;
    }
}
