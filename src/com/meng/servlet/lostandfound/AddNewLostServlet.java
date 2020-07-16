package com.meng.servlet.lostandfound;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.IOUtils;

import com.meng.beans.LostAndFound;
import com.meng.dao.LostAndFoundDao;

public class AddNewLostServlet extends HttpServlet {

	LostAndFoundDao lostAndFoundDao = new LostAndFoundDao();
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doPost(request, response);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//目的：收集表单的数据 封装一个Product实体 将上传图片存到服务器磁盘上
		
		LostAndFound secondproduct = new LostAndFound();
		
		//收集数据的容器
		Map<String,Object> map = new HashMap<String,Object>();
		
		try {
			//创建磁盘文件项工厂
			DiskFileItemFactory factory = new DiskFileItemFactory();
			//创建文件上传核心对象
			ServletFileUpload upload = new ServletFileUpload(factory);
			//解析request获得文件项对象集合

			List<FileItem> parseRequest = upload.parseRequest(request);
			for(FileItem item : parseRequest){
				//判断是否是普通表单项
				boolean formField = item.isFormField();
				if(formField){
					//普通表单项 获得表单的数据 封装到Product实体中
					String fieldName = item.getFieldName();
					String fieldValue = item.getString("UTF-8");
					
					map.put(fieldName, fieldValue);
					
				}else{
					//文件上传项 获得文件名称 获得文件的内容
					String fileName = item.getName();
					if(fileName==null||("".equals(fileName))){
						map.put("img", null);
					}
					else{
						String path = this.getServletContext().getRealPath("upload");
						InputStream in = item.getInputStream();
						OutputStream out = new FileOutputStream(path+"/"+fileName);//I:/xxx/xx/xxx/xxx.jpg
						IOUtils.copy(in, out);
						in.close();
						out.close();
						item.delete();
						
						map.put("img", "upload/"+fileName);
					}
				}
				
			}
			HttpSession session = request.getSession();
			String stuid = (String) session.getAttribute("loginStuid");
			String username = (String) session.getAttribute("loginUser");
			String content =  (String) map.get("content");
			String lostorfount = (String) map.get("lostorfount");
			String img = (String) map.get("img");
			lostAndFoundDao.Addnewlost(stuid,username,content,lostorfount,img);
			response.sendRedirect(request.getContextPath()+"/lostandfountlistservlet");
			
			
			
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}