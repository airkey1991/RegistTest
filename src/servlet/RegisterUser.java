package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.RegisterUserLogic;
import model.User;

/**
 * Servlet implementation class RegisterUser
 */
@WebServlet("/RegisterUser")
public class RegisterUser extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterUser() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// フォワード先
		String forwardPath = null;

		//サーブレットクラスの動作を決定する「action」の値をリクエストパラメータから取得
		String action = request.getParameter("action");

		//「登録の開始」をリクエストされた時の処理
		if(action == null) {
			// フォワード先を設定
			forwardPath = "/WEB-INF/jsp/registerForm.jsp";
		}

		//登録確認画面から「登録実行」をリクエストされた時の処理

		else if (action.equals("done")){
			//セッションスコープに保存された登録ユーザを取得
			HttpSession session = request.getSession();
			User registerUser = (User) session.getAttribute("registUser");

			//登録処理の呼び出し
			RegisterUserLogic logic = new RegisterUserLogic();
			logic.register(registerUser);

			//不要となったセッションスコープ内のインスタンスを削除
			session.removeAttribute("registerUser");

			//登録後のフォワード先を指定
			forwardPath = "/WEB-INF/jsp/registerDone.jsp";
		}

		//登録されたフォワード先にフォワード
		RequestDispatcher dispatcher =
				request.getRequestDispatcher(forwardPath);
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		String pass = request.getParameter("pass");

		//登録するユーザの情報を設定
		User registerUser = new User(id,name,pass);

		//セッションスコープに登録ユーザーを保存
		HttpSession session = request.getSession();
		session.setAttribute("registerUser", registerUser);

		//フォワード
		RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/registerConfirm.jsp");
		dispatcher.forward(request, response);
	}
}
