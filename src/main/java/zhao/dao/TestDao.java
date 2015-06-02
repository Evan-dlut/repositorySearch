package zhao.dao;

import org.springframework.stereotype.Repository;
import zhao.domain.TestDo;

import java.util.List;

/**
 * Created by Evan on 2015/5/31.
 */
@Repository
public interface TestDao {
    List<TestDo> select(TestDo testDo);
    void insert(TestDo testDo);
    void update(TestDo testDo);
}
