package com.narxoz.rpg.quest;

public class Quest {

    private final String title;
    private final int difficulty;
    private final int reward;
    private final boolean priority;
    private final boolean completed;

    public Quest(
            String title,
            int difficulty,
            int reward,
            boolean priority,
            boolean completed
    ) {

        this.title = title;
        this.difficulty = difficulty;
        this.reward = reward;
        this.priority = priority;
        this.completed = completed;
    }

    public String getTitle() {
        return title;
    }

    public int getDifficulty() {
        return difficulty;
    }

    public int getReward() {
        return reward;
    }

    public boolean isPriority() {
        return priority;
    }

    public boolean isCompleted() {
        return completed;
    }

    @Override
    public String toString() {

        return "Quest{" +
                "title='" + title + '\'' +
                ", difficulty=" + difficulty +
                ", reward=" + reward +
                ", priority=" + priority +
                ", completed=" + completed +
                '}';
    }
}