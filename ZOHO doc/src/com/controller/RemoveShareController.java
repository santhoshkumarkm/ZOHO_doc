package com.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONObject;

import com.dao.ClientsInfoDao;

@WebServlet("/RemoveShareController")
public class RemoveShareController extends HttpServlet {
	private static final long serialVersionUID = 5021L;
	String defaultLocation;

	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		defaultLocation = getServletContext().getInitParameter("defaultLocation");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		String sessionUser = (String) session.getAttribute("user");
		JSONObject jsonObject = new JSONObject();
		String successState = "false";
		String sharedUser = request.getParameter("user");
		String location = request.getParameter("location");
		if (location.startsWith(sessionUser)) {
			ClientsInfoDao.removeShare(sharedUser, location);
			successState = "true";
		}
		jsonObject.put("success", successState);
		response.setContentType("application/json");
		PrintWriter out = response.getWriter();
		out.print(jsonObject);
		out.flush();
	}
}