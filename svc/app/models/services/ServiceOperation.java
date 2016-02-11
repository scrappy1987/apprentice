package models.services;

import com.fasterxml.jackson.databind.JsonNode;
import play.Logger;

public abstract class ServiceOperation
{
    public JsonNode execute(JsonNode jsonRequest)
    {
        JsonNode jsonResponse = null;

        try
        {
            //Application Level Authentication / Authorization /

            //Audit processing
            Logger.info("*********In ServiceOperation******");
            jsonResponse = doExecute(jsonRequest);
        }
        catch (Exception e)
        {
            Logger.info("Exception message: " + e.getMessage(),e);
        }

        return jsonResponse;
    }

     protected abstract JsonNode doExecute(JsonNode jsonRequest);
}
