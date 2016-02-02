package controllers.resource.play;

import com.fasterxml.jackson.databind.JsonNode;
import models.services.Service;
import play.Logger;
import play.db.jpa.Transactional;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;

import java.util.HashMap;
import java.util.Map;

public abstract class ResourceEndpoint<T extends Service> extends Controller
{
    private static final Logger.ALogger logger = Logger.of(ResourceEndpoint.class);

    private T service;

    protected ResourceEndpoint(T service)
    {
        this.service = service;
    }

    // GET {path}/resource
    @Transactional public Result list()
    {
        JsonNode jsonResponse = service.list();
        return ok(jsonResponse);
    }

    // GET {path}/resource/:id
    @Transactional public Result find(Long id)
    {
        logger.info("find(id): " + id);
        JsonNode jsonResponse = service.find(getIdAsJson(id));

        logger.info("json response: " + jsonResponse);

        return ok(jsonResponse);
    }

    // POST {path}/resource
    @Transactional public Result create()
    {
        JsonNode jsonResponse = service.create(request().body().asJson());

        return ok(jsonResponse);
    }

    // PUT {path}/resource
    @Transactional public Result update()
    {
        JsonNode jsonResponse = service.update(request().body().asJson());

        return ok(jsonResponse);
    }

    // DELETE {path}/resource/:id
    @Transactional public Result delete(Long id)
    {
        JsonNode jsonResponse = service.delete(getIdAsJson(id));

        return ok(jsonResponse);
    }

    protected JsonNode getIdAsJson(Long id)
    {
        Map<String, String> idMap = new HashMap<String, String>();

        idMap.put("id", id.toString());

        return Json.toJson(idMap);
    }

    protected T getService()
    {
        return service;
    }
}
