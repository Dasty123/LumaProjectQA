package api;


import org.testng.Assert;
import org.testng.annotations.Test;
import java.util.List;
import java.util.stream.Collectors;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.responseSpecification;

public class RegressTest {

    private final static String URL = "https://reqres.in/";

    @Test()
    public void checkAvatarAndIdTest() {
        Specification.installSpecification(Specification.requestSpecification(URL),Specification.responseSpecification(200));
        List<UserData> users = given()
                .when()
                .get("api/users?page=2")
                .then().log().all()
                .extract().body().jsonPath().getList("data", UserData.class);

        users.forEach(x -> Assert.assertTrue(x.getAvatar().contains(x.getId().toString())));

        Assert.assertTrue(users.stream().allMatch(x -> x.getEmail().endsWith("@reqres.in")));

        List<String> avatars = users.stream().map(UserData::getAvatar).toList();
        List<String> ids = users.stream().map(x -> x.getId().toString()).toList();

        for (int i = 0; i < avatars.size(); i++) {
            Assert.assertTrue(avatars.get(i).contains(ids.get(i)));
        }
    }

    @Test()
    public void successRegister(){
        Specification.installSpecification(Specification.requestSpecification(URL),Specification.responseSpecification(200));
        Integer id = 4;
        String token = "QpwL5tke4Pnpja7X4";
        Register user = new Register("eve.holt@reqres.in","pistol");
        SuccessReg successReg = given()
                .body(user)
                .when()
                .post("api/register")
                .then().log().all()
                .extract().as(SuccessReg.class);
        Assert.assertNotNull(successReg.getId());
        Assert.assertNotNull(successReg.getToken());

        Assert.assertEquals(id,successReg.getId());
        Assert.assertEquals(token,successReg.getToken());
    }

    @Test
    public void unSuccessTest(){
        Specification.installSpecification(Specification.requestSpecification(URL),Specification.responseSpecification(400));
        Register user = new Register("sydney@fife","");
        UnSuccessReg unSuccessReg = given()
                .body(user)
                .post("api/register")
                .then().log().all()
                .extract().as(UnSuccessReg.class);
        Assert.assertEquals("Missing password",unSuccessReg.getError());

    }

    @Test
    public void sortedYearsTest(){
        Specification.installSpecification(Specification.requestSpecification(URL),Specification.responseSpecification(200));
        List<ColorsData> colors = given()
                .when()
                .get("api/unknown")
                .then().log().all()
                .extract().body().jsonPath().getList("data",ColorsData.class);
        List<Integer> years = colors.stream().map(ColorsData::getYear).toList();
        List<Integer> sortedYears = years.stream().sorted().toList();
        Assert.assertEquals(sortedYears,years);
    }

    @Test
    public void delete(){
        Specification.installSpecification(Specification.requestSpecification(URL),Specification.responseSpecification(204));
        given()
                .when()
                .delete("api/users/2")
                .then().log().all();
    }



}
