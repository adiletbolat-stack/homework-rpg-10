package com.narxoz.rpg.quest;

import java.util.ArrayList;
import java.util.List;

/**
 * Aggregate root for quests.
 *
 * The internal list is deliberately hidden. Clients must request a
 * QuestIterator instead of reaching into the aggregate's collection.
 */
public class QuestLog {

    private final List<Quest> quests;

    public QuestLog() {
        this.quests = new ArrayList<>();
    }

    public void addQuest(Quest quest) {
        quests.add(quest);
    }

    public QuestIterator iterator() {
        return new OrderedQuestIterator(quests);
    }

    public QuestIterator reverseIterator() {
        return new ReverseQuestIterator(quests);
    }

    public QuestIterator priorityIterator() {
        return new PriorityQuestIterator(quests);
    }

    public QuestIterator rewardSortedIterator() {
        return new RewardSortedQuestIterator(quests);
    }
}
