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
	boolean check = false;
	
	public void connection() {
		//1. 드라이버 동적로딩
		try {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		
		String url = "jdbc:oracle:thin:@project-db-stu.ddns.net:1524:xe";
		String dbid = "campus_a_3_1025";
		String dbpw = "smhrd3";
		
		
		//2.데이터베이스 연결 객체(Connection) 생성
		conn = DriverManager.getConnection(url,dbid,dbpw);
		}catch(Exception e){
			e.printStackTrace();
			System.out.println("연결실패");
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
	private static String getTagValue(String tag, Element eElement) {
	    NodeList nlList = eElement.getElementsByTagName(tag).item(0).getChildNodes();
	    Node nValue = (Node) nlList.item(0);
	    if(nValue == null) 
	        return null;
	    return nValue.getNodeValue();
	}

	public static String getWeather(String url) {
		String weather = "";
		try{
			
				// parsing할 url 지정(API 키 포함해서)
				
				DocumentBuilderFactory dbFactoty = DocumentBuilderFactory.newInstance();
				DocumentBuilder dBuilder = dbFactoty.newDocumentBuilder();
				Document doc = dBuilder.parse(url);
				
				// root tag 
				doc.getDocumentElement().normalize();
				System.out.println("Root element :" + doc.getDocumentElement().getNodeName());
				
				// 파싱할 tag
				NodeList nList = doc.getElementsByTagName("data");
				//System.out.println("파싱할 리스트 수 : "+ nList.getLength());
				
				for(int temp = 0; temp < 1; temp++){
					Node nNode = nList.item(temp);
					if(nNode.getNodeType() == Node.ELEMENT_NODE){
						
						Element eElement = (Element) nNode;
						System.out.println("######################");
						//System.out.println(eElement.getTextContent());
						System.out.println("시간  : " + getTagValue("hour", eElement));
						System.out.println("기온  : " + getTagValue("temp", eElement));
						System.out.println("날씨 : " + getTagValue("wfKor", eElement));
						weather = getTagValue("wfKor", eElement);
					}	// for end
				}	// if end
				
				
				
				// while end
			
		} catch (Exception e){	
			e.printStackTrace();
		}	// try~catch end
		return weather;
	}	// main end
	
	
	public ArrayList<ProductVO> getAnzzi(String m_id) {
		ArrayList<ProductVO> pal = new ArrayList<ProductVO>();
		try {
			connection();
			
			String sql = "Select p_serialnum, p_location,detail_location from phistory where m_id = ?";
			psmt	= conn.prepareStatement(sql);
			psmt.setString(1, m_id);
			rs = psmt.executeQuery();
			
			while(rs.next()) {
				
				String p_serialnum = rs.getString(1);
				String p_location = rs.getString(2);
				String detail_location = rs.getString(3);
				
				
				vo = new ProductVO(p_serialnum,p_location,detail_location);
				pal.add(vo);
			}
			
		} catch (Exception e) {
				System.out.println("조회실패!");
				e.printStackTrace();
				
			}finally {
				close();
			}
		return pal;
	}
	
	
	
	
}
