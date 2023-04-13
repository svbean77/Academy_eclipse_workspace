package com.shinhan.frontcontrollerpattern;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

public class UploadController implements CommonControllerInterface {

	@Override
	public String execute(Map<String, Object> data) throws Exception {
		String method = (String) data.get("method");
		if(method.equals("GET")) {
			return "/uploadTest/uploadForm.jsp";
		}else {
			HttpServletRequest request = (HttpServletRequest) data.get("request");
			doHandle(request);
			return "/";
		}
		
	}

	private void doHandle(HttpServletRequest request)	throws ServletException, IOException {
		// 슬랙 코드 복붙임! doHandle만 그대로 가져와 (몇 개만 수정)
			String encoding = "utf-8";
			String currentPath = request.getServletContext().getRealPath("uploads"); // C:\\인 실제 경로를 알아야 함!
			System.out.println("실제 경로: " + currentPath);
			
			File currentDirPath = new File(currentPath);
			DiskFileItemFactory factory = new DiskFileItemFactory();
			factory.setRepository(currentDirPath);
			factory.setSizeThreshold(1024 * 1024);

			ServletFileUpload upload = new ServletFileUpload(factory);
			try {
				List items = upload.parseRequest(request);
				for (int i = 0; i < items.size(); i++) {
					FileItem fileItem = (FileItem) items.get(i);
	
					if (fileItem.isFormField()) {
						// input type="file"이 아닌 것! (여기서는 파라미터 입력)
						System.out.println(fileItem.getFieldName() + "=" + fileItem.getString(encoding));
					} else {
						// input type="file"인 것!
						System.out.println("파라미터명(getFieldName):" + fileItem.getFieldName());
						System.out.println("파일명(getName):" + fileItem.getName());
						System.out.println("파일크기(getSize):" + fileItem.getSize() + "bytes");
	
						if (fileItem.getSize() > 0) {
							int idx = fileItem.getName().lastIndexOf("\\");
							if (idx == -1) {
								idx = fileItem.getName().lastIndexOf("/");
							}
							String fileName = fileItem.getName().substring(idx + 1); // 경로를 전부 제외한 이름만 얻음
							File uploadFile = new File(currentDirPath + "\\" + fileName);
							fileItem.write(uploadFile); // 파일을 임시 서버에 업로드
						} // end if
					} // end if
				} // end for
			} catch (Exception e) {
				e.printStackTrace();
			}
	}
}
