package com.nrk.mobile;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.nrk.dao.MobileDAO;
import com.nrk.design.BaseComponent;
import com.nrk.model.Mobile;

public class App {
	public static void main(String[]args)
	{
		//Mobile m1 = new Mobile();
		//m1.setName("jfd");
		//m1.setModel("2018");
		//m1.setPrice(10000);
		
		//ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
		
		//MobileDAO mobileDAo = context.getBean(MobileDAO.class);
		
		//mobileDAo.save(m1);
		//*/
		//Mobile m = mobileDAo.getImage("rr");
		
	//System.out.println(m.getimage());
		
		
		
		BaseComponent bs=new BaseComponent();
		bs.LoadOnStartUp();
	}

	
}
