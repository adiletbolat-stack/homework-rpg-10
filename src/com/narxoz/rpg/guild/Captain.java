package com.narxoz.rpg.guild;

public class Captain extends GuildMember {

    public Captain(String name) {
        super(name, "captain");
    }

    @Override
    public void receive(
            String senderTopic,
            String message
    ) {

        System.out.println(
                "\n[Captain " + getName() + "]"
        );

        System.out.println(
                "Received strategic report from "
                        + senderTopic
        );

        System.out.println(
                "REPORT: " + message
        );
    }

    public void commandScout(String mission) {

        System.out.println(
                "\n[Captain " + getName() + "]"
        );

        System.out.println(
                "Issuing scouting mission..."
        );

        getMediator().dispatch(
                getTopic(),
                "scout",
                mission
        );
    }
}