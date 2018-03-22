package com.baidu;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.PathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.WritableResource;
import org.springframework.core.io.support.EncodedResource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.context.support.ServletContextResource;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestR {
	
	@Test
	public void test1() throws IOException {
		String filePath = "D:\\ideaworkspace\\datajpa\\src\\main\\resources\\conf\\file1.txt";
		WritableResource res1= new PathResource(filePath);
		
		
		Resource res2 = new ClassPathResource("conf/file1.txt");
		
		OutputStream out1 = res1.getOutputStream();
		out1.write("欢迎光临".getBytes());
		out1.close();
		
		InputStream ins1 = res1.getInputStream();
		InputStream ins2 = res2.getInputStream();
		
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		int i;
		while((i = ins1.read())!=-1){
			baos.write(i);
		}
		System.out.println(baos.toString());
		
		System.out.println(res1.getFilename());
		System.out.println(res2.getFilename());
		
		
//		ServletContext servletContext = ServletActionContext.getServletContext();
//		new ServletContextResource(application, "/WEB-INF/classes/conf/file1.txt");
		
	}
	
	public static void main(String[] args) throws IOException {
		Resource res = new ClassPathResource("conf/file1.txt");
		EncodedResource encRes = new org.springframework.core.io.support.EncodedResource(res, "UTF-8");
		String copyToString = FileCopyUtils.copyToString(encRes.getReader());
		System.out.println(copyToString);
	}
	
}
