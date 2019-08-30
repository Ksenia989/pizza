package virtual.pizzeria.task.statistics;

import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
public class StatisticsRequest implements Serializable {
    private String type;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
    private Date timeFrom;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
    private Date timeTo;
}
