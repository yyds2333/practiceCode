package org.nynd.servlet.userServlet;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.mysql.cj.util.StringUtils;
import org.junit.Test;
import org.nynd.pojo.Role;
import org.nynd.pojo.User;
import org.nynd.service.roleService.RoleService;
import org.nynd.service.roleService.roleServiceImpl.RoleServiceImpl;
import org.nynd.service.userService.UserService;
import org.nynd.service.userService.userServiceImpl.UserServiceImpl;
import org.nynd.util.Constants;
import org.nynd.util.PageSupport;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

//复用Servlet
public class UserServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //从前端取得表单是哪一个
        String method=req.getParameter("method");
        System.out.println(method.equals(""));

        if (method.equals("savepwd")&&!method.isEmpty()){
            this.updatePassword(req,resp);
            //修改用户
        } else if (method.equals("pwdmodify")&&!method.isEmpty()) {
            this.searchOldpassword(req,resp);
            //查询
        }else if(method.equals("query")&&!method.isEmpty()){
            this.queryUserList(req,resp);
            //提交新建用户表单
        }else if(method.equals("add")&&!method.isEmpty()){
            //将方法调用到传参页面
            this.add(req,resp);
        }else if(method.equals("ucexist")&&!method.isEmpty()) {
            //查询userCode的方法
            this.userCodeExist(req,resp);
        }else if(method != null && method.equals("getrolelist")){
            this.getRoleList(req, resp);
        }else if(method != null && method.equals("deluser")){
            this.delUser(req, resp);
        }else if(method != null && method.equals("view")){
            this.getUserById(req, resp,"userview.jsp");
        }else if(method != null && method.equals("modify")){
            this.getUserById(req, resp,"usermodify.jsp");
        }else if(method != null && method.equals("modifyexe")){
            this.modify(req, resp);
        }else{
            //跳转回原页面
            req.getRequestDispatcher("/jsp/pwdmodify.jsp").forward(req,resp);
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
    //修改密码的方法
    public void updatePassword(HttpServletRequest req, HttpServletResponse resp){
        //从Session中取得ID
        Object obj=req.getSession().getAttribute(Constants.USER_SESSION);
        String newpassword=req.getParameter("newpassword");
        boolean flag=false;
        if (obj!=null&&!newpassword.isEmpty()){
            UserService us=new UserServiceImpl();
            flag=us.passwordUpdate(((User)obj).getId(),newpassword);
            if (flag){
                req.setAttribute(Constants.MESSAGE,"修改密码成功,请退出，使用新密码登录");
                //修改成功，移除当前Session
                req.getSession().removeAttribute(Constants.USER_SESSION);
            }else{

                req.setAttribute(Constants.MESSAGE,"密码修改失败");
            }
        }else{

            req.setAttribute(Constants.MESSAGE,"新密码有问题");
        }
        //
        try {
            req.getRequestDispatcher("/jsp/pwdmodify.jsp").forward(req,resp);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //查询旧密码的方法
    public void searchOldpassword(HttpServletRequest req,HttpServletResponse resp){
        //拿到当前用户Session，再通过req获取前端传来的旧密码
        Object obj=req.getSession().getAttribute(Constants.USER_SESSION);
        String oldpassword=req.getParameter("oldpassword");
        //通过Session拿到当前用户的原密码
        User user=(User)obj;
        //使用Map来封装要发回前端的结果集resultSet
        Map<String,String> resultMap=new HashMap<>();
        if(obj==null){
            //Session失效
            resultMap.put("result","sessionerror");
        }else if (oldpassword.isEmpty()){
            //如果取得的页面原密码为空
            System.out.println(oldpassword+":"+2);
            resultMap.put("result","error");
        }else{
            //取得页面输入的原密码
            System.out.println(oldpassword+":"+3);
            if (user.getUserPassword().equals(oldpassword)){
                resultMap.put("result","true");
            }else{
                resultMap.put("result","false");
            }
        }
        //将这个结果集发送给前端
        try{
            resp.setContentType("application/json");
            PrintWriter writer=resp.getWriter();
            //通过阿里巴巴的FastJson将结果集转换为Json类型并发送回前端
            /*
            * HashMap格式:{"result","error","result","trur"}
            * Json格式:{key:value}
            */
            writer.print(JSONArray.toJSONString(resultMap));
            //刷新writer，关闭writer
            writer.flush();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //用户管理查询页面
    public void queryUserList(HttpServletRequest request,HttpServletResponse response){
        //查询用户列表
        //从前端获取数据
        String queryUserName=request.getParameter("queryname");
        String temp=request.getParameter("queryUserRole");
        System.out.println("temp-->"+temp);
        String pageIndex=request.getParameter("pageIndex");
        int queryUserRole=0;
        //获取用户列表
        UserService userService=new UserServiceImpl();
        List<User> userList=null;
        //设置页面容量
        PageSupport pageSupport=new PageSupport();
        pageSupport.setPageSize(5);
        int pagaSize= pageSupport.getPageSize();
        int currentPageNo=1;

        //使程序更加健壮
        if(queryUserName==null){
            queryUserName="";
        }
        if(temp!=null&&!temp.equals("")){
            queryUserRole=Integer.parseInt(temp);//给查询页面赋值
        }
        if (pageIndex!=null){
            currentPageNo=Integer.parseInt(pageIndex);
        }
        //获取用户总数
        int totalCount=userService.searchUserCount(queryUserName,queryUserRole);
        pageSupport.setCurrentPageNo(currentPageNo);
        pageSupport.setTotalPage(totalCount);
        //总页数
        int totalPageCount=pageSupport.getTotalPageCount();
        //控制首页和尾页
        if (currentPageNo<1){
            currentPageNo=1;
        }else if (currentPageNo>totalPageCount){
            currentPageNo=totalPageCount;
        }
        //获取用户列表展示
        request.getParameter("roleList");
        userList=userService.pageSearch(queryUserName,queryUserRole,currentPageNo,pagaSize);
        for (User user:userList){
            System.out.println("Servlet"+user);
        }
        request.setAttribute("userList",userList);


        RoleService roleService=new RoleServiceImpl();
        List<Role> roleList=roleService.getRoleList();
        request.setAttribute("roleList",roleList);
        request.setAttribute("totalPageCount",totalPageCount);
        request.setAttribute("totalCount",totalCount);
        request.setAttribute("currentPageNo",currentPageNo);
        request.setAttribute("queryUserName",queryUserName);
        request.setAttribute("queryUserRole",queryUserRole);

        System.out.println(totalCount+":"+totalPageCount+"query success"+currentPageNo+":"+queryUserName);
        //返回前端
        try{
            request.getRequestDispatcher("userlist.jsp").forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //用户添加的方法
    private void add(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        System.out.println("add()================");
        String userCode = request.getParameter("userCode");
        String userName = request.getParameter("userName");
        String userPassword = request.getParameter("userPassword");
        String gender = request.getParameter("gender");
        String birthday = request.getParameter("birthday");
        String phone = request.getParameter("phone");
        String address = request.getParameter("address");
        String userRole = request.getParameter("userRole");

        User user = new User();
        user.setUserCode(userCode);
        user.setUserName(userName);
        user.setUserPassword(userPassword);
        user.setAddress(address);
        try {
            user.setBirthday(new SimpleDateFormat("yyyy-MM-dd").parse(birthday));
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        user.setGender(Integer.valueOf(gender));
        user.setPhone(phone);
        user.setUserRole(Integer.valueOf(userRole));
        user.setCreationDate(new Date());
        user.setCreatedBy(((User)request.getSession().getAttribute(Constants.USER_SESSION)).getId());

        UserService userService = new UserServiceImpl();
        if(userService.add(user)){
            response.sendRedirect(request.getContextPath()+"/jsp/user.do?method=query");
        }else{
            request.getRequestDispatcher("useradd.jsp").forward(request, response);
        }

    }

    //用户userCode查询的方法
    private void userCodeExist(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //判断用户账号是否可用
        String userCode = request.getParameter("userCode");

        HashMap<String, String> resultMap = new HashMap<String, String>();
        if(StringUtils.isNullOrEmpty(userCode)){
            //userCode == null || userCode.equals("")
            resultMap.put("userCode", "exist");
        }else{
            UserService userService = new UserServiceImpl();
            User user = userService.selectUserCodeExist(userCode);
            if(null != user){
                resultMap.put("userCode","exist");
            }else{
                resultMap.put("userCode", "notexist");
            }
        }

        //把resultMap转为json字符串以json的形式输出
        //配置上下文的输出类型
        response.setContentType("application/json");
        //从response对象中获取往外输出的writer对象
        PrintWriter outPrintWriter = response.getWriter();
        //把resultMap转为json字符串 输出
        outPrintWriter.write(JSONArray.toJSONString(resultMap));
        outPrintWriter.flush();//刷新
        outPrintWriter.close();//关闭流
    }
    //用户角色列表
    private void getRoleList(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Role> roleList = null;
        RoleService roleService = new RoleServiceImpl();
        roleList = roleService.getRoleList();
        //把roleList转换成json对象输出
        response.setContentType("application/json");
        PrintWriter outPrintWriter = response.getWriter();
        outPrintWriter.write(JSONArray.toJSONString(roleList));
        outPrintWriter.flush();
        outPrintWriter.close();
    }
    //修改
    private void modify(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String id = request.getParameter("uid");
        String userName = request.getParameter("userName");
        String gender = request.getParameter("gender");
        String birthday = request.getParameter("birthday");
        String phone = request.getParameter("phone");
        String address = request.getParameter("address");
        String userRole = request.getParameter("userRole");

        User user = new User();
        user.setId(Integer.valueOf(id));
        user.setUserName(userName);
        user.setGender(Integer.valueOf(gender));
        try {
            user.setBirthday(new SimpleDateFormat("yyyy-MM-dd").parse(birthday));
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        user.setPhone(phone);
        user.setAddress(address);
        user.setUserRole(Integer.valueOf(userRole));
        user.setModifyBy(((User)request.getSession().getAttribute(Constants.USER_SESSION)).getId());
        user.setModifyDate(new Date());

        UserService userService = new UserServiceImpl();
        if(userService.modify(user)){
            response.sendRedirect(request.getContextPath()+"/jsp/user.do?method=query");
        }else{
            request.getRequestDispatcher("usermodify.jsp").forward(request, response);
        }

    }
    //获取用户
    private void getUserById(HttpServletRequest request, HttpServletResponse response,String url)
            throws ServletException, IOException {
        String id = request.getParameter("uid");
        if(!StringUtils.isNullOrEmpty(id)){
            //调用后台方法得到user对象
            UserService userService = new UserServiceImpl();
            User user = userService.getUserById(id);
            request.setAttribute("user", user);
            request.getRequestDispatcher(url).forward(request, response);
        }

    }
    //删除用户
    private void delUser(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String id = request.getParameter("uid");
        Integer delId = 0;
        try{
            delId = Integer.parseInt(id);
        }catch (Exception e) {
            // TODO: handle exception
            delId = 0;
        }
        HashMap<String, String> resultMap = new HashMap<String, String>();
        if(delId <= 0){
            resultMap.put("delResult", "notexist");
        }else{
            UserService userService = new UserServiceImpl();
            if(userService.deleteUserById(delId)){
                resultMap.put("delResult", "true");
            }else{
                resultMap.put("delResult", "false");
            }
        }

        //把resultMap转换成json对象输出
        response.setContentType("application/json");
        PrintWriter outPrintWriter = response.getWriter();
        outPrintWriter.write(JSONArray.toJSONString(resultMap));
        outPrintWriter.flush();
        outPrintWriter.close();
    }
}
