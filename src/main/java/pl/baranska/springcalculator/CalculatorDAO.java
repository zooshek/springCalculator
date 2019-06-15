package pl.baranska.springcalculator;

import lombok.Getter;
import org.springframework.stereotype.Service;

import java.util.LinkedHashSet;
import java.util.Set;

@Service
@Getter
public class CalculatorDAO {
    private Set<String> resultHistorySet = new LinkedHashSet<>();

    public void addToHistory(String result){
        resultHistorySet.add(result);
    }
}