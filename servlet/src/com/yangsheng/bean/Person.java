/**
 * Copyright (C), 2015-2019, yangsheng
 * FileName: Person
 * Author:   bmbbms
 * Date:     2019/5/15 11:47
 * Description: preson
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.yangsheng.bean;

/**
 * 〈一句话功能简述〉<br/> 
 * 〈preson〉
 *
 * @author bmbbms
 * @create 2019/5/15
 * @since 1.0.0
 */
public class Person {
    private String username;
    private String password;

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

    private  void eat(){
        System.out.println("我在吃饭");
    }

    private  void eat(String name){
        System.out.println(name+"在吃饭");
    }
}