package com.narxoz.rpg.guild;

public class Healer extends GuildMember {

    public Healer(String name) {
        super(name, "healer");
    }

    @Override
    public void receive(
            String senderTopic,
            String message
    ) {

        System.out.println(
                "\n[Healer " + getName() + "]"
        );

        System.out.println(
                "Preparing medical support after message from "
                        + senderTopic
        );

        System.out.println(
                "DETAILS: " + message
        );
    }

   
    public void requestHerbs(String request) {

        System.out.println(
                "\n[Healer " + getName() + "]"
        );

        System.out.println(
                "Requesting medical supplies..."
        );

        getMediator().dispatch(
                getTopic(),
                "quartermaster",
                request
        );
    }
}