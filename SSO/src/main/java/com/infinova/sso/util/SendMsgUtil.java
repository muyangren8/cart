package com.infinova.sso.util;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.URL;
import java.net.URLConnection;

public class SendMsgUtil {
	public static String send(String msg) {
		URL url = null;
		try {
			url = new URL("http://111.1.1.82:8080/smshxb/tcl_receive");
			URLConnection connection = url.openConnection();
			connection.setDoOutput(true);
			OutputStreamWriter out = new OutputStreamWriter(connection.getOutputStream(), "gb2312");
			// remember to clean up
			out.write(msg);
			out.flush();
			out.close();

			String sCurrentLine = "";
			String sTotalString = "";
			InputStream l_urlStream = connection.getInputStream();
			BufferedReader l_reader = new BufferedReader(new InputStreamReader(l_urlStream));
			while ((sCurrentLine = l_reader.readLine()) != null) {
				sTotalString += sCurrentLine + "\r\n";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
