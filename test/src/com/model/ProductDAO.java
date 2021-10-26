package com.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class ProductDAO {

	
	Connection conn = null;
	PreparedStatement psmt = null;
	ResultSet rs = null;
	ProductVO vo = null;
	ArrayList<ProductVO> al = null;
	int cnt = 0;
	boolean check = false;
	
	public void connection() {
		//1. ����̹� �����ε�
		try {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		
		String url = "jdbc:oracle:thin:@project-db-stu.ddns.net:1524:xe";
		String dbid = "campus_a_3_1025";
		String dbpw = "smhrd3";
		
		
		//2.�����ͺ��̽� ���� ��ü(Connection) ����
		conn = DriverManager.getConnection(url,dbid,dbpw);
		}catch(Exception e){
			e.printStackTrace();
			System.out.println("�������");
		}
	}
	
	public void close() {
		try {
			if(rs != null) {
				rs.close();
			}
			if(psmt != null) {
				psmt.close();
			}
			if(conn != null) {
				conn.close();
			}
		} catch (Exception e2) {
			e2.printStackTrace();
			
		}
	}
	
	public void locate() {
		
	}
	private String getTagValue(String tag, Element eElement) {
	    NodeList nlList = eElement.getElementsByTagName(tag).item(0).getChildNodes();
	    Node nValue = (Node) nlList.item(0);
	    if(nValue == null) 
	        return null;
	    return nValue.getNodeValue();
	}

	public String getWeather(String url) {
		String weather = "";
		try{
			
				// parsing�� url ����(API Ű �����ؼ�)
				
				DocumentBuilderFactory dbFactoty = DocumentBuilderFactory.newInstance();
				DocumentBuilder dBuilder = dbFactoty.newDocumentBuilder();
				Document doc = dBuilder.parse(url);
				
				// root tag 
				doc.getDocumentElement().normalize();
				System.out.println("Root element :" + doc.getDocumentElement().getNodeName());
				
				// �Ľ��� tag
				NodeList nList = doc.getElementsByTagName("data");
				//System.out.println("�Ľ��� ����Ʈ �� : "+ nList.getLength());
				
				for(int temp = 0; temp < 1; temp++){
					Node nNode = nList.item(temp);
					if(nNode.getNodeType() == Node.ELEMENT_NODE){
						
						Element eElement = (Element) nNode;
						System.out.println("######################");
						//System.out.println(eElement.getTextContent());
						System.out.println("�ð�  : " + getTagValue("hour", eElement));
						System.out.println("���  : " + getTagValue("temp", eElement));
						System.out.println("���� : " + getTagValue("wfKor", eElement));
						weather = getTagValue("wfKor", eElement);
					}	// for end
				}	// if end
				
				
				
				// while end
			
		} catch (Exception e){	
			e.printStackTrace();
		}	// try~catch end
		return weather;
	}	// main end
	
	
}