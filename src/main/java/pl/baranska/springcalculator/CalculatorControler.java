package pl.baranska.springcalculator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CalculatorControler {

    @Autowired //wstrzykniecie referencji pobranie pojedynczego obiektu
    CalculatorService calculatorService ;

    @Autowired
    CalculatorDAO calculatorDAO;

    //tutaj beda mapowane requesty na danego url
    @RequestMapping("/calculate")
    public String calculate(@RequestParam(required = false) String inputText, Model model){

        Double result = calculatorService.calculate(inputText==null?"":inputText);

        //Model jest mapa klucz i wartosc
        model.addAttribute("resultValue", result);



        if (inputText!=null) {
            //todo fixme -> single responsibility
            calculatorDAO.addToHistory(inputText+" = "+ result);
        }
        model.addAttribute("history", calculatorDAO.getResultHistorySet());
        //String oznacza nazwe template html nazwa html na ktory zostaniemy przeniesieni
        return "calculatorForm";
    }


}
