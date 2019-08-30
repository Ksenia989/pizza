package virtual.pizzeria.task.statistics;

import lombok.Getter;
import lombok.Setter;
import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
public class StatisticsRequest implements Serializable {
    private TaskType type;
    private Date timeFrom;
    private Date timeTo;
}
