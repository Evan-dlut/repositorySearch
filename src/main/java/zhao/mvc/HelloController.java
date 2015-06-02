package zhao.mvc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import zhao.dao.TestDao;
import zhao.domain.TestDo;

/**
 * Created by Evan on 2015/5/31.
 */
@Controller("test")
public class HelloController {

    @Autowired
    private TestDao testDao;

    @RequestMapping
    public String a(Model model){
        TestDo testDo = new TestDo();
        testDo.setId(1L);
        testDo.setTest("test");
        testDao.insert(testDo);
        TestDo testDo1 = testDao.select(testDo).get(0);

        return "hello";
    }
}
