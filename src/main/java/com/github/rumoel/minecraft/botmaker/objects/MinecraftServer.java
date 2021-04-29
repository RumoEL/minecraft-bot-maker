package com.github.rumoel.minecraft.botmaker.objects;

public class MinecraftServer {
	private static final int DEFAULTPORT = 25565;

	String host;
	int port = DEFAULTPORT;

	public MinecraftServer(String host) {
		this.host = host;
	}

	public MinecraftServer(String host, int port) {
		this.host = host;
		this.port = port;
	}

}
