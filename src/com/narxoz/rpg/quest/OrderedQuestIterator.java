package com.narxoz.rpg.quest;

import java.util.ArrayList;
import java.util.List;

public class OrderedQuestIterator implements QuestIterator {

    private final List<Quest> snapshot;
    private int position;

    public OrderedQuestIterator(List<Quest> quests) {

        this.snapshot = new ArrayList<>(quests);
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