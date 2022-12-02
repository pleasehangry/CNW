package Model.Controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.BO.UserBO;
import Model.Bean.User;

/**
 * Servlet implementation class AddUser
 */
@WebServlet("/AddUser")
public class AddUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddUser() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		if (request.getSession().getAttribute("User") == null) {
			String errorString = "Bạn cần đăng nhập trước";
			request.setAttribute("errorString", errorString);
			RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/login.jsp");
			dispatcher.forward(request, response);
		} else {

			String errorString = null;

			if (request.getAttribute("errorString") != null) {
				errorString = (String) request.getAttribute("errorString");
			}
			// LÆ°u thĂ´ng tin vĂ o request attribute trÆ°á»›c khi forward sang views.
			request.setAttribute("errorString", errorString);
			request.getSession().setAttribute("Check", "AddUser");
			User userr = (User) request.getSession().getAttribute("User");
			request.setAttribute("user", userr);
			RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/add_user.jsp");
			dispatcher.forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		UserBO userBO = new UserBO();
		try {
			if(userBO.insertUser(username, password)) {
				request.setAttribute("errorString", "Thêm Đọc Giả Thành Công");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		request.setAttribute("errorString", "Thêm Đọc Giả Thành Công");
		doGet(request, response);
	}

}
