package magentaHelperUi.helper;

import lombok.Getter;

public enum UserCredits {

    dastanFirstName("Dastan"),
    dastanLastName("Baidolotov"),
    dastanEmail("dastan2134@gmail.com"),
    dastanPassword("Dastan99");




    @Getter
    String credential;

    UserCredits(String credential) {
        this.credential = credential;
    }

}
