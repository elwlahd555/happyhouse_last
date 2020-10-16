package com.ssafy.happy.controller.user;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ssafy.happy.controller.Controller;
import com.ssafy.happy.model.service.member.MemberService;
import com.ssafy.happy.model.service.member.MemberServiceImpl;

public class USER_DELETEController implements Controller{
   private MemberService memberService;
   public USER_DELETEController() {
      memberService = new MemberServiceImpl();
   }
   @Override
   public void service(HttpServletRequest request, HttpServletResponse response) throws Exception {
      // TODO Auto-generated method stub
         String email = request.getParameter("email");
         memberService.delete(email);

         response.sendRedirect("main.do?action=USER_LIST");
   
   }

}