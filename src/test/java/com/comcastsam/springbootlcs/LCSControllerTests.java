package com.comcastsam.springbootlcs;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

public class LCSControllerTests {

    @InjectMocks
    LCSController controller = new LCSController();

    @Mock
    LCSService service;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    @DisplayName("Test Submit POST Request")
    void testSubmitPostRequest() {
        ArrayList<Value> input = new ArrayList<>() {
            {
                add(new Value("comcast"));
                add(new Value("broadcast"));
                add(new Value("telecast"));
            }
        };
        ArrayList<Value> expectedValues = new ArrayList<>() {
            {
                add(new Value("cast"));
            }
        };

        LCSModel expectedModel = new LCSModel(expectedValues);
        when(service.findLCS(any())).thenReturn(expectedValues);
        LCSModel model = new LCSModel(input);
        LCSModel resultModel = controller.findLCS(model);

        assertEquals(expectedModel.toString(), resultModel.toString());
    }

    @Test
    @DisplayName("Test Get Request")
    public void testSubmitGetRequest() {
        Exception exception = assertThrows(ResponseStatusException.class, () -> {
            controller.getMethodNotAllowed(new LCSModel());
        });
        String errMsg = "405 METHOD_NOT_ALLOWED \"Request must be a POST\"";
        assertEquals(errMsg, exception.getMessage());
    }

    @Test
    @DisplayName("Test NullPointerException")
    void testNPE() {
        ArrayList<Value> input = new ArrayList<>() {
            {
                add(new Value("comcast"));
                add(new Value("broadcast"));
                add(new Value("telecast"));
            }
        };
        LCSModel model = new LCSModel(input);
        when(service.findLCS(any())).thenThrow(new NullPointerException("NPE"));
        Exception exception = assertThrows(ResponseStatusException.class, () -> {
            controller.findLCS(model);
        });

        String errMsg = "400 BAD_REQUEST \"Request is not in the correct format\"";
        assertEquals(errMsg, exception.getMessage());
    }

    @Test
    @DisplayName("Test Runtime Error ")
    void testRuntimeError() {
        ArrayList<Value> input = new ArrayList<>() {
            {
                add(new Value("comcast"));
                add(new Value("broadcast"));
                add(new Value("telecast"));
            }
        };
        LCSModel model = new LCSModel(input);
        when(service.findLCS(any())).thenThrow(new RuntimeException("Test Runtime Error Msg"));
        Exception exception = assertThrows(ResponseStatusException.class, () -> {
            controller.findLCS(model);
        });

        String errMsg = "400 BAD_REQUEST \"Test Runtime Error Msg\"";
        assertEquals(errMsg, exception.getMessage());
    }

}
