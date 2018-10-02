/*
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.type.IntegerTypeHandler;

import com.google.gson.Gson;
import com.iphone.dao.UserMapper;
import com.iphone.entity.User;
import com.iphone.entity.UserInfo;
import com.iphone.entity.UserSafe;
import com.iphone.service.Service;
import com.iphone.serviceimpl.ServiceImpl;
import com.iphone.test.Testmethod;
import com.iphone.util.IsEmptyUtils;
import com.iphone.util.MyBatisUtil;

	*//**
		 * 
		 *//*

	// 用户登录
	public void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String appleid = request.getParameter("appleid");
		String upwd = request.getParameter("upwd");
		out.write(service.login(appleid, upwd));
		out.flush();
		out.close();
	}
	// 注册
	public void regster(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String appleID = request.getParameter("AppleID");
		String name = request.getParameter("Name");
		String sex = request.getParameter("Sex");
		String passWord = request.getParameter("PassWord");
		String country = request.getParameter("Country");
		String birthday = request.getParameter("Birthday");
		String question1 = request.getParameter("Question_1");
		String answay1 = request.getParameter("Answay_1");
		String question2 = request.getParameter("Question_2");
		String answay2 = request.getParameter("Answay_2");
		String question3 = request.getParameter("Question_3");
		String answay3 = request.getParameter("Answay_3");
		UserSafe usafe = new UserSafe(appleID, question1, answay1, question2, answay2, question3, answay3);
		User user = new User(appleID, name, sex, passWord, country, birthday);
		if (service.getUserByID(appleID) == null) {
			service.addUser(user);
			service.addUserSafe(usafe);
			out.print(1);
		} else {
			out.print(0);
		}
		out.flush();
		out.close();
	}
	//修改密码
	public void updatePass(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	response.setContentType("text/html");
	PrintWriter out = response.getWriter();
	String appleID = request.getParameter("appleID");
	String oldpass = request.getParameter("oldpass");
	String newpass = request.getParameter("newpass");
	User u = service.getUserByID(appleID);
	if (!u.getPassWord().equals(oldpass)) {
		out.print(1);//旧密码输入错误
	} else {
		u.setPassWord(newpass);
		service.updateUser(u);
		out.print(2);//找回成功
	}
	out.flush();
	out.close();
}
	// 查询所有用户
	public void getUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		int page = Integer.parseInt(request.getParameter("page"));
		Integer row = Integer.parseInt(request.getParameter("rows"));
		String name = null, appleID = null;
		if (request.getParameter("AppleID") != "") {
			appleID = request.getParameter("AppleID");
		}
		if (request.getParameter("Name") != "") {
			name = request.getParameter("Name");
		}
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("name", name);
		map.put("AppleID", appleID);
		map.put("start", (page - 1) * row);
		map.put("pageSize", row);
		out.write(service.getUser(map));
		out.flush();
		out.close();
	}

	// 根据id验证，并找回密码
	public void getVerityAppId(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String AppleID = null, Birthday = null;
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("AppleID", AppleID);
		if (!IsEmptyUtils.isEmpty(request.getParameter("AppleID"))) {
			AppleID = request.getParameter("AppleID");
		}
		if (!IsEmptyUtils.isEmpty(request.getParameter("Birthday"))) {
			Birthday = request.getParameter("Birthday");
		}
		User u = service.getUserByID(AppleID);
		if (u == null) {
			out.print(0);
		} else if (!u.getBirthday().equals(Birthday)) {
			out.print(1);
		} else {
			out.print(2);
		}
		out.flush();
		out.close();
	}

	// 根据AppleID查询用户
	public void getUserByID(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String AID = request.getParameter("AppleID");
		User u = service.getUserByID(AID);
		out.write(new Gson().toJson(u));
		out.flush();
		out.close();
	}

	// 修改用户
	public void updateUser(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("application/json;charset=utf-8");
		PrintWriter out = response.getWriter();
		String appleID = request.getParameter("AppleID");
		String name = request.getParameter("Name");
		String sex = request.getParameter("Sex");
		String passWord = request.getParameter("PassWord");
		String country = request.getParameter("Country");
		String birthday = request.getParameter("Birthday");
		User u = new User(appleID, name, sex, passWord, country, birthday);
		out.write(service.updateUser(u));
		out.flush();
		out.close();
	}

	// 添加用户
	public void addUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("application/json;charset=utf-8");
		PrintWriter out = response.getWriter();
		String appleID = request.getParameter("AppleID");
		String name = request.getParameter("Name");
		String sex = request.getParameter("Sex");
		String passWord = request.getParameter("PassWord");
		String country = request.getParameter("Country");
		String birthday = request.getParameter("Birthday");
		User u = new User(appleID, name, sex, passWord, country, birthday);
		out.write(service.addUser(u));
		out.flush();
		out.close();
	}

	// 批量删除
	public void deleteUsers(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String appleid = request.getParameter("appleids");
		String[] array = appleid.split(",");
		List<String> appleids = new ArrayList<String>();
		for (int i = 0; i < array.length; i++) {
			appleids.add(array[i]);
		}
		out.write(service.deleteUsers(appleids));
		out.flush();
		out.close();
	}

	// 锁定用户
	public void lockUser(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String appleid = request.getParameter("appleids");
		String[] array = appleid.split(",");
		List<String> appleids = new ArrayList<String>();
		for (int i = 0; i < array.length; i++) {
			appleids.add(array[i]);
		}
		out.write(service.lockUser(appleids));
		out.flush();
		out.close();
	}

	// 解锁用户
	public void unlockUser(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String appleid = request.getParameter("appleids");
		String[] array = appleid.split(",");
		List<String> appleids = new ArrayList<String>();
		for (int i = 0; i < array.length; i++) {
			appleids.add(array[i]);
		}
		out.write(service.unlockUser(appleids));
		out.flush();
		out.close();
	}

	// 显示用户信息
	public void getUserInfo(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String name = "";
		if (!IsEmptyUtils.isEmpty(request.getParameter("name"))) {
			name = request.getParameter("name");
		}
		String Apple = "";
		if (!IsEmptyUtils.isEmpty(request.getParameter("Apple"))) {
			Apple = request.getParameter("Apple");
		}
		int page = 1;
		int rows = 10;
		if (!IsEmptyUtils.isEmpty(request.getParameter("page"))) {
			page = Integer.parseInt(request.getParameter("page"));
		}
		if (!IsEmptyUtils.isEmpty(request.getParameter("rows"))) {
			rows = Integer.parseInt(request.getParameter("rows"));
		}
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("name", name);
		map.put("AppleID", Apple);
		map.put("start", (page - 1) * rows);
		map.put("pageSize", rows);
		PrintWriter out = response.getWriter();
		out.write(service.getUserInfo(map));
		out.flush();
		out.close();
	}

	// 添加用户信息
	public void addUserInfo(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("application/json;charset=utf-8");
		PrintWriter out = response.getWriter();
		String appleID = request.getParameter("AppleID");
		String phoneNum = request.getParameter("PhoneNum");
		String qQNum = request.getParameter("QQNum");
		String credentialsType = request.getParameter("CredentialsType");
		String credentialsID = request.getParameter("CredentialsID");
		String company = request.getParameter("Company");
		String rOFS = request.getParameter("ROFS");
		String overSchool = request.getParameter("OverSchool");
		UserInfo userinfo = new UserInfo(appleID, phoneNum, qQNum, credentialsType, credentialsID, company, rOFS,overSchool);
		out.write(service.addUserInfo(userinfo));
		out.flush();
		out.close();
	}

	// 删除用户信息
	public void deleteUserInfo(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String appleid = request.getParameter("appleids");
		String[] array = appleid.split(",");
		List<String> appleids = new ArrayList<String>();
		for (int i = 0; i < array.length; i++) {
			appleids.add(array[i]);
		}
		out.write(service.deleteUserInfo(appleids));
		out.flush();
		out.close();
	}

	// 编辑用户信息
	public void updateUserInfo(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("application/json;charset=utf-8");
		PrintWriter out = response.getWriter();
		String appleID = request.getParameter("AppleID");
		String phoneNum = request.getParameter("PhoneNum");
		String qQNum = request.getParameter("QQNum");
		String credentialsType = request.getParameter("CredentialsType");
		String credentialsID = request.getParameter("CredentialsID");
		String company = request.getParameter("Company");
		String rOFS = request.getParameter("ROFS");
		String overSchool = request.getParameter("OverSchool");
		UserInfo u=new UserInfo(appleID, phoneNum, qQNum, credentialsType, credentialsID, company, rOFS, overSchool);
		//UserInfo u = new UserInfo(appleID, phoneNum, qQNum, credentialsType, credentialsID, address, rOFS,overSchool);
		out.write(service.updateUserInfo(u));
		out.flush();
		out.close();
	}

	// 根据AppleID查询用户信息
	public void getUserInfoByID(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String appid = request.getParameter("AppleID");
		UserInfo u = service.getUserInfoByID(appid);
		out.print(new Gson().toJson(u));
		out.flush();
		out.close();
	}

	// 显示用户安全的信息
	public void getUserSafe(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		List<UserSafe> list = service.getUserSafe();
		out.write(new Gson().toJson(list));
		out.flush();
		out.close();
	}

	// 根据查找AppleID用户安全信息
	public void getUserSafeByID(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String appid = request.getParameter("AppleID");
		UserSafe u = service.getUserSafeByID(appid);
		out.write(new Gson().toJson(u));
		out.flush();
		out.close();
	};

	// 获取用户安全问题
	public void getUserSafeQusByID(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String appid = request.getParameter("AppleID");
		UserSafe u = service.getUserSafeByID(appid);
		Map<String, Object> res = new HashMap<String, Object>();
		res.put("ques1", u.getQuestion_1());
		res.put("ques2", u.getQuestion_2());
		res.put("ques3", u.getQuestion_3());
		out.write(new Gson().toJson(res));
		out.flush();
		out.close();
	}

	// 判断问题是否正确
	public void VeritySafe(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String answay1 = request.getParameter("answay1");
		String answay2 = request.getParameter("answay2");
		String answay3 = request.getParameter("answay3");
		String password = request.getParameter("PassWord");
		String appid = request.getParameter("appid");
		UserSafe u = service.getUserSafeByID(appid);
		if (!answay1.equals(u.getAnsway_1())) {
			out.print(1);
		} else if (!answay2.equals(u.getAnsway_2())) {
			out.print(2);
		} else if (!answay3.equals(u.getAnsway_3())) {
			out.print(3);
		} else {
			User user = service.getUserByID(appid);
			user.setPassWord(password);
			service.updateUser(user);
			out.print(0);
		}
		out.flush();
		out.close();
	}

	// 添加用户安全问题
	public void addUserSafe(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("application/json;charset=utf-8");
		PrintWriter out = response.getWriter();
		String appleID = request.getParameter("AppleID");
		String question1 = request.getParameter("Question_1");
		String answay1 = request.getParameter("Answay_1");
		String question2 = request.getParameter("Question_2");
		String answay2 = request.getParameter("Answay_2");
		String question3 = request.getParameter("Question_3");
		String answay3 = request.getParameter("Answay_3");
		UserSafe u = new UserSafe(appleID, question1, answay1, question2, answay2, question3, answay3);
		out.write(service.addUserSafe(u));
		out.flush();
		out.close();
	}

	// 删除用户安全信息
	public void deleteUserSafeByID(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String appleid = request.getParameter("appleids");
		String[] array = appleid.split(",");
		List<String> appleids = new ArrayList<String>();
		for (int i = 0; i < array.length; i++) {
			appleids.add(array[i]);
		}
		out.write(service.deleteUserSafeByID(appleids));
		out.flush();
		out.close();
	}

	// 修改用户安全问题
	public void updateUserSafe(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("application/json;charset=utf-8");
		PrintWriter out = response.getWriter();
		String appleID = request.getParameter("AppleID");
		String question1 = request.getParameter("Question_1");
		String answay1 = request.getParameter("Answay_1");
		String question2 = request.getParameter("Question_2");
		String answay2 = request.getParameter("Answay_2");
		String question3 = request.getParameter("Question_3");
		String answay3 = request.getParameter("Answay_3");
		UserSafe u = new UserSafe(appleID, question1, answay1, question2, answay2, question3, answay3);
		out.write(service.updateUserSafe(u));
		out.flush();
		out.close();
	}

}
*/