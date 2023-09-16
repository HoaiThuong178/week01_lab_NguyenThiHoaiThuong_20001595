package vn.edu.iuh.fit.controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import vn.edu.iuh.fit.Services.AccountService;
import vn.edu.iuh.fit.connection.Connection;
import vn.edu.iuh.fit.entities.Account;

import java.io.IOException;
import java.util.Optional;

@WebServlet(urlPatterns = {"/ControlServlet"})
public class ControlServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        resp.getWriter().println(action);

        Connection.getInstance().getEm();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        String username = req.getParameter("id");
        String password = req.getParameter("pwd");

        AccountService accountService=new AccountService();
        Optional<Account> login = accountService.isLogin(username, password);
        if(login.equals(Optional.empty()))
            resp.getWriter().println("Fail");
        else
            resp.getWriter().println("Success");

        resp.sendRedirect("index.jsp");
    }
}
