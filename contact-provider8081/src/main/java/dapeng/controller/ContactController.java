package dapeng.controller;
import com.github.pagehelper.PageInfo;
import dapeng.pojo.Contact;
import dapeng.service.ContactService;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;

/**
 * Created by MI on 2020/5/24.
 */
@RestController
public class ContactController {
    @Resource
    private ContactService contactService;
    @RequestMapping(value = "selectByName",method = RequestMethod.GET,produces = {"application/json;charset=utf-8"})
    public PageInfo<Contact> selectByName(@RequestParam(value = "cname",required =false)String cname,@RequestParam(value = "pageNum",required =false)Integer pageNum,@RequestParam(value = "pageSize",required =false)Integer pageSize){
        if(pageNum==null){
            pageNum=1;
        }
        if(pageSize==null){
            pageSize=5;
        }
        return contactService.selectByName(cname,pageNum,pageSize);
    }
    @RequestMapping(value ="selectById",method = RequestMethod.GET,produces = {"application/json;charset=utf-8"})
    public Contact selectById(@RequestParam("id") Integer id){
        return contactService.selectById(id);
    }
    @RequestMapping(value = "save",method = RequestMethod.POST)
    public String save(@RequestBody Contact contact){
        return contactService.save(contact)>0?"success":"error";
    }
    @RequestMapping(value = "updateById",method = RequestMethod.POST)
    public String updateById(@RequestBody Contact contact){
        return contactService.update(contact)>0?"success":"error";
    }
}
