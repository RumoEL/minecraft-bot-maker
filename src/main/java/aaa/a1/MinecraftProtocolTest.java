package aaa.a1;

import com.github.rumoel.minecraft.botmaker.handlers.natives.exceptions.McLibListener;
import com.github.rumoel.minecraft.botmaker.objects.MinecraftBot;
import com.github.steveice10.mc.auth.exception.request.RequestException;
import com.github.steveice10.mc.auth.service.SessionService;
import com.github.steveice10.mc.protocol.MinecraftConstants;
import com.github.steveice10.mc.protocol.MinecraftProtocol;
import com.github.steveice10.packetlib.Client;
import com.github.steveice10.packetlib.ProxyInfo;
import com.github.steveice10.packetlib.Session;
import com.github.steveice10.packetlib.tcp.TcpClientSession;
import com.github.steveice10.packetlib.tcp.TcpSessionFactory;

public class MinecraftProtocolTest {

	private static final boolean VERIFY_USERS = false;
	private static final String HOST = "mc.SlenderEmpire.ru";
	private static final int PORT = 25580;
	private static final ProxyInfo PROXY = null;
	public static final String USERNAME = "4TsZRF5f";
	public static final String PASSWORD = "4Ts233f";

	// 95.31.27.213 4TsZRF5f 4Ts233f
	// mc.kenig-craft.ru 4TsZRF5f 4Ts233f
	// mc.SlenderEmpire.ru:25580 4TsZRF5f 4Ts233f

	public static void main(String[] args) throws RequestException {
		login();
	}

	private static void login() throws RequestException {
		MinecraftProtocol protocol = MinecraftBot.createProto(USERNAME, PASSWORD, false);

		SessionService sessionService = new SessionService();

		TcpSessionFactory sessionFactory = new TcpSessionFactory();

		Client client = new Client(HOST, PORT, protocol, sessionFactory);
		Session session = new TcpClientSession(HOST, PORT, protocol, client, PROXY);

		session.setFlag(MinecraftConstants.SESSION_SERVICE_KEY, sessionService);

		session.addListener(new McLibListener(session));

		session.connect();
	}

}