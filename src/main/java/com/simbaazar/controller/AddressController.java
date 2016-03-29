package com.simbaazar.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.simbaazar.bean.AddressBean;
import com.simbaazar.dao.AddressDao;

/**
 * THis class is used to manage Back End services
 */
public class AddressController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("Entering OrderController");
		
		if("save".equals(request.getParameter("action")))
		{
			System.out.println("save Action selected");
			AddressBean addressBean = new AddressBean();
			addressBean.setAddressLineOne(request.getParameter("addressLineOne"));
			addressBean.setAddressLineTwo(request.getParameter("addressLineTwo"));
			addressBean.setPincode(Long.valueOf(request.getParameter("pincode")));
		
			try {
				new AddressDao().save(addressBean);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		
		}
		else
			if("view".equals(request.getParameter("action"))){
				
			}
		
		
		System.out.println("Exiting OrderController");
	}

}
