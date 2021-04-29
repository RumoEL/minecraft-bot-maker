package com.github.rumoel.minecraft.botmaker.init;

import java.util.concurrent.CopyOnWriteArrayList;

import com.github.rumoel.minecraft.botmaker.BotsHeader;
import com.github.rumoel.minecraft.botmaker.objects.MinecraftBot;
import com.github.rumoel.minecraft.botmaker.objects.MinecraftServer;
import com.github.steveice10.mc.auth.exception.request.RequestException;

public class InitMaker {
	static CopyOnWriteArrayList<MinecraftServer> servers = new CopyOnWriteArrayList<>();

	public static void main(String[] args) throws RequestException {
		// HANDLERS
		Thread.setDefaultUncaughtExceptionHandler(BotsHeader.globalExceptionsHandler);
		// HANDLERS

		// GUI
		// GUI

		// NETWORK
		// NETWORK

		// Servers
		// ПРОВЕРКА addServer("mc.restartcraft.ru");
		addServer("95.31.27.213");
		addServer("mr.easy-land.ru");
		addServer("mc.SlenderEmpire.ru", 25580);
		addServer("mc.aormio.ru");
		addServer("ah.fundaily.xyz");
		// ПРОВЕРКА addServer("mc.akagame.ru");
		// ПРОВЕРКА addServer("mc.draimcido.ru");
		addServer("mc.destmine.ru");
		addServer("GO.WOLF-LAND.RU");
		addServer("mc.minedagger.ru");
		addServer("mc.ytya.ru");
		// ПРОВЕРКА addServer("minegames.ru");
		addServer("mc.cybergames.ru");
		// ПРОВЕРКА addServer("mc.happycreeper.ru");
		// ПРОВЕРКА addServer("megaland.mcmcmc.ru");
		// OFF addServer("darkmine.ru");
		addServer("vanillaonly.ru");
		addServer("mc.kenig-craft.ru");
		addServer("mc.jellycraft.su");
		// ПРОВЕРКА addServer("mc-play.ru");
		// ПРОВЕРКА addServer("new.fp-play.ru");
		addServer("mcorp.su");
		addServer("omegamc.ru");
		addServer("vanilla.makotomc.ru");

		// DNS addServer("vanillalife.joinserver.ru");
		addServer("mc.artz.su");// Зарегистируйтесь： /ｒｅｇ ［пароль］ ［повтор_пароля］сделано
		// Servers
		// BOTS
		bots();
		// BOTS

	}

	private static void bots() throws RequestException {
		for (MinecraftServer server : servers) {
			MinecraftBot bot = new MinecraftBot("4TsZRF5f", "4Ts233f", server, false);
			bot.init();
			bot.connect();
		}
	}

	private static void addServer(String host, int port) {
		MinecraftServer server = new MinecraftServer(host, port);
		servers.add(server);
	}

	private static void addServer(String host) {
		addServer(host, 25565);
	}

}
