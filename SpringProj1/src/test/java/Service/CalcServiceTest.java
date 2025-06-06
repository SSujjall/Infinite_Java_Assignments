package Service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.*;
class CalcServiceTest {
//    @Autowired yesle kaam nai garena idk why, need to look up more about this
    private CalcService _service;

    @BeforeEach
    public void setUp() {
        _service = new CalcService();
    }

    @Test
    void CalcService_Add_ReturnsCorrectValue() {
        int result = _service.Add(1,3);

        Assertions.assertEquals(4, result, "Returned value must be correct");
    }

    @Test
    void CalcService_ReturnModel_ReturnsCorrectModel() {
        TestModel expectedValue = new TestModel(1, "Sujal");

        TestModel result = _service.GetModel(1, "Sujal");

        Assertions.assertEquals(expectedValue, result, "Model must be correct");
    }
}