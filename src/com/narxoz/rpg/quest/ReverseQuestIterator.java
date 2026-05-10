package com.narxoz.rpg.quest;

import java.util.ArrayList;
import java.util.List;

public class ReverseQuestIterator implements QuestIterator {

    private final List<Quest> snapshot;
    private int position;

    public ReverseQuestIterator(List<Quest> quests) {

        this.snapshot = new ArrayList<>(quests);
        this.position = snapshot.size() - 1;
    }

    @Override
    public boolean hasNext() {
        return position >= 0;
    }

    @Override
    public Quest next() {
        return snapshot.get(position--);
    }
}