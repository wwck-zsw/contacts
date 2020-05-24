package dapeng.controller;

import com.github.pagehelper.PageInfo;
import dapeng.client.ContactClient;
import dapeng.pojo.Contact;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;

/**
 * Created by MI on 2020/5/24.
 */
@Controller
public class ContactController {
    @Resource
    private ContactClient contactClient;
    @ResponseBody
    @RequestMapping(value = "selectByName",method = RequestMethod.GET)
    public PageInfo<Contact> selectByName(String cname,Integer pageNum,Integer pageSize){
        if(pageNum==null){
            pageNum=1;
        }
        if(pageSize==null){
            pageSize=6;
        }
        return contactClient.selectByName(cname,pageNum,pageSize);
    }
    @ResponseBody
    @RequestMapping(value ="selectById",method = RequestMethod.GET)
    public Contact selectById(Integer id){
        return contactClient.selectById(id);
    }
    @ResponseBody
    @RequestMapping(value = "save",method = RequestMethod.POST)
    public String save(Contact contact){
        return contactClient.save(contact);
    }
    @ResponseBody
    @RequestMapping(value = "updateById",method = RequestMethod.POST)
    public String updateById(Contact contact){
        return contactClient.updateById(contact);
    }
    @RequestMapping(value = "toList",method = RequestMethod.GET)
    public String toList(){
        return "contact_list";
    }
}
