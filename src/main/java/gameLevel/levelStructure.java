package gameLevel;

public interface levelStructure {

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
}
