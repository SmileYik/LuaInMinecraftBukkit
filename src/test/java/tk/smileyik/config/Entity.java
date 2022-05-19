package tk.smileyik.config;

import java.util.Arrays;

public class Entity {
  String aString;
  int anInt;
  float aFloat;
  char aChar;
  boolean aBoolean;
  double aDouble;
  byte[] bytes;
  double[] doubles;
  char[] chars;
  int[] ints;
  String[] strings;

  Entity[] entities;

  Entity entity;

  public void setaString(String aString) {
    this.aString = aString;
  }

  public void setAnInt(int anInt) {
    this.anInt = anInt;
  }

  public void setaFloat(float aFloat) {
    this.aFloat = aFloat;
  }

  public void setaChar(char aChar) {
    this.aChar = aChar;
  }

  public void setaBoolean(boolean aBoolean) {
    this.aBoolean = aBoolean;
  }

  public void setaDouble(double aDouble) {
    this.aDouble = aDouble;
  }

  public void setBytes(byte[] bytes) {
    this.bytes = bytes;
  }

  public void setDoubles(double[] doubles) {
    this.doubles = doubles;
  }

  public void setChars(char[] chars) {
    this.chars = chars;
  }

  public void setInts(int[] ints) {
    this.ints = ints;
  }

  public void setStrings(String[] strings) {
    this.strings = strings;
  }

  public void setEntities(Entity[] entities) {
    this.entities = entities;
  }

  public void setEntity(Entity entity) {
    this.entity = entity;
  }

  @Override
  public String toString() {
    return "Entity{" +
            "aString='" + aString + '\'' +
            ", anInt=" + anInt +
            ", aFloat=" + aFloat +
            ", aChar=" + aChar +
            ", aBoolean=" + aBoolean +
            ", aDouble=" + aDouble +
            ", bytes=" + Arrays.toString(bytes) +
            ", doubles=" + Arrays.toString(doubles) +
            ", chars=" + Arrays.toString(chars) +
            ", ints=" + Arrays.toString(ints) +
            ", strings=" + Arrays.toString(strings) +
            ", entities=" + Arrays.toString(entities) +
            ", entity=" + entity +
            '}';
  }
}
