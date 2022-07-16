package com.qr.example.controller;

import com.google.zxing.Result;
import com.qr.example.util.QRCodeUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;

@Controller
public class QrCodeController {

	@RequestMapping("/getNormalQR")
	public void getNormalQR(HttpServletRequest request,HttpServletResponse response){
		String content = request.getParameter("text");
		ServletOutputStream stream;
		try {
			stream = response.getOutputStream();
			String path = Thread.currentThread().getContextClassLoader().getResource("").getPath()
					+ "static" + File.separator +"photo"+ File.separator;
			QRCodeUtil.zxingCodeCreate(content, path, 250, null,stream);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@RequestMapping("/getLogoQR")
	public void getLogoQR(HttpServletRequest request,HttpServletResponse response){
		String content = request.getParameter("text");
		ServletOutputStream stream;
		try {
			stream = response.getOutputStream();
			String path = Thread.currentThread().getContextClassLoader().getResource("").getPath()
					+ "static" + File.separator +"photo"+ File.separator;
			String logoPath = Thread.currentThread().getContextClassLoader().getResource("").getPath()
					+"static"+File.separator+"logo.jpg";
			QRCodeUtil.zxingCodeCreate(content, path, 500, logoPath,stream);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@RequestMapping("/analysiscode")
	@ResponseBody
	public Result analysiscode(HttpServletRequest request){
		String name = request.getParameter("name");
		String path = Thread.currentThread().getContextClassLoader().getResource("").getPath()       
				+ "static" + File.separator +"photo"+ File.separator+name;
		Result result = QRCodeUtil.zxingCodeAnalyze(path);
		
		return result;
	}
}
