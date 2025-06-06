package Service;

import org.springframework.stereotype.Service;

@Service
public class CalcService {
    public int Add(int a, int b) {
        return a + b;
    }

    public TestModel GetModel(int id, String name) {
        return new TestModel(id, name);
    }
}
