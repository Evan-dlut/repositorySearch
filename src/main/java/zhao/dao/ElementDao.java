package zhao.dao;

import org.springframework.stereotype.Repository;
import zhao.domain.Element;

import java.util.List;

/**
 * Created by Evan on 2015/5/31.
 */
@Repository
public interface ElementDao {
    List<Element> select(Element testDo);
    void insert(Element testDo);
//    void update(Element testDo);
}
