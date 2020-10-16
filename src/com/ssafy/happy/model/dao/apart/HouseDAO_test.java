package com.ssafy.happy.model.dao.apart;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

public class HouseDAO_test {
	public static void main(String[] args) {
		BufferedReader br = null;
		try {
			String str = "http://openapi.molit.go.kr/OpenAPI_ToolInstallPackage/service/rest/RTMSOBJSvc/getRTMSDataSvcAptTradeDev?LAWD_CD=11110&DEAL_YMD=201512&serviceKey=ng%2B9adJCQm9rvqGUApsSL7DJT381Sa2GRmyTllx5%2F90Fqq5IXrU46RQIFm%2BMpo0bdzaI%2BJDJP58Hq1U3%2FV3Omg%3D%3D";
			URL url = new URL(str);
			HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
			urlConnection.setRequestMethod("GET");
			br = new BufferedReader(new InputStreamReader(urlConnection.getInputStream(), "UTF-8"));
			StringBuilder result = new StringBuilder();
			String line;
			while ((line = br.readLine()) != null) {
				result.append(line).append("\n");
				result.append("\n");
			}
			System.out.println(result.toString());
			System.out.println("----------------");
			DocumentBuilderFactory dbFactory = null;
			DocumentBuilder docBuilder = null;
			Document doc = null;
			NodeList nodes = null;
			Node node = null;
			Element element = null;
			InputSource is = new InputSource();

			dbFactory = DocumentBuilderFactory.newInstance();
			docBuilder = dbFactory.newDocumentBuilder();
			is = new InputSource();
			is.setCharacterStream(new StringReader(result.toString()));
			doc = docBuilder.parse(is);
			nodes = doc.getElementsByTagName("item");
			System.out.println(nodes.getLength());
			for (int i = 0, t_len = nodes.getLength(); i < t_len; i++) {
				element = (Element) nodes.item(i);
				try {
					String name = getTagValue("아파트", element);
					System.out.println(name);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private static String getTagValue(String sTag, Element element) {
	    try{
	        String result = element.getElementsByTagName(sTag).item(0).getTextContent();
	        return result;
	    } catch(NullPointerException e){
	        return "";
	    } catch(Exception e){
	        return "";
	    }
	}

}
