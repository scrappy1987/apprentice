package controllers.resource.play;

import com.fasterxml.jackson.databind.JsonNode;
import controllers.EndpointTestCase;
import play.libs.Json;
import play.mvc.Http;
import play.mvc.Result;
import play.test.Helpers;

import static play.test.Helpers.route;

/**
 * Created by a560832 on 20/11/2015.
 */
public class CreateAssetTestCase extends EndpointTestCase
{
    @Override protected void test()
    {
//        Http.RequestBuilder postRequest = new Http.RequestBuilder().method("POST").bodyJson(getJsonRequest())
//            .uri("/{Place endpoint URL here");
//        Result postResult = route(postRequest);
//        String projects = Helpers.contentAsString(postResult);
        //Add your test assertions here
    }

    private JsonNode getJsonRequest()
    {
//        return Json.newObject().put("jsonKey1", "jsonValue1").put("jsonKey2", "jsonValue2")
//                .put("jsonKey3", "jsonValue3");

        return null;
    }
}
