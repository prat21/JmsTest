package com.jms.test;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



@WebServlet("/JmsServlet")
public class JmsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

     public JmsServlet() {
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Thread producer=new Thread(new Producer());
		Consumer consumer = new Consumer();
		System.out.println("Producer thread started: ");
		producer.start();
		/*try {
			System.out.println("going to sleep");
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		System.out.println("consumer started");
		consumer.consume();
		//response.getWriter().append("Served at pratik: ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
