/**
 * Copyright (C), 2015-2019, yangsheng
 * FileName: Coding
 * Author:   bmbbms
 * Date:     2019/5/13 19:03
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.yangsheng.test;

import java.io.UnsupportedEncodingException;
import java.util.Arrays;

/**
 * 〈一句话功能简述〉<br/> 
 * 〈〉
 *
 * @author bmbbms
 * @create 2019/5/13
 * @since 1.0.0
 */
public class Coding {
    public static void main(String[] args) throws UnsupportedEncodingException {
        String filename = "中文";
        System.out.println(Arrays.toString(filename.getBytes()));


    }
}