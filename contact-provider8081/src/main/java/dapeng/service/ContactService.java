package dapeng.service;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import dapeng.pojo.Contact;
/**
 * Created by MI on 2020/5/24.
 */
public interface ContactService {
    PageInfo<Contact> selectByName(String cname, Integer pageNum, Integer pageSize);
    Contact selectById(Integer id);
    Integer update(Contact contact);
    Integer save(Contact contact);
}
