/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.pw01_cinews.controllers;

import com.mycompany.pw01_cinews.dao.FavoriteNewsDAO;
import com.mycompany.pw01_cinews.dao.MediaDAO;
import com.mycompany.pw01_cinews.dao.NewsDAO;
import com.mycompany.pw01_cinews.dao.UserDAO;
import com.mycompany.pw01_cinews.models.FavoriteModel;
import com.mycompany.pw01_cinews.models.MediaModel;
import com.mycompany.pw01_cinews.models.NewsModel;
import com.mycompany.pw01_cinews.models.UserModel;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
@WebServlet(name = "Porfile", urlPatterns = {"/Porfile"})
public class PorfileController extends HttpServlet {
   
    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            int id = Integer.parseInt(request.getParameter("user"), 10);
            UserModel userPorfileSelect = UserDAO.UserSelectById(id);
            List<NewsModel> newsByUser = NewsDAO.GetNewsByIdUser(id);
            List<MediaModel> media = MediaDAO.GetMedia();
            List<FavoriteModel> favList = FavoriteNewsDAO.GetFavNewsByUser(id);
            request.setAttribute("UserPorfile", userPorfileSelect);
            request.setAttribute("NewsUser", newsByUser);
            request.setAttribute("Medias", media);
            request.setAttribute("FavList", favList);
            request.getRequestDispatcher("myporfile.jsp").forward(request,response);
        } catch (SQLException ex) {
            Logger.getLogger(PorfileController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("myporfile.jsp").forward(request,response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
