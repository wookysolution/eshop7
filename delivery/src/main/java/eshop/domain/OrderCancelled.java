package eshop.domain;

import eshop.domain.*;
import eshop.infra.AbstractEvent;
import java.util.*;
import lombok.*;

@Data
@ToString
public class OrderCancelled extends AbstractEvent {

    private Long id;
    private String userid;
    private Long productid;
    private String productname;
    private Integer qty;
    private String status;
}
