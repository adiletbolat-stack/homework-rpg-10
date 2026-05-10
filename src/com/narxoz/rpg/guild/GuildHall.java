package com.narxoz.rpg.guild;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GuildHall implements GuildMediator {

    private final Map<String, List<GuildMember>> topicMembers;

    public GuildHall() {
        this.topicMembers = new HashMap<>();
    }

    @Override
    public void register(GuildMember member) {

        member.setMediator(this);

        topicMembers.putIfAbsent(
                member.getTopic(),
                new ArrayList<>()
        );

        topicMembers
                .get(member.getTopic())
                .add(member);

        System.out.println(
                "[GuildHall] Registered "
                        + member.getName()
                        + " under topic: "
                        + member.getTopic()
        );
    }

    @Override
    public void dispatch(
            String senderTopic,
            String targetTopic,
            String message
    ) {

        System.out.println(
                "\n[GuildHall] Dispatching message"
        );

        System.out.println(
                "FROM: " + senderTopic
        );

        System.out.println(
                "TO: " + targetTopic
        );

        System.out.println(
                "MESSAGE: " + message
        );

        if (targetTopic.equals("all")) {

            for (List<GuildMember> members
                    : topicMembers.values()) {

                for (GuildMember member : members) {

                    if (!member.getTopic()
                            .equals(senderTopic)) {

                        member.receive(
                                senderTopic,
                                message
                        );
                    }
                }
            }

            return;
        }

        if (!topicMembers.containsKey(targetTopic)) {

            System.out.println(
                    "[GuildHall] No subscribers for topic: "
                            + targetTopic
            );

            return;
        }

        for (GuildMember member
                : topicMembers.get(targetTopic)) {

            if (!member.getTopic()
                    .equals(senderTopic)) {

                member.receive(
                        senderTopic,
                        message
                );
            }
        }
    }
}