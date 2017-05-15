package com.lee.printer.pojo;

/**
 * User 类：定义用户信息
 * @author leewcc
 */
public final class User {
    /**
     * 用户编号，唯一
     */
    private final Integer id;

    /**
     * 用户账号，用于登陆系统
     */
    private final String userAccount;

    /**
     * 用户个人信息
     */
    private final UserDetail userDeatil;

    /**
     * 用户构造器，通过传入的用户编号、用户账号和用户个人信息来创建
     * @param id - 用户编号
     * @param userAccount - 用户账号
     * @param userDeatil - 用户个人信息
     */
    public User(Integer id, String userAccount, UserDetail userDeatil) {
        this.id = id;
        this.userAccount = userAccount;
        this.userDeatil = userDeatil;
    }

    /**
     * 获取用户账号
     * @return
     */
    public String getUserAccount() {
        return userAccount;
    }


    /**
     * 获取用户姓名
     * @return
     */
    public String getUsername() {
        return userDeatil.getUsername();
    }

    /**
     * 获取用户地址
     * @return
     */
    public String getUserAddress() {
        return userDeatil.getUserAddress();
    }

    /**
     * 获取用户电话
     * @return
     */
    public String getUserPhone() {
        return userDeatil.getUserPhone();
    }

    /**
     * 用户信息内部类，该类封装了用户的个人信息
     */
    private static class UserDetail {
        private String username;
        private String userAddress;
        private String userPhone;


        public UserDetail(String username, String userAddress, String userPhone) {
            this.username = username;
            this.userAddress = userAddress;
            this.userPhone = userPhone;
        }

        private String getUsername() {
            return username;
        }

        private String getUserAddress() {
            return userAddress;
        }

        private String getUserPhone() {
            return userPhone;
        }
    }

    /**
     * 输出用户的信息，格式为：id：XX  用户名：xxx
     * @return
     */
    @Override
    public String toString() {
        return new StringBuilder().append("id：").append(id).append("  用户名：").append(userDeatil.getUsername()).toString();
    }

    /**
     * 当用户 id 相同时，则返回 true
     * @param obj
     * @return
     */
    @Override
    public boolean equals(Object obj) {
        if(this == obj)
            return true;

        if(!(obj instanceof  User))
            return false;

        User user = (User)obj;
        if(id.equals(user.id)) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public int hashCode() {
        return 17 * 31 + id;
    }
}
