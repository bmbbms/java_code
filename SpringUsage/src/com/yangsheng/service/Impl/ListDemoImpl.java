/**
 * Copyright (C), 2015-2019, yangsheng
 * FileName: ListDemoImpl
 * Author:   bmbbms
 * Date:     2019/5/30 9:04
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.yangsheng.service.Impl;

import java.util.*;

/**
 * 〈一句话功能简述〉<br/> 
 * 〈〉
 *
 * @author bmbbms
 * @create 2019/5/30
 * @since 1.0.0
 */
public class ListDemoImpl  {
    private String []arr;
    private List<String> e;
    private Map<String,String> map;
    private Properties pro;
    private Set<String> set;
    public ListDemoImpl() {
    }


    @Override
    public String toString() {
        return "ListDemoImpl{" +
                "arr=" + Arrays.toString(arr) +
                ", e=" + e +
                ", map=" + map +
                ", pro=" + pro +
                ", set=" + set +
                '}';
    }

    public void setArr(String[] arr) {
        this.arr = arr;
    }

    public void setE(List e) {
        this.e = e;
    }

    public void setMap(Map <String, String> map) {
        this.map = map;
    }

    public void setPro(Properties pro) {
        this.pro = pro;
    }

    public void setSet(Set <String> set) {
        this.set = set;
    }
}