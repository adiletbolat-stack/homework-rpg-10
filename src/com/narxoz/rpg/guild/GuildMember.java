package com.narxoz.rpg.guild;

public abstract class GuildMember {

    private final String name;
    private final String topic;

    private GuildMediator mediator;

    public GuildMember(
            String name,
            String topic
    ) {

        this.name = name;
        this.topic = topic;
    }

    public String getName() {
        return name;
    }

    public String getTopic() {
        return topic;
    }

    public GuildMediator getMediator() {
        return mediator;
    }

    public void setMediator(GuildMediator mediator) {
        this.mediator = mediator;
    }

    public abstract void receive(
            String senderTopic,
            String message
    );
}