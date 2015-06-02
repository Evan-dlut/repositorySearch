package zhao.mvc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import zhao.dao.ElementDao;
import zhao.dao.HistoryDao;
import zhao.domain.ClassAndElement;
import zhao.domain.ClassMessage;
import zhao.domain.Element;
import zhao.domain.History;
import zhao.service.LoadClass;
import zhao.service.Service;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by Evan on 2015/5/31.
 */
@Controller
public class HomeController {

    @Autowired
    private Service service;

    @Autowired
    private LoadClass loadClass;

    @Autowired
    private ElementDao elementDao;

    @Autowired
    private HistoryDao historyDao;

    @RequestMapping("/")
    public String home(Model model,
                       @RequestParam(value = "name", required = false)String className
    ){
        if (className !=null && !className.isEmpty()){
            // 根据name查找
            ClassMessage classMessage = new ClassMessage();
            classMessage.setName(className);
            List<ClassMessage> classMessages = service.FindClassByClass(classMessage);
            List<Element> elementList;
            List<Element> constructorList = new LinkedList<Element>();
            List<Element> function = new LinkedList<Element>();
            List<Element> variable = new LinkedList<Element>();
            model.addAttribute("className", className);
            if (classMessages == null || classMessages.isEmpty()) {
                // 进行Load操作
                ClassAndElement classAndElement = loadClass.amain(className);
                // 还是要分类
                elementList = classAndElement.getElements();
            }
            else {
                // 直接查出来
                Element element = new Element();
                element.setClassId(classMessages.get(0).getId());
                elementList = elementDao.select(element);
            }
            for (Element element : elementList) {
                if (element.getType().equals(Element.TYPE.constructor))
                    constructorList.add(element);
                else if (element.getType().equals(Element.TYPE.function))
                    function.add(element);
                else if (element.getType().equals(Element.TYPE.variable))
                    variable.add(element);
                else
                    System.out.println("cao le");
            }
            model.addAttribute("constructorList", constructorList);
            model.addAttribute("functions", function);
            model.addAttribute("variables", variable);
            // add history
            History history = new History();
            history.setName(className);
            historyDao.insert(history);
        }
        else{

        }
        // add history search
        List<History> histories = historyDao.selectFive();
        model.addAttribute("histories", histories);

        return "home";
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public String homePost(Model model,
                           @RequestParam(value = "name")String name){
        return home(model, name);
    }
}
