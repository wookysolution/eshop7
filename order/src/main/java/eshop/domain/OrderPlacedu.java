package eshop.domain;

import eshop.domain.*;
import eshop.infra.AbstractEvent;
import java.time.LocalDate;
import java.util.*;
import lombok.*;

//<<< DDD / Domain Event
@Data
@ToString
public class OrderPlacedu extends AbstractEvent {

    private Long id;
    private String userid;
    private Long productid;
    private String productname;
    private Integer qty;

    public OrderPlacedu(Order aggregate) {
        super(aggregate);
    }

    public OrderPlacedu() {
        super();
    }
}
//>>> DDD / Domain Event
