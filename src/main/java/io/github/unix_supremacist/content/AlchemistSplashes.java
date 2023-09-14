package io.github.unix_supremacist.content;

import io.github.feltmc.feltapi.api.splash.SplashAPI;

public class AlchemistSplashes {
    public static String[] splashes = {
            "Welcome to the World of Alchemy!"
    };

    public static void init(){
        for (String spl : splashes) SplashAPI.addSplash(spl);
    }
}
