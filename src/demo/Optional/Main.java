package demo.Optional;

import java.util.Optional;

public class Main {
    public static void main(String[] args) {
        Optional<Integer> op1 = Optional.empty();
        Optional<Integer> op2 = Optional.of(1);
        Optional<Integer> op3 = Optional.ofNullable(null);
        if(op3.isPresent()) {
            // có giá trị khác null
        }else{
            // có giá trị là null
        }
    }
}
