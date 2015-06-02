package zhao.service;

import org.springframework.beans.factory.annotation.Autowired;
import zhao.dao.ClassDao;
import zhao.dao.ElementDao;
import zhao.domain.ClassAndElement;
import zhao.domain.ClassMessage;
import zhao.domain.Element;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;

/**
 * Created by Evan on 2015/5/24.
 */
@org.springframework.stereotype.Service
public class LoadClass {

    @Autowired
    private ClassDao classDao;

    @Autowired
    private ElementDao elementDao;

    public ClassAndElement amain(String arg){

        String class_path = arg;//"org.apache.log4j.jdbc.JDBCAppender";//

        String jar_path= "file://a";//= "file://"+args[1];//"file://C:\\Users\\Evan\\.m2\\repository\\log4j\\log4j\\1.2.17\\log4j-1.2.17.jar"
        ClassAndElement classAndElement = new ClassAndElement();

        try {

            // ClassLoader  = new URLClassLoader(new URL[]{new URL(jar_path)});
            ClassLoader cl = Thread.currentThread().getContextClassLoader();
            Class<?> c = cl.loadClass(class_path);

            classAndElement = analyze(c);

            // 将元素加紧数据库
            for (Element element: classAndElement.getElements()){
                elementDao.insert(element);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return classAndElement;
    }

    public ClassAndElement analyze(Class<?> clazz) throws ClassNotFoundException {
        ClassAndElement classAndElement = new ClassAndElement();

        ClassMessage classMessage = new ClassMessage();
        classMessage.setName(clazz.getCanonicalName());

        // 插进去
        classDao.insert(classMessage);
        classMessage = classDao.select(classMessage).get(0);
        classAndElement.setClassMessage(classMessage);

        Constructor<?>[] constructors = clazz.getConstructors();

        if (constructors.length != 0) {
            for (Constructor<?> constructor : constructors) {
                Element element = new Element();
                element.setType(Element.TYPE.constructor);
                element.setClassId(classMessage.getId());
                element.setDescription(constructor.toString());

                classAndElement.addElement(element);
            }
        } else {
            // do nothing
        }

        Field[] fields = clazz.getDeclaredFields();

        if (fields.length != 0) {
            for (Field field : fields) {
                Element element = new Element();
                element.setType(Element.TYPE.variable);
                element.setClassId(classMessage.getId());
                element.setDescription(field.toString());

                classAndElement.addElement(element);
            }

        } else {
            // do nothing
        }

        Method[] methods = clazz.getDeclaredMethods();

        if (methods.length != 0) {

            for (Method method : methods) {
                Element element = new Element();
                element.setType(Element.TYPE.function);
                element.setClassId(classMessage.getId());
                element.setDescription(method.toString());

                classAndElement.addElement(element);
            }
        } else {
            // System.out.println("\tempty");
            // do nothing
        }

        return classAndElement;
    }

}
