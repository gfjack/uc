package com.edu.uc.constants.enums;


public enum UserRole {

  /**
   * 学生
   */
  STUDENT(0, "学生"),

  /**
   * 老师
   */
  TEACHER(1, "老师"),

  /**
   * 家长
   */
  GUARDIAN(2, "家长"),

  /**
   * 管理员
   */
  ADMIN(3, "管理员");

  private Integer code;
  private String name;

  UserRole(Integer code, String name) {
    this.code = code;
    this.name = name;
  }

  public static UserRole getByName(String name) {
    for (UserRole userRole : UserRole.values()) {
      if (userRole.name.equalsIgnoreCase(name)) {
        return userRole;
      }
    }

    return null;
  }

  public static UserRole getByCode(Integer code) {
    for (UserRole userRole : UserRole.values()) {
      if (userRole.code.equals(code)) {
        return userRole;
      }
    }

    return null;
  }

}
