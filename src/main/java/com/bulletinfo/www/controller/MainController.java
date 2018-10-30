package com.bulletinfo.www.controller;

import com.bulletinfo.www.domain.*;
import com.bulletinfo.www.servers.*;
import com.bulletinfo.www.utils.FileUtil;
import com.bulletinfo.www.utils.ResultUtils;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@RestController
public class MainController {
    @Autowired
    private FServers fServers;

    @Autowired
    private UserServers userServers;

    @Autowired
    private UserMServers userMServers;

    @Autowired
    private GroupService groupService;

    @Autowired
    private GMService gmService;

    @PostMapping(value = "/")
    public String MainTest(){
        return "hello";
    }

    /**
     * 注册账号，自动生成uid
     * @param user
     * @return
     * @throws SQLException
     */
    @PostMapping("/reginster")
    public Result Register(@Valid User user){
        System.out.println("user is:"+user);
        userServers.AddUser(user);
        return ResultUtils.success(null);
    }

    /**
     * 遍历uid的好友
     * @param uid
     * @return
     */
    @PostMapping("/friends/{uid}")
    public Result FindByFriend(@PathVariable Integer uid){
        List<Friend> list = fServers.UserList(uid);
        return ResultUtils.success(list);
    }

    /**
     * 通过uid查询信息
     * @param uid
     * @return
     */
    @PostMapping("/selectUid/{uid}")
    public Result SelectPhone(@PathVariable Integer uid){
        User user = userServers.SelectUInfo(uid);
        if (user == null){
            return ResultUtils.filed(null);
        }else {
            return ResultUtils.success(user);
        }
    }

    /**
     * 通过电话查询信息
     * @param phone
     * @return
     */
    @PostMapping("/selectPhone/{phone}")
    public Result SelectPhone(@PathVariable String phone){
        User user = userServers.SelectByPhone(phone);
        if (user == null){
            return ResultUtils.filed(null);
        }else {
            return ResultUtils.success(user);
        }
    }

    /**
     * 登录判断
     * @param uid
     * @param upwd
     * @return
     */
    @PostMapping("/login/{uid}/{upwd}")
    public Result Login(@PathVariable Integer uid, @PathVariable String upwd){
        boolean result= userServers.Login(uid, upwd);
        if (result == false){
            return ResultUtils.filed(result);
        }else {
            return ResultUtils.success(result);
        }
    }

    /**
     * 账号验证
     * @param phone
     * @return
     */
    @PostMapping("/login/{phone}")
    public Result CheckAccount(@PathVariable String phone){
        boolean result= userServers.CheckAccount(phone);
        if (result == false){
            return ResultUtils.filed(result);
        }else {
            return ResultUtils.success(result);
        }
    }

    /**
     * 修改密码
     * @param password
     * @param phone
     * @return
     */
    @PostMapping("/updatePw/{password}/{phone}")
    public Result UpdatePw(@PathVariable String password,@PathVariable String phone){
        userServers.UpdatePw(password,phone);
        return ResultUtils.success(null);
    }

    @PostMapping("/updataIcourl")
    public Result UpdataIcourl(@RequestParam("img")MultipartFile file,HttpServletRequest req,@RequestParam("phone")String phone){
        String filename = file.getOriginalFilename();
        filename =FileUtil.generateGUID()+"."+FilenameUtils.getExtension(filename);
        String filepath = req.getServletContext().getRealPath("resources/"+phone+"/");
        String icourl = "resources/"+phone+"/"+filename;
        try {
            FileUtil.uploadFile(file.getBytes(), filepath, filename);
            userServers.UpdateIcourl(icourl,phone);
        } catch (Exception e) {

            e.printStackTrace();
        }
        return ResultUtils.success(null);
    }

    /**
     * 查询好友间的聊天记录
     * @param mid
     * @param uid
     * @return
     */
    @PostMapping("/receive/{mid}/{uid}")
    public Result ReciveMsg(@PathVariable Integer mid, @PathVariable Integer uid){
        List<UserMessage> list = userMServers.ReceiveMsg(mid, uid);
        return ResultUtils.success(list);
    }

    /**
     * 创建群，自动生成gid
     * @param groups
     * @return
     */
    @PostMapping("/createGroup")
    public Result CreateGroup(@Valid Groups groups){
        groupService.CreateGroup(groups);
        return ResultUtils.success(null);
    }

    /**
     * 查询群成员信息
     * @param gid
     * @return
     */
    @PostMapping("/selectGPersons/{gid}")
    public Result SelectGroupsPerson(@PathVariable Integer gid){
        List list = groupService.SelectGPersons(gid);
        List pLists = new ArrayList();
        for(Object li : list){
            pLists.add(userServers.SelectUInfo(Integer.valueOf(String.valueOf(li))));
        }
        return ResultUtils.success(pLists);
    }

    /**
     * 更新所有的群消息
     * @param uid
     * @return
     */
    @PostMapping("/reciveGmsg/{uid}")
    public Result ReceiveGmsg(@PathVariable Integer uid){
        List lists = userServers.SelectGidLists(uid);
        List glists = new ArrayList();
        for(Object li : lists){
            glists.add(gmService.SelectGidMsg(Integer.valueOf(String.valueOf(li))));
        }
        return ResultUtils.success(glists);
    }

    /**
     * 更新所有的好友消息
     * @param uid
     * @return
     */
    @PostMapping("/receiveFmsg/{uid}")
    public Result ReceiveFMsg(@PathVariable Integer uid){
        List<Friend> lists = fServers.UserList(uid);
        List<Integer> flist = new ArrayList<>();
        List mlists = new ArrayList<>();
        for(Friend li : lists){
            flist.add(li.getFid());
        }
        for(Integer li : flist){
            mlists.add(userMServers.ReceiveMsg(uid, li));
        }
        return ResultUtils.success(mlists);
    }

    /**
     * 删除好友
     * @param uid
     * @param fid
     * @return
     */
    @PostMapping("/delFriend/{uid}/{fid}")
    public Result DelFriend(@PathVariable Integer uid,@PathVariable Integer fid){
        Result result = new Result();
        fServers.DeleteFriend(uid,fid);
        fServers.DeleteFriend(fid,uid);
        result.setCode(200);
        result.setMsg("成功");
        return result;
    }

    /**
     * 退群
     * @param gId
     * @param uid
     * @return
     */
    @PostMapping("exitGroup/{gId}/{uid}")
    public Result ExitGroup(@PathVariable Integer gId,@PathVariable Integer uid){
        List gPersons = new ArrayList(groupService.SelectGPersons(gId));
        String uId = String.valueOf(uid);
        for (int i=0;i<gPersons.size();i++){
            if(gPersons.get(i).equals(uId)){
                gPersons.remove(i);
            }
        }
        String gPersonnel = StringUtils.join(gPersons,",");
        groupService.UpdateGpersonnel(gPersonnel,gId);
        return ResultUtils.success(null);
    }

    /**
     * 解散群
     * @param gId
     * @return
     */
    @PostMapping("delGroup/{gId}")
    public Result DelGroup(@PathVariable Integer gId){
        groupService.DelGroup(gId);
        return ResultUtils.success(null);
    }

}
