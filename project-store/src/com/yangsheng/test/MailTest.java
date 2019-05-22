/**
 * Copyright (C), 2015-2019, yangsheng
 * FileName: MailTest
 * Author:   bmbbms
 * Date:     2019/5/21 12:43
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.yangsheng.test;

import javax.mail.*;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

/**
 * 〈一句话功能简述〉<br/> 
 * 〈〉
 *
 * @author bmbbms
 * @create 2019/5/21
 * @since 1.0.0
 */
public class MailTest {

    public  void sendMail(String mail,String content) throws MessagingException {

        // 1.创建连接对象
        Properties props = new Properties();
		//设置发送的协议
		props.setProperty("mail.transport.protocol", "SMTP");

		//设置发送邮件的服务器
		props.setProperty("mail.host", "smtp.qq.com");


		props.put("mail.smtp.port", 465);

		props.setProperty("mail.smtp.auth", "true");// 指定验证为true
		props.put("mail.smtp.ssl.enable", "true");
		props.put("mail.debug",true);

		// 创建验证器
		Authenticator auth = new Authenticator() {
			public PasswordAuthentication getPasswordAuthentication() {
				//设置发送人的帐号和密码
				return new PasswordAuthentication("1287644549@qq.com", "nojhrwffdwvtjbij");
			}
		};

		Session session = Session.getInstance(props, auth);


		//2.创建邮件对象
        	Message message = new MimeMessage(session);

		//设置发送者
		message.setFrom(new InternetAddress("1287644512249@qq.com"));

		//设置发送方式与接收者
		message.setRecipient(MimeMessage.RecipientType.TO, new InternetAddress(mail));

		//设置邮件主题
		message.setSubject("用户激活");
		// message.setText("这是一封激活邮件，请<a href='#'>点击</a>");

		//设置邮件内容
		message.setContent(content, "text/html;charset=utf-8");

		// 3.创建 Transport用于将邮件发送
		Transport.send(message);
    }
    public static void main(String[] args) throws MessagingException {
        final MailTest mailTest = new MailTest();
        mailTest.sendMail("891765948@qq.com","1234");
    }
}