package com.narxoz.rpg.guild;

public class Loremaster extends GuildMember {

    public Loremaster(String name) {
        super(name, "lore");
    }

    @Override
    public void receive(
            String senderTopic,
            String message
    ) {

        System.out.println(
                "\n[Loremaster " + getName() + "]"
        );

        System.out.println(
                "Archiving guild knowledge from "
                        + senderTopic
        );

        System.out.println(
                "ARCHIVE ENTRY: " + message
        );
    }

    public void archiveNotice(String note) {

        System.out.println(
                "\n[Loremaster " + getName() + "]"
        );

        System.out.println(
                "Submitting archive notice..."
        );

        getMediator().dispatch(
                getTopic(),
                "captain",
                note
        );
    }
}