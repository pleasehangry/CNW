package Model.Controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.BO.CategoryBO;
import Model.Bean.Category;
import Model.Bean.User;

/**
 * Servlet implementation class EditCategory
 */
@WebServlet("/EditCategory")
public class EditCategory extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private CategoryBO categoryBO = new CategoryBO();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public EditCategory() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		if (request.getSession().getAttribute("User") == null) {
			String errorString = "Báº¡n cáº§n Ä‘Äƒng nháº­p trÆ°á»›c";
			request.setAttribute("errorString", errorString);
			RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/login.jsp");
			dispatcher.forward(request, response);
		} else {
			String id = (String) request.getParameter("id");

			Category category = null;

			String errorString = null;

			try {
				category = categoryBO.findCategory(id);
			} catch (SQLException e) {
				e.printStackTrace();
				errorString = e.getMessage();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			// KhĂ´ng cĂ³ lá»—i.
			// Sáº£n pháº©m khĂ´ng tá»“n táº¡i Ä‘á»ƒ edit.
			// Redirect sang trang danh sĂ¡ch sáº£n pháº©m.
			if (errorString != null && category == null) {
				response.sendRedirect(request.getServletPath() + "/ManageCategory");
				return;
			}

			// LÆ°u thĂ´ng tin vĂ o request attribute trÆ°á»›c khi forward sang views.
			request.setAttribute("errorString", errorString);
			request.setAttribute("category", category);
			User userr = (User) request.getSession().getAttribute("User");
			request.setAttribute("user", userr);

			RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/edit_category.jsp");
			dispatcher.forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		int id = Integer.parseInt(request.getParameter("id"));
		String name = (String) request.getParameter("name_category");
		Category category = new Category(id, name);
		String errorString = null;
		int result = 0;
		try {
			result = categoryBO.updateCategory(category);
		} catch (SQLException e) {
			e.printStackTrace();
			errorString = e.getMessage();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (result == 0 && errorString == null) {
			errorString = "Chá»‰nh sá»­a tháº¥t báº¡i";
		}
		if (result == 1)
			errorString = "Chá»‰nh sá»­a thĂ nh cĂ´ng";
		// LÆ°u thĂ´ng tin vĂ o request attribute trÆ°á»›c khi forward sang views.
		request.setAttribute("errorString", errorString);
		request.setAttribute("category", category);
		// Náº¿u cĂ³ lá»—i forward sang trang edit.
		if (errorString != null) {
			RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/edit_category.jsp");
			dispatcher.forward(request, response);
		}
		// Náº¿u má»�i thá»© tá»‘t Ä‘áº¹p.
		// Redirect sang trang danh sĂ¡ch sáº£n pháº©m.
		else {
			response.sendRedirect(request.getContextPath() + "/ManageCategory");
		}
	}

}
