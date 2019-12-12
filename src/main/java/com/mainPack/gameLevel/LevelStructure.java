package com.mainPack.gameLevel;

/**
 * Lays out the methods needed for the levels
 */
public interface LevelStructure {

    void instantiateBackground();
    void createTimer();
    void start();
    void stop();
    void setNumber(int n);
    void setScore();
    void setEnds();
    void setFrog();
    void setLogs();
    void setTurtle();
    void setWetTurtle();
    void setObstacle();

    void newLevel();
}
