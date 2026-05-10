package com.narxoz.rpg.guild;

public interface GuildMediator {

    void register(GuildMember member);

    void dispatch(
            String senderTopic,
            String targetTopic,
            String message
    );
}
