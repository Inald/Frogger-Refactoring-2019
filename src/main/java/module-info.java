module Frogger.SWM {
    requires javafx.graphics;
    requires javafx.controls;
    requires javafx.media;
    opens com.mainPack to javafx.graphics, javafx.fxml;
}