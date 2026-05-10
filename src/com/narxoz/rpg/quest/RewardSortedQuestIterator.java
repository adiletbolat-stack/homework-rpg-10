package com.narxoz.rpg.quest;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class RewardSortedQuestIterator implements QuestIterator {

    private final List<Quest> snapshot;
    private int position;

    public RewardSortedQuestIterator(List<Quest> quests) {

        this.snapshot = new ArrayList<>(quests);


        this.snapshot.sort(
                Comparator.comparingInt(Quest::getReward)
                          .reversed()
        );

        this.position = 0;
    }

    @Override
    public boolean hasNext() {
        return position < snapshot.size();
    }

    @Override
    public Quest next() {
        return snapshot.get(position++);
    }
}