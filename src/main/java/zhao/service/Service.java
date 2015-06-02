package zhao.service;

import org.springframework.beans.factory.annotation.Autowired;
import zhao.dao.ClassDao;
import zhao.domain.ClassMessage;
import java.util.List;

/**
 * Created by Evan on 2015/5/31.
 */
@org.springframework.stereotype.Service
public class Service {

    @Autowired
    private ClassDao classDao;

    public List<ClassMessage> FindClassByClass(ClassMessage c){
        return classDao.select(c);
    }

}
