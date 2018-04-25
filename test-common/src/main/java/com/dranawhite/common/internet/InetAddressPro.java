package com.dranawhite.common.internet;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * @author liangyq
 * @version [1.0, 2018/4/24 14:28]
 */
public class InetAddressPro {

	public static void main(String[] args) throws UnknownHostException {
		InetAddress inetAddress = InetAddress.getLocalHost();
		String address = inetAddress.getHostAddress();
		System.out.println(address);


	}

}
