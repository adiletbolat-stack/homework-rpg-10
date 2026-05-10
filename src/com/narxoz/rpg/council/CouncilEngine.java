package com.narxoz.rpg.council;

import com.narxoz.rpg.combatant.Hero;
import com.narxoz.rpg.guild.GuildMediator;
import com.narxoz.rpg.quest.Quest;
import com.narxoz.rpg.quest.QuestIterator;
import com.narxoz.rpg.quest.QuestLog;

import java.util.List;

public class CouncilEngine {

    public CouncilRunResult runCouncil(
            List<Hero> party,
            QuestLog questLog,
            GuildMediator hall
    ) {

        int questsTraversed = 0;
        int messagesRouted = 0;
        int membersNotified = 0;

        System.out.println("\n=================================");
        System.out.println("      COUNCIL SESSION START");
        System.out.println("=================================");


        System.out.println("\n=== ORDERED QUEST REVIEW ===");

        QuestIterator orderedIterator =
                questLog.iterator();

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
                    "Scout terrain for quest: "
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
        }

   
        System.out.println("\n=== PRIORITY QUEST REVIEW ===");

        QuestIterator priorityIterator =
                questLog.priorityIterator();

        while (priorityIterator.hasNext()) {

            Quest quest = priorityIterator.next();

            questsTraversed++;

            System.out.println(
                    "\nPriority Quest: "
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
             * Approximate broadcast count
             */
            membersNotified += party.size();
        }

    
        System.out.println("\n=== HIGH REWARD ANALYSIS ===");

        QuestIterator rewardIterator =
                questLog.rewardSortedIterator();

        while (rewardIterator.hasNext()) {

            Quest quest = rewardIterator.next();

            questsTraversed++;

            System.out.println(
                    "\nHigh reward opportunity: "
                            + quest.getTitle()
            );

            hall.dispatch(
                    "captain",
                    "lore",
                    "Archive reward data for: "
                            + quest.getTitle()
            );

            messagesRouted++;
            membersNotified++;
        }

        System.out.println("\n=================================");
        System.out.println("       COUNCIL SESSION END");
        System.out.println("=================================");

        return new CouncilRunResult(
                questsTraversed,
                messagesRouted,
                membersNotified
        );
    }
}