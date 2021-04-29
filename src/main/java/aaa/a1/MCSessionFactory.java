package aaa.a1;

import com.github.steveice10.packetlib.ProxyInfo;
import com.github.steveice10.packetlib.tcp.TcpSessionFactory;

public class MCSessionFactory extends TcpSessionFactory {

	public MCSessionFactory() {
		super();
	}

	public MCSessionFactory(ProxyInfo clientProxy) {
		super(clientProxy);
	}

}
