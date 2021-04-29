package com.github.rumoel.minecraft.botmaker.handlers.natives.exceptions;

public class GlobalExceptionsHandler implements Thread.UncaughtExceptionHandler {
	@Override
	public void uncaughtException(Thread t, Throwable e) {
		System.err.println(t + ":" + e);
	}

}
