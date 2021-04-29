package com.github.rumoel.minecraft.botmaker;

import com.github.rumoel.minecraft.botmaker.gui.GuiServers;
import com.github.rumoel.minecraft.botmaker.handlers.natives.exceptions.GlobalExceptionsHandler;

public final class BotsHeader {
	private BotsHeader() {
	}

	public static GlobalExceptionsHandler globalExceptionsHandler = new GlobalExceptionsHandler();

	GuiServers guiServers = new GuiServers();
}
