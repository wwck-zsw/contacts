package dapeng.service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import dapeng.mapper.ContactMapper;
import dapeng.pojo.Contact;
import dapeng.pojo.ContactExample;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by MI on 2020/5/24.
 */
@Service
public class ContactServiceImpl implements ContactService {
    @Resource
    private ContactMapper contactMapper;
    @Override
    public PageInfo<Contact> selectByName(String cname, Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        ContactExample example=new ContactExample();
        ContactExample.Criteria criteria = example.createCriteria();
       if(cname!=null&&cname!=""){
           criteria.andCnameLike("%"+cname+"%");
       }
        List<Contact> list=contactMapper.selectByExample(example);
        PageInfo<Contact> pageInfo=new PageInfo<>(list);
        return pageInfo;
    }

    @Override
    public Contact selectById(Integer id) {
        return contactMapper.selectByPrimaryKey(id);
    }

    @Override
    public Integer update(Contact contact) {
        return contactMapper.updateByPrimaryKey(contact);
    }

    @Override
    public Integer save(Contact contact) {
        return contactMapper.insert(contact);
    }
}
