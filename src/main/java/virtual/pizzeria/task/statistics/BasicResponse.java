package virtual.pizzeria.task.statistics;

import lombok.Getter;
import lombok.Setter;
import org.springframework.web.bind.annotation.ResponseBody;

@Getter
@Setter
@ResponseBody
public class BasicResponse {
    private String message;
    private int status;
}
