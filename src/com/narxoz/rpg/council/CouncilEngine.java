package com.narxoz.rpg.council;

import com.narxoz.rpg.combatant.Hero;
import com.narxoz.rpg.guild.GuildMediator;
import com.narxoz.rpg.quest.Quest;
import com.narxoz.rpg.quest.QuestIterator;
import com.narxoz.rpg.quest.QuestLog;

import java.util.List;

/**
 * Orchestrates a planning session that uses
 * both Iterator and Mediator patterns.
 */
public class CouncilEngine {

    public CouncilRunResult runCouncil(
            List<Hero> party,
            QuestLog questLog,
            GuildMediator hall
    ) {

        int questsTraversed = 0;
        int messagesRouted = 0;
        int membersNotified = 0;

        System.out.println("=================================");
        System.out.println("      COUNCIL SESSION START      ");
        System.out.println("=================================");

        System.out.println("\nParty members:");
        for (Hero hero : party) {
            System.out.println("- " + hero.getName());
        }

        /*
         * ITERATOR #1
         * Ordered traversal
         */
        System.out.println("\n=== ORDERED QUEST REVIEW ===");

        QuestIterator orderedIterator = questLog.iterator();

        while (orderedIterator.hasNext()) {

            Quest quest = orderedIterator.next();

            questsTraversed++;

            System.out.println(
                    "\nReviewing quest: "
                            + quest.getTitle()
            );

            hall.dispatch(
                    "captain",
                    "scout",
                    "Scout the area for quest: "
                            + quest.getTitle()
            );

            messagesRouted++;
            membersNotified++;

            hall.dispatch(
                    "captain",
                    "quartermaster",
                    "Prepare supplies for: "
                            + quest.getTitle()
            );

            messagesRouted++;
            membersNotified++;

            hall.dispatch(
                    "captain",
                    "healer",
                    "Prepare healing support for: "
                            + quest.getTitle()
            );

            messagesRouted++;
            membersNotified++;
        }

        /*
         * ITERATOR #2
         * Priority quests only
         */
        System.out.println("\n=== PRIORITY QUEST STRATEGY ===");

        QuestIterator priorityIterator =
                questLog.priorityIterator();

        while (priorityIterator.hasNext()) {

            Quest quest = priorityIterator.next();

            questsTraversed++;

            System.out.println(
                    "\nPriority council discussion: "
                            + quest.getTitle()
            );

            hall.dispatch(
                    "captain",
                    "all",
                    "Priority quest activated: "
                            + quest.getTitle()
            );

            messagesRouted++;

            /*
             * All guild members are notified.
             * Using party size as visible demo metric.
             */
            membersNotified += party.size();
        }

        /*
         * ITERATOR #3
         * Reverse order retrospective
         */
        System.out.println("\n=== REVERSE ORDER REVIEW ===");

        QuestIterator reverseIterator =
                questLog.reverseIterator();

        while (reverseIterator.hasNext()) {

            Quest quest = reverseIterator.next();

            questsTraversed++;

            System.out.println(
                    "Retrospective discussion: "
                            + quest.getTitle()
            );

            hall.dispatch(
                    "captain",
                    "lore",
                    "Archive council notes for: "
                            + quest.getTitle()
            );

            messagesRouted++;
            membersNotified++;
        }

        System.out.println("\n=================================");
        System.out.println("       COUNCIL SESSION END       ");
        System.out.println("=================================");

        return new CouncilRunResult(
                questsTraversed,
                messagesRouted,
                membersNotified
        );
    }
}