package com.aaa.controller;

import com.aaa.entity.BaseQuery;
import com.aaa.entity.LayuiResult;
import com.aaa.entity.WstaffdetailsVO;
import com.aaa.entity.WvehicleVO;
import com.aaa.service.WvehicleService;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("carEdit")
public class CarEditController {
    @Autowired
    private WvehicleService wvehicleService;

    @RequestMapping("carSelecturl")
    public String userSelecturl() {
        return "car_edit";
    }
    @RequestMapping("selCar")
    @ResponseBody
    public LayuiResult<Map> carEdit(BaseQuery baseQuery,WvehicleVO wvehicleVO,WstaffdetailsVO wstaffdetailsVO,HttpSession session){
        LayuiResult<Map> result = new LayuiResult<Map>();
        //获取登录账号
        String username=session.getAttribute("userName").toString();
        wstaffdetailsVO.setUsername(username);
        //获取员工姓名
        String truename=wvehicleService.selTruename(wstaffdetailsVO);
        wstaffdetailsVO.setTruename(truename);
        //获取员工所属网点名称
        String braname =wvehicleService.selBraname(wstaffdetailsVO);
        wstaffdetailsVO.setBraname(braname);
        wvehicleVO.setBraname(braname);

        List<Map> allCar=wvehicleService.findCar(baseQuery,wvehicleVO);
        int carCount=wvehicleService.selectCount(wvehicleVO);
        result.setData(allCar);
        result.setCount(carCount);
        return result;
    }
    //添加
    @RequestMapping("add")
    public String insertCar(WstaffdetailsVO wstaffdetailsVO, HttpSession session, Model model){
//获取登录账号
        String username=session.getAttribute("userName").toString();
        wstaffdetailsVO.setUsername(username);
        //获取员工姓名
        String truename=wvehicleService.selTruename(wstaffdetailsVO);
        wstaffdetailsVO.setTruename(truename);

        //获取员工所属网点名称
        List<WstaffdetailsVO> list=wvehicleService.selBranameTwo(wstaffdetailsVO);

        model.addAttribute("list",list);
        return "carInsert";
    }
    @RequestMapping("selType")
    @ResponseBody
    public Object seltype(){
      List<WvehicleVO> list=wvehicleService.selType();

        return list;

    }
    @RequestMapping("toAdd")
    @ResponseBody
    public Object toAdd(WvehicleVO wvehicleVO, HttpServletRequest request){
       wvehicleVO.setBraname(request.getParameter("braname"));
       //根据网点名称查询该网点id
        int braid= wvehicleService.selBraid(wvehicleVO);
        wvehicleVO.setBraid(braid);
       wvehicleVO.setVehdirver(request.getParameter("vehdirver"));
       wvehicleVO.setVehphone(request.getParameter("vehphone"));
       wvehicleVO.setVehids(request.getParameter("vehids"));
       wvehicleVO.setVehnum(request.getParameter("vehnum"));
       wvehicleVO.setVehmodal(request.getParameter("vehmodal"));

       wvehicleVO.setVehilo(Integer.valueOf(request.getParameter("vehilo")));
       wvehicleVO.setVehtime(request.getParameter("vehtime"));
       wvehicleVO.setVehnode(request.getParameter("vehnode"));
       //状态
       wvehicleVO.setState(request.getParameter("vehstate"));
       wvehicleVO.setVehtunnage(Integer.valueOf(request.getParameter("vehtunnage")));
       wvehicleVO.setTypename(request.getParameter("typename"));
       wvehicleVO.setTransid(Integer.valueOf(request.getParameter("transid")));
       int a= wvehicleService.insertCar(wvehicleVO);
        String data=String.valueOf(a);
        return data;

    }
    //删除
    @RequestMapping("delCar")
    public String delCar(WvehicleVO wvehicleVO,Integer vehid){
        wvehicleVO.setVehid(vehid);
        wvehicleService.delCar(wvehicleVO);
        return "redirect:/carEdit/carSelecturl";
    }
    //查询
    @RequestMapping("selCarTwo")
    public String selCar(WvehicleVO wvehicleVO,Model model){
       List<WvehicleVO> list= wvehicleService.selCar(wvehicleVO);
       model.addAttribute("list",list);
        return "carUpdate";
    }
    //修改车辆信息
    @RequestMapping("updateCar")
    @ResponseBody
    public Object updateCar(WvehicleVO wvehicleVO,HttpServletRequest request){
        wvehicleVO.setVehid(Integer.valueOf(request.getParameter("vehid")));
        wvehicleVO.setVehdirver(request.getParameter("vehdirver"));
        wvehicleVO.setVehphone(request.getParameter("vehphone"));
        wvehicleVO.setVehids(request.getParameter("vehids"));
        wvehicleVO.setVehnum(request.getParameter("vehnum"));
        wvehicleVO.setVehmodal(request.getParameter("vehmodal"));
        wvehicleVO.setVehtunnage(Integer.valueOf(request.getParameter("vehtunnage")));
        wvehicleVO.setVehilo(Integer.valueOf(request.getParameter("vehilo")));
        wvehicleVO.setVehnode(request.getParameter("vehnode"));
        System.out.println("+++++++++++++++++++++++++++"+request.getParameter("vehdirver"));
        int a=wvehicleService.updateCar(wvehicleVO);
        String data=String.valueOf(a);

        return data;

    }
}
