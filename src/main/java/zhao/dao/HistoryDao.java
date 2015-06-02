package zhao.dao;

import zhao.domain.History;

import java.util.List;

/**
 * Created by Evan on 2015/6/1.
 */
public interface HistoryDao {

    List<History> selectFive();
    void insert(History history);

}
