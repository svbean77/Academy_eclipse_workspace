package com.shinhan.controller2;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/cart/addCart.do")
public class CartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 주소창을 이용해 들어간 경우
		RequestDispatcher rd;
		rd = request.getRequestDispatcher("cart.jsp");
		rd.forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 장바구니에 등록한 경우
//		request.setCharacterEncoding("utf-8"); // post 방식은 한글을 '읽기 전' 인코딩을 해야 함! // filter에서 처리 함
		String product = request.getParameter("product");
		int count = Integer.parseInt(request.getParameter("count"));
		HashMap<String, Integer> cart = null;
		
		HttpSession session = request.getSession();
		Object obj = session.getAttribute("cart");
		if(obj == null) {
			cart = new HashMap<>();

			cart.put(product, count);
			session.setAttribute("cart", cart);
		} else {
			cart = (HashMap<String, Integer>) obj;
			
//			선생님 풀이 (존재하는 키인지 확인)
			if(cart.containsKey(product)) {
				int originalCount = cart.get(product);
				cart.put(product, originalCount + count);
			}else {
				cart.put(product, count);
			}
			
//			count += cart.getOrDefault(product, 0);
//			cart.put(product, count);
			// 이미 session에 장바구니가 있기 때문에 setAttribute를 하지 않아도 됨! session을 얻고 얻은 session을 바꾼거니까!
		}
		
		response.sendRedirect("addCart.do");
	}



}
