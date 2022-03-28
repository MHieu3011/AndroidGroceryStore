package com.ptit.androidgrocerystore.global;

import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;

import java.io.File;

public class ConfigInfo {

    private ConfigInfo() {
    }

    private static Config config = ConfigFactory.parseFile(new File("conf.properties"));

    public static final String API_USER_CREATE = config.getString("api.user.create");
}
