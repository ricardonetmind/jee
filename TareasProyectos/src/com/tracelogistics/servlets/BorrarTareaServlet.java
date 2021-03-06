package com.tracelogistics.servlets;

import java.io.IOException;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tracelogistics.db.BBDDMock;
import com.tracelogistics.db.TareasDAO;


@WebServlet("/tareas/borrar")
public class BorrarTareaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger logger=Logger.getLogger(BorrarTareaServlet.class.getName());

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setStatus(403);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setHeader("Content-Type", "application/json");

//		if (request.getSession().getAttribute("user") != null) {
			TareasDAO tDAO = TareasDAO.getInstance();
			int tid=request.getParameter("tid")!=null?(new Integer(request.getParameter("tid"))):0;
			logger.info("tid:"+tid);
						
			if(tDAO.deleteTarea(tid)) response.getWriter().append("{\"data\":true}");
			else response.getWriter().append("{\"data\":false}");
		/*}else {
			response.setStatus(403);
		}*/

	}

}
