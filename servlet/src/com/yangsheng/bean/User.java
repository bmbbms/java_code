/**
 * Copyright (C), 2015-2019, yangsheng
 * FileName: User
 * Author:   bmbbms
 * Date:     2019/5/13 9:47
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.yangsheng.bean;

/**
 * 〈一句话功能简述〉<br/> 
 * 〈〉
 *
 * @author bmbbms
 * @create 2019/5/13
 * @since 1.0.0
 */
/**
id int primary key auto_increment,
	username varchar(20),
	password varchar(20),
	email varchar(20),
	name varchar(20),
	sex varchar(10),
	birthday date,
    hobby varchar(50)

 */
public class User {
    private int id;
    private  String username;
    private  String password;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}