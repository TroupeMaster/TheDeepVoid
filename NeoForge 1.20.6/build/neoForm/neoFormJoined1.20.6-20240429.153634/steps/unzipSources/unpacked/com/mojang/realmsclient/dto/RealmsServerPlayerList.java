package com.mojang.realmsclient.dto;

import com.google.common.collect.Lists;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.mojang.logging.LogUtils;
import com.mojang.realmsclient.util.JsonUtils;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import org.slf4j.Logger;

@OnlyIn(Dist.CLIENT)
public class RealmsServerPlayerList extends ValueObject {
    private static final Logger LOGGER = LogUtils.getLogger();
    public long serverId;
    public List<UUID> players;

    public static RealmsServerPlayerList parse(JsonObject p_87591_) {
        RealmsServerPlayerList realmsserverplayerlist = new RealmsServerPlayerList();

        try {
            realmsserverplayerlist.serverId = JsonUtils.getLongOr("serverId", p_87591_, -1L);
            String s = JsonUtils.getStringOr("playerList", p_87591_, null);
            if (s != null) {
                JsonElement jsonelement = JsonParser.parseString(s);
                if (jsonelement.isJsonArray()) {
                    realmsserverplayerlist.players = parsePlayers(jsonelement.getAsJsonArray());
                } else {
                    realmsserverplayerlist.players = Lists.newArrayList();
                }
            } else {
                realmsserverplayerlist.players = Lists.newArrayList();
            }
        } catch (Exception exception) {
            LOGGER.error("Could not parse RealmsServerPlayerList: {}", exception.getMessage());
        }

        return realmsserverplayerlist;
    }

    private static List<UUID> parsePlayers(JsonArray p_87589_) {
        List<UUID> list = new ArrayList<>(p_87589_.size());

        for (JsonElement jsonelement : p_87589_) {
            if (jsonelement.isJsonObject()) {
                UUID uuid = JsonUtils.getUuidOr("playerId", jsonelement.getAsJsonObject(), null);
                if (uuid != null) {
                    list.add(uuid);
                }
            }
        }

        return list;
    }
}
