package com.aaa.controller;

import com.aaa.entity.*;
import com.aaa.service.BranchService;
import com.aaa.service.BranchexpendService;
import com.aaa.service.TuserSTwo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/admin/network")
public class NetworkController {
    @Autowired
    private BranchService branchService;
    @Autowired
    private TuserSTwo tuserSTwo;
    @Autowired
    private BranchexpendService branchexpendService;

    @RequestMapping("toselect")
    public String toselect() {
        return "data/network/networkList";
    }

    @RequestMapping("select")
    @ResponseBody
    public LayuiResult<Map> select(BaseQuery baseQuery, Model model, HttpSession session, TuserTwo tuserTwo, Branch branch) {
        /**
         * 获取账号username 根据账号查询自己的网点名称和等级
         * 根据自己的网点名称放进所属网点查询下一级的所有网点
         * */

        LayuiResult<Map> result = new LayuiResult<Map>();
        String userName = session.getAttribute("userName").toString();//获取账号
        tuserTwo.setUsername(userName);
        List<Branch> tusers = tuserSTwo.tuserList(tuserTwo);
        //List<TuserTwo> tuserTwos = tuserSTwo.usernameList(tuserTwo);
        Integer brarank = Integer.valueOf(tusers.get(0).getBrarank()).intValue();//权限等级数字
        String braname = tusers.get(0).getBraname();
        System.out.println("----------------------------------------" + brarank);
        System.out.println("----------------------------------------" + braname);
        branch.setBrarank(brarank);
        branch.setBraname(braname);
        List<Map> branches = branchService.branchList(baseQuery, branch);
        System.out.println("看这里" + branches);
        int i = branchService.selectCount(branch);
        System.out.println(branches);
        result.setData(branches);
        result.setCount(i);
        return result;
    }


    @ResponseBody
    @RequestMapping("insertbranch")
    public String insertbranch(Branch branch, HttpServletRequest request, HttpSession session, TuserTwo tuserTwo,Branchexpend branchexpend) {

        String userName = session.getAttribute("userName").toString();//获取账号
        tuserTwo.setUsername(userName);
        List<Branch> tusers = tuserSTwo.tuserList(tuserTwo);
        Integer brarank = Integer.valueOf(tusers.get(0).getBrarank()).intValue();//权限等级数字
        String braname = tusers.get(0).getBraname();
        branch.setBracode(request.getParameter("bracode"));
        branch.setBraname(request.getParameter("braname"));
        branch.setBrasuoshu(braname);
        branch.setBraprovince(request.getParameter("provid"));
        branch.setBrarank(brarank + 1);
        branch.setBracity(request.getParameter("cityid"));
        branch.setBracounty(request.getParameter("areaid"));
        branch.setBraaddress(request.getParameter("braaddress"));
        branch.setBraprincipal(request.getParameter("braprincipal"));
        branch.setBraphone(request.getParameter("braphone"));
        branch.setBraremark(request.getParameter("braremark"));
        String nowTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
        branch.setBratime(nowTime);
        branchService.insertBranch(branch);
        branchexpend.setBraexname(request.getParameter("braname"));
        branchexpendService.insertBranchexpend(branchexpend);
        System.out.println(branch);
        return "redirect:/admin/network/toselect";
    }

    @RequestMapping("update")
    public String update(Model model, String bracode, Branch branch) {
        ModelAndView mav = new ModelAndView();
        branch.setBracode(bracode);
        List<Branch> branches = branchService.updateList(branch);
        model.addAttribute("branches",branches);
        return "data/network/update";
    }
    @ResponseBody
    @RequestMapping("updatedata")
    public String updatedata(Branch branch, HttpServletRequest request, HttpSession session){
        branch.setBracode(request.getParameter("bracode"));
        branch.setBraname(request.getParameter("braname"));
        branch.setBranameEnglish(request.getParameter("branameEnglish"));
        branch.setBraaddress(request.getParameter("braaddress"));
        branch.setBraprincipal(request.getParameter("braprincipal"));
        branch.setBraphone(request.getParameter("braphone"));
        branch.setBraremark(request.getParameter("braremark"));
        branchService.update(branch);
        return "redirect:/admin/network/toselect";
    }

    @ResponseBody
    @RequestMapping("del")
    public  String del(String bracode, Branch branch){
        branch.setBracode(bracode);
        branchService.del(branch);
        return "redirect:/admin/network/toselect";
    }
}
