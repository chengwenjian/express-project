package com.aaa.controller;


import com.aaa.entity.*;
import com.aaa.service.TuserTwoService;
import com.aaa.service.WbranchService;
import com.aaa.service.impl.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("userEdit")
public class UserEditController {
    @Autowired
    private TuserTwoService tuserTwoService;
    @Autowired
    private WbranchService wbranchService;

    @RequestMapping("userSelecturl")
    public String userSelecturl() {
        return "user_edit";
    }

    @RequestMapping("userSelect")
    @ResponseBody
    public LayuiResult<Map> userEdit(BaseQuery baseQuery, WstaffdetailsVO wstaffdetailsVO,HttpSession session) {

        LayuiResult<Map> result = new LayuiResult<Map>();
        System.out.println(wstaffdetailsVO.getBraname());
        //session.getAttribute("currentUser")
        //获取登录账号
        String username=session.getAttribute("userName").toString();
        wstaffdetailsVO.setUsername(username);
        //获取员工姓名
        String truename=tuserTwoService.selTruename(wstaffdetailsVO);
        wstaffdetailsVO.setTruename(truename);
        //获取员工所属网点名称
        String braname =tuserTwoService.selBraname(wstaffdetailsVO);
        wstaffdetailsVO.setBraname(braname);


        Map<String,Object> map=new HashMap<String,Object>();
        map.put("braname",wstaffdetailsVO.getBraname());

        List<Map> userTwo = tuserTwoService.findUser(baseQuery, wstaffdetailsVO);
        System.out.println("==================++++++++++======="+userTwo);
        int i = tuserTwoService.selectCount(wstaffdetailsVO);
        result.setData(userTwo);
        result.setCount(i);
        return result;
    }

    @RequestMapping("branchSelect")
    @ResponseBody
    public LayuiResult<Wbranch> branchSel(HttpSession session, Wbranch wbranch) {
        LayuiResult<Wbranch> result = new LayuiResult<Wbranch>();
        List<Wbranch> branches = wbranchService.findBranch();
        result.setData(branches);
        return result;
    }

    @RequestMapping("tolist")
    public String aaa(WstaffdetailsVO wstaffdetailsVO,HttpSession session,Model model) {
        //获取登录账号
        String username=session.getAttribute("userName").toString();
        wstaffdetailsVO.setUsername(username);
        //获取员工姓名
        String truename=tuserTwoService.selTruename(wstaffdetailsVO);
        wstaffdetailsVO.setTruename(truename);
        //获取员工所属网点名称
        List<WstaffdetailsVO> list=tuserTwoService.selBranameTwo(wstaffdetailsVO);

        model.addAttribute("list",list);

        return "userInsert";
    }

    @RequestMapping("toInsert")
    @ResponseBody
    public Object insertUser(WstaffdetailsVO wstaffdetailsVO, HttpServletRequest request) {

        wstaffdetailsVO.setBraname(request.getParameter("braname"));
        wstaffdetailsVO.setStaaddress(request.getParameter("staaddress"));
        wstaffdetailsVO.setTruename(request.getParameter("truename"));
        wstaffdetailsVO.setStaidcard(request.getParameter("staidcard"));
        wstaffdetailsVO.setStaphone(request.getParameter("staphone"));
        //查询网点id
        int braid=tuserTwoService.branchId(wstaffdetailsVO);
        wstaffdetailsVO.setBraid(braid);
        //员工账号密码
        tuserTwoService.useresInsertTwo(wstaffdetailsVO);
        //用户id
        int id= tuserTwoService.userId(wstaffdetailsVO);
        wstaffdetailsVO.setId(id);
        //添加员工详情
        int a=tuserTwoService.useresInsert(wstaffdetailsVO);
        String data=String.valueOf(a);
        return data;
    }
    @RequestMapping("del")
    @ResponseBody
    public String del(WstaffdetailsVO wstaffdetailsVO,Integer id){
        wstaffdetailsVO.setId(id);
        tuserTwoService.delUser(wstaffdetailsVO);
        tuserTwoService.delUserTwo(wstaffdetailsVO);
        return "redirect:/userEdit/userSelecturl";
    }
    @RequestMapping("seluser")
    public String seluser(WstaffdetailsVO wstaffdetailsVO,Model model){
        List<WstaffdetailsVO> list=tuserTwoService.selUser(wstaffdetailsVO);
        model.addAttribute("list",list);
        return "userUpdate";
    }
    @RequestMapping("edit")
    @ResponseBody
    public Object edit(WstaffdetailsVO wstaffdetailsVO,HttpServletRequest request){
        wstaffdetailsVO.setId(Integer.valueOf(request.getParameter("id")));
        wstaffdetailsVO.setTruename(request.getParameter("truename"));
        wstaffdetailsVO.setUsername(request.getParameter("username"));
        wstaffdetailsVO.setStaphone(request.getParameter("staphone"));
        wstaffdetailsVO.setStaaddress(request.getParameter("staaddress"));
        wstaffdetailsVO.setPassword(request.getParameter("password"));
        wstaffdetailsVO.setStaidcard(request.getParameter("staidcard"));

        tuserTwoService.editUser(wstaffdetailsVO);
        int a=tuserTwoService.editUserTwo(wstaffdetailsVO);
        String data=String.valueOf(a);
        return data;
    }
}
