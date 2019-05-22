/**
 * Copyright (C), 2015-2019, yangsheng
 * FileName: MyConventer
 * Author:   bmbbms
 * Date:     2019/5/21 11:33
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.yangsheng.Conventer;

import org.apache.commons.beanutils.Converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 〈一句话功能简述〉<br/> 
 * 〈〉
 *
 * @author bmbbms
 * @create 2019/5/21
 * @since 1.0.0
 */
public class MyConventer implements Converter {

	@Override
	public Object convert(Class clazz, Object value) {
		// class 要装成的类型
		// object 页面上传入的值

		//将object 转成 date
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		try {
			Date date = sdf.parse((String)value);
			return date;
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}

}
