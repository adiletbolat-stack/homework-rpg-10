package com.narxoz.rpg.guild;

public class Quartermaster extends GuildMember {

    public Quartermaster(String name) {
        super(name, "quartermaster");
    }

    @Override
    public void receive(
            String senderTopic,
            String message
    ) {

        System.out.println(
                "\n[Quartermaster " + getName() + "]"
        );

        System.out.println(
                "Managing guild supplies after message from "
                        + senderTopic
        );

        System.out.println(
                "SUPPLY TASK: " + message
        );
    }


    public void supplyUpdate(String update) {

        System.out.println(
                "\n[Quartermaster " + getName() + "]"
        );

        System.out.println(
                "Sending logistics update..."
        );

        getMediator().dispatch(
                getTopic(),
                "captain",
                update
        );
    }
}