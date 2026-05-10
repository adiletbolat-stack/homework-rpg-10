package com.narxoz.rpg;

import com.narxoz.rpg.combatant.Hero;
import com.narxoz.rpg.council.CouncilEngine;
import com.narxoz.rpg.council.CouncilRunResult;
import com.narxoz.rpg.guild.Captain;
import com.narxoz.rpg.guild.GuildHall;
import com.narxoz.rpg.guild.Healer;
import com.narxoz.rpg.guild.Loremaster;
import com.narxoz.rpg.guild.Quartermaster;
import com.narxoz.rpg.guild.Scout;
import com.narxoz.rpg.quest.Quest;
import com.narxoz.rpg.quest.QuestIterator;
import com.narxoz.rpg.quest.QuestLog;

import java.util.ArrayList;
import java.util.List;

/**
 * Entry point for Homework 10 — The Adventurers' Guild: Iterator + Mediator.
 */
public class Main {

    public static void main(String[] args) {

        System.out.println(
                "=== Homework 10 Demo: Iterator + Mediator ==="
        );


        List<Hero> party = new ArrayList<>();

        party.add(new Hero("Ion", 100, 20, 10, 5, 2));
        party.add(new Hero("Linda",  80, 15, 12, 8, 3));
        party.add(new Hero("David",  90, 25, 8, 6, 4));

        System.out.println("\n=== HERO PARTY ===");

        for (Hero hero : party) {
            System.out.println(hero.getName());
        }

   
        QuestLog log = new QuestLog();

        log.addQuest(new Quest(
                "Goblin Camp",
                2,
                150,
                false,
                false
        ));

        log.addQuest(new Quest(
                "Dragon Hunt",
                10,
                5000,
                true,
                false
        ));

        log.addQuest(new Quest(
                "Escort Caravan",
                4,
                600,
                false,
                true
        ));

        log.addQuest(new Quest(
                "Necromancer Tower",
                9,
                3200,
                true,
                false
        ));

        log.addQuest(new Quest(
                "Bandit Ambush",
                5,
                900,
                false,
                false
        ));

  
        GuildHall hall = new GuildHall();

        Captain captain =
                new Captain("Roderick");

        Scout scout =
                new Scout("Vale");

        Healer healer =
                new Healer("Luna");

        Quartermaster quartermaster =
                new Quartermaster("Borin");

        Loremaster loremaster =
                new Loremaster("Eldric");

        hall.register(captain);
        hall.register(scout);
        hall.register(healer);
        hall.register(quartermaster);
        hall.register(loremaster);

    
        System.out.println(
                "\n=== ORDERED QUEST ITERATION ==="
        );

        QuestIterator orderedIterator =
                log.iterator();

        while (orderedIterator.hasNext()) {

            Quest quest = orderedIterator.next();

            System.out.println(
                    quest.getTitle()
            );
        }

        System.out.println(
                "\n=== PRIORITY QUEST ITERATION ==="
        );

        QuestIterator priorityIterator =
                log.priorityIterator();

        while (priorityIterator.hasNext()) {

            Quest quest = priorityIterator.next();

            System.out.println(
                    quest.getTitle()
            );
        }

 
        System.out.println(
                "\n=== GUILD COMMUNICATION TEST ==="
        );

        captain.commandScout(
                "Scout the northern forest."
        );

        scout.reportDanger(
                "Enemy patrol discovered!"
        );

        healer.requestHerbs(
                "Need additional healing herbs."
        );

        quartermaster.supplyUpdate(
                "Supplies are prepared."
        );

        loremaster.archiveNotice(
                "Council records updated."
        );

  
        System.out.println(
                "\n=== RUNNING COUNCIL ENGINE ==="
        );

        CouncilEngine engine =
                new CouncilEngine();

        CouncilRunResult result =
                engine.runCouncil(
                        party,
                        log,
                        hall
                );

       
        System.out.println(result);
    }
}