package dapeng.client;

import com.github.pagehelper.PageInfo;
import dapeng.pojo.Contact;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by MI on 2020/5/24.
 */
@FeignClient(value="contact-provider8081")
@Repository
public interface ContactClient {
    @RequestMapping(value = "selectByName",method = RequestMethod.GET)
    public PageInfo<Contact> selectByName(@RequestParam(value = "cname",required =false)String cname, @RequestParam(value = "pageNum",required =false)Integer pageNum, @RequestParam(value = "pageSize",required =false)Integer pageSize);
    @RequestMapping(value ="selectById",method = RequestMethod.GET)
    public Contact selectById(@RequestParam("id") Integer id);
    @RequestMapping(value = "save",method = RequestMethod.POST)
    public String save(@RequestBody Contact contact);
    @RequestMapping(value = "updateById",method = RequestMethod.POST)
    public String updateById(@RequestBody Contact contact);

}
