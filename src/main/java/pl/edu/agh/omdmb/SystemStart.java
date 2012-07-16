package pl.edu.agh.omdmb;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;

public class SystemStart {

    public static void main(String[] args) {
        ApplicationContext ap = new ClassPathXmlApplicationContext("resources/beans.xml");

        EmpManager empManager = (EmpManager)ap.getBean("empManager");
        System.out.println(empManager.getDbConfiguration().getAddress());
    }

}
