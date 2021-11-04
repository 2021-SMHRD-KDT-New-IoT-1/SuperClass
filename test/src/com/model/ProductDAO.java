package com.model;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Time;
import java.util.ArrayList;

import javax.servlet.http.HttpSession;
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
	ArrayList<ProductVO> al = new ArrayList<ProductVO>();
	
	
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
	
	public ProductVO SelectAnzziDetail(String p_serialnum) {
		try {
			connection();
			
			String sql = "Select p_serialnum, p_location,detail_location from phistory where p_serialnum = ?";
			psmt	= conn.prepareStatement(sql);
			psmt.setString(1, p_serialnum);
			rs = psmt.executeQuery();
			
			if(rs.next()) {
				
				p_serialnum = rs.getString(1);
				String p_location = rs.getString(2);
				String detail_location = rs.getString(3);
				
				
				vo = new ProductVO(p_serialnum,p_location,detail_location);
				
			}
			
		} catch (Exception e) {
				System.out.println("조회실패!");
				e.printStackTrace();
				
			}finally {
				close();
			}return vo;
	}
	
	int cnt=0;
	public int UpdateProduct(String p_location, String detail_location, String p_serialnum,String m_id) {
        
        try {
              
           connection();
           
           String sql="UPDATE phistory SET p_location=?, detail_location=? WHERE p_serialnum = ? and m_id =?";
           
           PreparedStatement psmt = conn.prepareStatement(sql);
           psmt.setString(1, p_location);
           psmt.setString(2, detail_location);
           psmt.setString(3, p_serialnum);
           psmt.setString(4, m_id);
   
           cnt = psmt.executeUpdate();
           
           
        } catch (Exception e) {
           
           e.printStackTrace();
        
        }finally {
           close();
        }
        return cnt;
     } 
	

	public ProductVO getLoginSerialnum(String m_id) {
		try {
			connection();
			
			String sql = "Select p_serialnum, p_location, detail_location from phistory where m_id = ? and rownum = 1";
			psmt = conn.prepareStatement(sql);
			psmt.setString(1,m_id);
			rs = psmt.executeQuery();
			
			if(rs.next()) {
				String p_serialnum = rs.getString(1);
				String p_location = rs.getString(2);
				String detail_location = rs.getString(3);
				
				vo = new ProductVO(p_serialnum,p_location,detail_location);
			}
			
		} catch (Exception e) {
				System.out.println("조회실패!");
				e.printStackTrace();
				
			}finally {
				close();
			}return vo;
	}
	
	public ArrayList<ProductVO> getMove(String p_serialnum,String p_date) {
		
		try {
			connection();
			System.out.println(p_date);
			java.sql.Date sqldate = java.sql.Date.valueOf(p_date); 
			System.out.println("셀렉트전");
			String sql = "select TO_CHAR(see_time, 'YYYY-MM-DD HH24:MI:SS') , p_value from mpattern where p_serialnum=? and see_time like ?";
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, p_serialnum);
			psmt.setDate(2, sqldate);
			rs = psmt.executeQuery();
			System.out.println("셀레긑후");
			while(rs.next()) {
				System.out.println("데이트 전");
				String movetime = rs.getString(1).substring(11, 16);
				System.out.println("데이트후");
				int movesensor = Integer.parseInt(rs.getString(2));
				System.out.println("센서후");
				vo = new ProductVO(p_serialnum,movetime,movesensor);
				al.add(vo);
				
			}
			
		} catch (Exception e) {
				System.out.println("조회실패!");
				e.printStackTrace();
				
			}finally {
				close();
			}return al;
	}

	

	
	
}
