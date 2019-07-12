package org.mashibing.spring;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.input.SAXBuilder;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ClassPathXMLApplicationContext implements BeanFactory {

    private Map<String, Object> beans = new HashMap<String, Object>();

    public ClassPathXMLApplicationContext() throws Exception{
        SAXBuilder sb = new SAXBuilder();
        Document document = sb.build(this.getClass().getResourceAsStream("/test/beans.xml"));
        Element root = document.getRootElement();

        List<Element> list = root.getChildren("bean");

        for (Element element : list) {
            String beanName = element.getAttributeValue("id");
            String beanClassValue = element.getAttributeValue("class");
            System.out.println(beanName + ":" + beanClassValue);
            Object object = Class.forName(beanClassValue).newInstance();
            beans.put(beanName, object);
        }

        //自动注入关联bean
        for (Element element : list) {
            String beanName = element.getAttributeValue("id");
            Object beanClassObject = beans.get(beanName);

            List<Element> properties = element.getChildren("property");
            if (properties != null){
                for (Element property : properties) {
                    String attrName = property.getAttributeValue("name");
                    String attrValue = property.getAttributeValue("bean");
                    Object bean = beans.get(attrValue);
                    if (bean != null){
                        Method method = beanClassObject.getClass().getMethod(
                                "set" + attrName,
                                bean.getClass().getInterfaces()[0]
                                );
                        method.invoke(beans.get(beanName), bean);
                    }
                }
            }

        }
    }

    @Override
    public Object getBean(String name) {
        return beans.get(name);
    }

}
