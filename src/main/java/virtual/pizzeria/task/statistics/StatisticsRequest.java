package virtual.pizzeria.task.statistics;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class StatisticsRequest {
    private String type;
    private Date timeFrom;
    private Date timeTo;
}
