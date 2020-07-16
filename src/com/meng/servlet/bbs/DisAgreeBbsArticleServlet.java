package com.meng.servlet.bbs;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.meng.beans.BbsArtId;
import com.meng.dao.BbsArtIdDao;
import com.meng.dao.BbsArticleDao;

public class DisAgreeBbsArticleServlet extends HttpServlet {

	BbsArticleDao bbsArticleDao = new BbsArticleDao();
	BbsArtIdDao bArtIdDao = new BbsArtIdDao();
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String aticleId = request.getParameter("articleId");
		HttpSession session = request.getSession();
		String stuid = (String) session.getAttribute("loginStuid");
		BbsArtId bbsArtId = bArtIdDao.findBbsArt(stuid,aticleId);
		if(bbsArtId==null){
			//agree=agree+1
			bbsArticleDao.updateDisagree(aticleId);
			bArtIdDao.AddbbsArtIdfordisagree(stuid,aticleId);
		}
		else{
			//如果没点击过同意
			if(bbsArtId.getForflag()==0){
				if (bbsArtId.getFlag()==1) {
					//disagree=disagree-1
					bbsArticleDao.updateDisagree1(aticleId);
					//flag=0
					bArtIdDao.updateFlag1(stuid,aticleId);
				}
				else{
					//disagree=disagree+1
					bbsArticleDao.updateDisagree(aticleId);
					//flag=1
					bArtIdDao.updateFlag2(stuid, aticleId);
				}
			}
			//点击过同意
			else{
				//forflag=0
				bArtIdDao.updateforFlag1(stuid, aticleId);
				if (bbsArtId.getFlag()==1) {
					//agree=agree-1
					bbsArticleDao.updateAgree1(aticleId);
					//disagree=disagree+1
					bbsArticleDao.updateDisagree(aticleId);
					//flag=1
					bArtIdDao.updateFlag2(stuid,aticleId);
				}
				else{
					//disagree=disagree+1
					bbsArticleDao.updateDisagree(aticleId);
					bArtIdDao.updateFlag2(stuid, aticleId);
				}
			}
		}
		response.sendRedirect(request.getContextPath()+"/bbsdetailarticleservlet?articleid="+aticleId);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
	}

}
