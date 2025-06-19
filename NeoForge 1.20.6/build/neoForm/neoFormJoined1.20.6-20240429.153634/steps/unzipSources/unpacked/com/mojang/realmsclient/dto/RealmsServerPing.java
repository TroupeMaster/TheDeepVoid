package com.mojang.realmsclient.dto;

import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class RealmsServerPing extends ValueObject {
    public volatile String nrOfPlayers = "0";
    public volatile String playerList = "";
}
