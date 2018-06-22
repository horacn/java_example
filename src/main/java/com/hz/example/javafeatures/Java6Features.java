package com.hz.example.javafeatures;

import java.awt.Desktop;
import java.io.Console;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

import javax.tools.JavaCompiler;
import javax.tools.ToolProvider;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import com.hz.example.pojo.Customer;
import com.hz.example.pojo.User;
import com.hz.example.pojo.UserList;
import org.junit.Test;

/**
 * JDK 1.6新特性
 *
 * @author hezhao
 * @Time 2016年3月2日 下午2:35:55
 * @Description 无
 * @version V 1.0
 */
public class Java6Features {

	/**
	 * 1.Desktop类和SystemTray类 前者可以用来打开系统默认浏览器浏览指定的URL,打开系统默认邮件客户端给指定的邮箱发邮件,
	 * 用默认应用程序打开或编辑文件(比如,用记事本打开以txt为后缀名的文件),用系统默认的打印机打印文档; 后者可以用来在系统托盘区创建一个托盘程序.
	 *
	 * @throws IOException
	 * @throws URISyntaxException
	 */
	@Test
	public void test1() throws Exception {
		Desktop desktop = Desktop.getDesktop();
		// 浏览网址
		desktop.browse(URI.create("www.baidu.com"));
		// 发送邮件
		// desktop.mail(new URI("mailto:zhao.he@paybay.cn"));
		// 打开文件
		// desktop.open(new File("d:\\aaa.html"));
		// desktop.open(new File("d:\\aaa.txt"));
		// desktop.open(new File("d:\\01.jpg"));
		// 编辑文件
		// desktop.edit(new File("d:\\01.jpg"));
		// 打印
		// desktop.print(new File("d:\\aaa.txt"));
	}

	/**
	 使用JAXB2来实现对象与XML之间的映射

	 JAXB是Java Architecture for XML Binding的缩写，可以将一个Java对象转变成为XML格式，反之亦然。

	 我们把对象与关系数据库之间的映射称为ORM, 其实也可以把对象与XML之间的映射称为OXM(Object XML Mapping). 原来JAXB是Java EE的一部分，在JDK6中，SUN将其放到了Java SE中，这也是SUN的一贯做法。JDK6中自带的这个JAXB版本是2.0, 比起1.0(JSR 31)来，JAXB2(JSR 222)用JDK5的新特性Annotation来标识要作绑定的类和属性等，这就极大简化了开发的工作量。

	 实际上，在Java EE 5.0中，EJB和Web Services也通过Annotation来简化开发工作。另外,JAXB2在底层是用StAX(JSR 173)来处理XML文档。除了JAXB之外，我们还可以通过XMLBeans和Castor等来实现同样的功能。
	 @throws Exception
	 */
	@Test
	public void test2() throws Exception {
		Customer customer = new Customer();
		customer.setId(100);
		customer.setName("mkyong");
		customer.setAge(29);

		try {

			File file = new File(this.getClass().getResource("/").getPath() + "/files/customer.xml");
			JAXBContext jaxbContext = JAXBContext.newInstance(Customer.class);
			//由 JavaBean 到 XML
			Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

			// output pretty printed
			jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

			jaxbMarshaller.marshal(customer, file);
			jaxbMarshaller.marshal(customer, System.out);

		} catch (JAXBException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void test3() throws Exception {
		JAXBContext context = JAXBContext.newInstance(UserList.class);
		//由 XML 到 Java
		Unmarshaller unmarshaller = context.createUnmarshaller();
		URL xmlFileUrl = ClassLoader.getSystemResource("files/users.xml");
		UserList userList = (UserList) unmarshaller.unmarshal(xmlFileUrl);
		for (User user : userList.getUsers()) {
			System.out.println(user.toString());
		}
	}

	/**
	 * 使用Compiler API
	 * @throws Exception
	 */
	@Test
	public void test4() throws Exception {
		JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
		//......
	}

	/**
	 * 使用Console API
	 * @throws Exception
	 */
	@Test
	public void test5() throws Exception {
		Console cons = System.console();
		if (cons != null) {
			// -------------------------
			PrintWriter printWriter = cons.writer();
			printWriter.write("input:");
			cons.flush();
			// -------------------------
			String str1 = cons.readLine();
			// -------------------------
			cons.format("%s", str1);
		}
	}

}
