package cn.solomonqbq.business.mybatis;

import cn.solomonqbq.bean.Instance;
import cn.solomonqbq.bean.InstanceParam;
import cn.solomonqbq.mybatis.mapper.InstanceMapper;
import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class InstanceBussiness {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table instance
     *
     * @mbggenerated
     */
    private static Logger logger = LoggerFactory.getLogger(InstanceBussiness.class);

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table instance
     *
     * @mbggenerated
     */
    @Autowired 
    private InstanceMapper instanceMapper;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table instance
     *
     * @mbggenerated
     */
    @Transactional(propagation=Propagation.REQUIRED,isolation =Isolation.REPEATABLE_READ, rollbackFor = Exception.class)
    public int insertSelective(Instance obj) throws Exception {
        if(obj  == null ){
            return 0;
        }
        List<Instance> list = new ArrayList<Instance>();
        list.add(obj);
        return this.insertSelective(list);
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table instance
     *
     * @mbggenerated
     */
    @Transactional(propagation=Propagation.REQUIRED,isolation =Isolation.REPEATABLE_READ, rollbackFor = Exception.class)
    public int insertSelective(List<Instance> list) throws Exception {
        int insertCount = 0;
        if (list == null || list.size() == 0) {
            return insertCount;
        }
        for (Instance  obj : list) {
            if (obj == null) {
                continue;
            }
            try {
                insertCount += this.instanceMapper.insertSelective(obj);
            } catch (Exception e) {
                throw e;
            }
        }
        return insertCount;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table instance
     *
     * @mbggenerated
     */
    @Transactional(propagation=Propagation.REQUIRED,isolation =Isolation.REPEATABLE_READ, rollbackFor = Exception.class)
    public int update(Instance obj) throws Exception {
        if(obj  == null ){
            return 0;
        }
        List<Instance> list = new ArrayList<Instance>();
        list.add(obj);
        return this.update(list);
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table instance
     *
     * @mbggenerated
     */
    @Transactional(propagation=Propagation.REQUIRED,isolation =Isolation.REPEATABLE_READ, rollbackFor = Exception.class)
    public int update(List<Instance> list) throws Exception {
        int updateCount = 0;
        if (list == null || list.size() == 0) {
            return updateCount;
        }
        for (Instance  obj : list) {
            if (obj == null) {
                continue;
            }
            try {
                updateCount += this.instanceMapper.updateByPrimaryKeySelective(obj);
            } catch (Exception e) {
                throw e;
            }
        }
        return updateCount;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table instance
     *
     * @mbggenerated
     */
    public Instance getInstanceByKey(String key) throws Exception {
        return this.instanceMapper.selectByPrimaryKey(key);
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table instance
     *
     * @mbggenerated
     */
    public List<Instance> selectInstanceList(InstanceParam param) throws Exception {
        return this.instanceMapper.selectByExample(param);
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table instance
     *
     * @mbggenerated
     */
    public int countInstanceList(InstanceParam param) throws Exception {
        return this.instanceMapper.countByExample(param);
    }
}