package com.github.rumoel.minecraft.botmaker.objects;

import com.github.rumoel.minecraft.botmaker.handlers.natives.exceptions.McLibListener;
import com.github.steveice10.mc.auth.exception.request.RequestException;
import com.github.steveice10.mc.auth.service.AuthenticationService;
import com.github.steveice10.mc.auth.service.SessionService;
import com.github.steveice10.mc.protocol.MinecraftConstants;
import com.github.steveice10.mc.protocol.MinecraftProtocol;
import com.github.steveice10.packetlib.Client;
import com.github.steveice10.packetlib.ProxyInfo;
import com.github.steveice10.packetlib.Session;
import com.github.steveice10.packetlib.tcp.TcpClientSession;
import com.github.steveice10.packetlib.tcp.TcpSessionFactory;

public class MinecraftBot {
	boolean license;
	String username;
	String password;

	private static final ProxyInfo PROXY = null;
	MinecraftServer server;
	MinecraftProtocol protocol;
	Client client;
	Session session;

	McLibListener mcLibListener;

	public MinecraftBot(String nick, String pass, MinecraftServer server, boolean license) {
		this.username = nick;
		this.password = pass;
		this.server = server;
		this.license = license;
	}

	public void init() throws RequestException {
		protocol = createProto(username, password, license);

		SessionService sessionService = new SessionService();

		TcpSessionFactory sessionFactory = new TcpSessionFactory();
		this.client = new Client(server.host, server.port, protocol, sessionFactory);
		session = new TcpClientSession(server.host, server.port, protocol, client, PROXY);

		session.setFlag(MinecraftConstants.SESSION_SERVICE_KEY, sessionService);

		this.mcLibListener = new McLibListener(session);
		session.addListener(this.mcLibListener);
	}

	public void connect() {
		session.connect();
	}

	public static MinecraftProtocol createProto(String nick, String pass, boolean needLic) throws RequestException {
		MinecraftProtocol protocol;
		if (needLic) {
			AuthenticationService authService = new AuthenticationService();
			authService.setUsername(nick);
			authService.setPassword(pass);
			authService.login();
			protocol = new MinecraftProtocol(authService.getSelectedProfile(), authService.getAccessToken());
			System.out.println("Successfully authenticated user.");
		} else {
			protocol = new MinecraftProtocol(nick);
		}
		return protocol;
	}

}
