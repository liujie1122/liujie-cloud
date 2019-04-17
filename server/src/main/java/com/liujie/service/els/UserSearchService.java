package com.liujie.service.els;

import com.liujie.pojo.user.UserSearch;
import com.liujie.repository.UserSearchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class UserSearchService {
    @Autowired
    private ElasticsearchTemplate template;
    @Autowired
    private UserSearchRepository userRepository;


    /**
     * @param list
     * @return
     */
    public Iterable<UserSearch> saveAll(List<UserSearch> list){
        //添加数据
        Iterable<UserSearch> all = userRepository.saveAll(list);
        return all;
    }

    /**
     * @param userSearch
     * @return
     */
    public UserSearch save(UserSearch userSearch){
        //添加数据
        return userRepository.save(userSearch);
    }


    public UserSearch findById(Integer id) {
        Optional<UserSearch> optional = userRepository.findById(id);
        if (optional!=null && optional.isPresent()){
            UserSearch userSearch = optional.get();
            return userSearch;
        }else {
            return null;
        }
    }

    public void deleteUser(Integer id) {
        userRepository.deleteById(id);
    }
}
