package com.codeup.blog;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;




@Controller
public class DiceController {

    // roll-dice page:
    @GetMapping("/roll-dice")
    public String rollTheDice() {
        return "rollDice";
    }

    // roll-dice results page:
    @GetMapping("/roll-dice/{guess}")
    public String rollTheDice(@PathVariable int guess, Model model) {
        System.out.println(guess);
        int random = (int) Math.ceil(Math.random() * 6);
        model.addAttribute("random", random);
        model.addAttribute("guess", guess);


    // compares the guessed number to the roll-dice results
    Boolean guessedNumber;
        if (guess == random) {
            model.addAttribute("guessedNumber", true);
        } else {
            model.addAttribute("guessedNumber", false);
        }
        return "rollDiceResults";

    } // public String rollTheDice
}
// Controller class


