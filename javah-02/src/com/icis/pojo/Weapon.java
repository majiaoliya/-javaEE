package com.icis.pojo;

public class Weapon {
    String weaponName;
    int killPower, weaponCount, addr;

    @Override
    public String toString() {
        return "Weapon{" +
                "weaponName='" + weaponName + '\'' +
                ", killPower=" + killPower +
                ", weaponCount=" + weaponCount +
                ", addr=" + addr +
                '}';
    }

    public String getWeaponName() {
        return weaponName;
    }

    public void setWeaponName(String weaponName) {
        this.weaponName = weaponName;
    }

    public int getKillPower() {
        return killPower;
    }

    public void setKillPower(int killPower) {
        this.killPower = killPower;
    }

    public int getWeaponCount() {
        return weaponCount;
    }

    public void setWeaponCount(int weaponCount) {
        this.weaponCount = weaponCount;
    }

    public int getAddr() {
        return addr;
    }

    public void setAddr(int addr) {
        this.addr = addr;
    }

    public Weapon() {
    }

    public Weapon(String weaponName, int killPower, int weaponCount, int addr) {
        this.weaponName = weaponName;
        this.killPower = killPower;
        this.weaponCount = weaponCount;
        this.addr = addr;
    }
}
