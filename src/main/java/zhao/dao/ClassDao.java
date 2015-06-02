package zhao.dao;

import org.springframework.stereotype.Repository;
import zhao.domain.ClassMessage;

import java.util.List;

/**
 * Created by Evan on 2015/5/31.
 */
@Repository
public interface ClassDao {
    List<ClassMessage> select(ClassMessage testDo);
    void insert(ClassMessage testDo);
    void update(ClassMessage testDo);
}
