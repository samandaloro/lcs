package com.comcastsam.springbootlcs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;

@RestController
public class LCSController {

    @Autowired
    LCSService lcsService;

    @PostMapping("/lcs")
    public @ResponseBody LCSModel findLCS(@RequestBody(required = false) LCSModel setOfStrings) {
        //Throw appropriate exception if there is no POST body
        if (setOfStrings == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "POST body cannot be empty");
        }
        //Retrieve the list of Values from the payload
        ArrayList<Value> request = setOfStrings.getLcs();
        //Holder for the API response
        ArrayList<Value> result;
        try {
            result = lcsService.findLCS(request);
        } catch (NullPointerException npe) {
            //Catch errors related to malformed requests
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Request is not in the correct format");
        } catch (RuntimeException e) {
            //Catch errors related to data parsing (missing values, empty set etc.)
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }

        return new LCSModel(result);
    }

    @GetMapping("/lcs")
    public void getMethodNotAllowed(@RequestBody(required = false) LCSModel setOfStrings) throws ResponseStatusException {
        throw new ResponseStatusException(HttpStatus.METHOD_NOT_ALLOWED, "Request must be a POST");
    }

}
